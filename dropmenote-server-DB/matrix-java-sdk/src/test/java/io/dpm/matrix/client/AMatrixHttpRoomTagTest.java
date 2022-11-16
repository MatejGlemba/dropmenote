/*
 * matrix-java-sdk - Matrix Client SDK for Java
 * Copyright (C) 2018 Arne Augenstein
 * Copyright (C) 2018 Kamax Sarl
 *
 * https://www.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.dpm.matrix.client;

import io.dpm.matrix.client.api.SyncData;
import io.dpm.matrix.client.regular.SyncOptions;
import io.dpm.matrix.event.api.MatrixAccountDataEvent;
import io.dpm.matrix.event.api.MatrixEvent;
import io.dpm.matrix.hs.api.MatrixRoom;
import io.dpm.matrix.json.MatrixJsonEventFactory;
import io.dpm.matrix.json.event.MatrixJsonRoomTagsEvent;
import io.dpm.matrix.room.RoomCreationOptionsImpl;
import io.dpm.matrix.room.Tag;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java8.util.Optional;
import java8.util.stream.StreamSupport;

import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AMatrixHttpRoomTagTest extends MatrixHttpTest {

    protected String testTag = "usertag";
    protected String testTagWithOrder = "usertagWithOrder";
    protected Double testTagOrder = 0.5;
    private String testRoomName = "TagTestRoom";

    @Test
    public void setAndReadTags() {
        MatrixRoom room = getAndPrepareRoom();

        room.addFavouriteTag();
        room.addLowpriorityTag();
        room.addUserTag(testTag);
        room.addUserTag(testTagWithOrder, testTagOrder);

        assertTrue(room.getUserTags().size() == 2);

        Optional<Tag> roomTagWithOrder = StreamSupport.stream(room.getUserTags())
                .filter(tag -> testTagWithOrder.equals(tag.getName())).findFirst();
        assertTrue(roomTagWithOrder.isPresent());
        assertTrue(roomTagWithOrder.get().getOrder().get().doubleValue() == testTagOrder);

        Optional<Tag> roomTag = StreamSupport.stream(room.getUserTags()).filter(tag -> testTag.equals(tag.getName()))
                .findFirst();
        assertTrue(roomTag.isPresent());
        assertFalse(roomTag.get().getOrder().isPresent());

        assertTrue(room.getFavouriteTag().isPresent());
        assertTrue(room.getLowpriorityTag().isPresent());

        room.deleteFavouriteTag();
        room.deleteLowpriorityTag();
        room.deleteUserTag(testTag);
        room.deleteUserTag(testTagWithOrder);

        assertTrue(room.getUserTags().isEmpty());
        assertFalse(room.getFavouriteTag().isPresent());
        assertFalse(room.getLowpriorityTag().isPresent());
    }

    @Test
    public void setTagWithOrderOutOfRange() {
        MatrixRoom room = getAndPrepareRoom();

        assertThrows(IllegalArgumentException.class, () -> room.addUserTag("test", -1.0));
        assertThrows(IllegalArgumentException.class, () -> room.addUserTag("test", -0.1));
        assertThrows(IllegalArgumentException.class, () -> room.addUserTag("test", 1.1));
    }

    @Test
    public void readTagsFromSync() {
        MatrixRoom room = getAndPrepareRoom();

        room.addFavouriteTag();
        room.addUserTag(testTag);

        SyncData syncData = client.sync(SyncOptions.build().get());
        Optional<SyncData.JoinedRoom> roomFromSync = StreamSupport.stream(syncData.getRooms().getJoined())
                .filter(joinedRoom -> room.getId().equals(joinedRoom.getId())).findFirst();

        assertTrue(roomFromSync.isPresent());

        boolean userTagFound = false;
        boolean favouriteTagFound = false;

        for (MatrixAccountDataEvent event : roomFromSync.get().getAccountData().getEvents()) {
            MatrixEvent parsedEvent = MatrixJsonEventFactory.get(event.getJson());
            if (parsedEvent instanceof MatrixJsonRoomTagsEvent) {
                List<Tag> tags = ((MatrixJsonRoomTagsEvent) parsedEvent).getTags();
                List<String> tagNames = tags.stream().map(it -> it.getNamespace() + "." + it.getName())
                        .collect(Collectors.toList());
                if (tagNames.contains("u." + testTag)) {
                    userTagFound = true;
                }

                if (tagNames.contains("m.favourite")) {
                    favouriteTagFound = true;
                }
            }
        }

        assertTrue(userTagFound);
        assertTrue(favouriteTagFound);

        room.deleteFavouriteTag();
        room.deleteUserTag(testTag);
    }

    private MatrixRoom getAndPrepareRoom() {
        MatrixRoom room = null;

        for (MatrixRoom joinedRoom : client.getJoinedRooms()) {
            if (joinedRoom.getName().isPresent() && testRoomName.equals(joinedRoom.getName().get())) {
                room = joinedRoom;
                break;
            }
        }

        if (room == null) {
            RoomCreationOptionsImpl.Builder roomOptions = new RoomCreationOptionsImpl.Builder().setName(testRoomName);
            room = client.createRoom(roomOptions.get());
        }

        if (room.getFavouriteTag().isPresent()) {
            room.deleteFavouriteTag();
        }

        if (room.getLowpriorityTag().isPresent()) {
            room.deleteLowpriorityTag();
        }

        for (Tag tag : room.getUserTags()) {
            room.deleteUserTag(tag.getName());
        }

        // Assert, that we start with a clean room without tags
        assertTrue(room.getUserTags().isEmpty());
        return room;
    }

}
