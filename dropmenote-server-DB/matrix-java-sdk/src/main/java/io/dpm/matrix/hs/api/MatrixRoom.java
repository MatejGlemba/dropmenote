/*
 * matrix-java-sdk - Matrix Client SDK for Java
 * Copyright (C) 2017 Kamax Sarl
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

package io.dpm.matrix.hs.api;

import com.google.gson.JsonObject;

import io.dpm.matrix.room.ReceiptType;
import io.dpm.matrix.room.Tag;
import io.dpm.matrix.room.api.MatrixRoomMessageChunk;
import io.dpm.matrix.room.api.MatrixRoomMessageChunkOptions;
import io.dpm.matrix.MatrixErrorInfo;
import io.dpm.matrix.api.MatrixContent;
import io.dpm.matrix.api.MatrixID;
import io.dpm.matrix.api.MatrixUserProfile;
import io.dpm.matrix.room.*;

import java.util.List;

import java8.util.Optional;

public interface MatrixRoom {

    MatrixHomeserver getHomeserver();

    String getAddress();

    Optional<String> getName();

    Optional<String> getTopic();

    Optional<String> getAvatarUrl();

    Optional<MatrixContent> getAvatar();

    String getId();

    /**
     * Get a state event
     * 
     * @param type
     *            The type of state to look for
     * @return An optional JsonObject representing the content key of the event
     */
    Optional<JsonObject> getState(String type);

    /**
     * Get a state event
     * 
     * @param type
     *            The type of state to look for
     * @param key
     *            The state key to match
     * @return An optional JsonObject representing the content key of the event
     */
    Optional<JsonObject> getState(String type, String key);

    void join();

    void join(List<String> servers);

    Optional<MatrixErrorInfo> tryJoin();

    Optional<MatrixErrorInfo> tryJoin(List<String> servers);

    void leave();

    Optional<MatrixErrorInfo> tryLeave();

    void kick(MatrixID user);

    void kick(MatrixID user, String reason);

    Optional<MatrixErrorInfo> tryKick(MatrixID user);

    Optional<MatrixErrorInfo> tryKick(MatrixID user, String reason);

    String sendEvent(String type, JsonObject content);

    String sendText(String message);

    String sendFormattedText(String formatted, String rawFallback);

    String sendNotice(String message);

    String sendNotice(String formatted, String plain);

    /**
     * Send a receipt for an event
     * 
     * @param type
     *            The receipt type to send
     * @param eventId
     *            The Event ID targeted by the receipt
     */
    void sendReceipt(String type, String eventId);

    /**
     * Send a receipt for an event
     * 
     * @param type
     *            The receipt type to send
     * @param eventId
     *            The Event ID targeted by the receipt
     */
    void sendReceipt(ReceiptType type, String eventId);

    /**
     * Send a Read receipt for an event
     * 
     * @param eventId
     *            The Event ID targeted by the read receipt
     */
    void sendReadReceipt(String eventId);

    void invite(MatrixID mxId);

    List<MatrixUserProfile> getJoinedUsers();

    MatrixRoomMessageChunk getMessages(MatrixRoomMessageChunkOptions options);

    List<Tag> getAllTags();

    List<Tag> getUserTags();

    void addUserTag(String tag);

    void addUserTag(String tag, double order);

    void deleteUserTag(String tag);

    void addFavouriteTag();

    void addFavouriteTag(double order);

    void deleteFavouriteTag();

    Optional<Tag> getFavouriteTag();

    void addLowpriorityTag();

    void addLowpriorityTag(double order);

    Optional<Tag> getLowpriorityTag();

    void deleteLowpriorityTag();
}
