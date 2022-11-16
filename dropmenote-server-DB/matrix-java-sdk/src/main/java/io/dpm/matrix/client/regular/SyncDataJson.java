/*
 * matrix-java-sdk - Matrix Client SDK for Java
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

package io.dpm.matrix.client.regular;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.api.MatrixID;
import io.dpm.matrix.client.api.SyncData;
import io.dpm.matrix.event.EventKey;
import io.dpm.matrix.event.api.MatrixAccountDataEvent;
import io.dpm.matrix.event.api.MatrixEphemeralEvent;
import io.dpm.matrix.event.api.MatrixPersistentEvent;
import io.dpm.matrix.event.api.MatrixStateEvent;
import io.dpm.matrix.json.MatrixJsonObject;

import java.util.*;

public class SyncDataJson extends MatrixJsonObject implements SyncData {

    public class MatrixPersistentEventJson extends MatrixJsonObject implements MatrixPersistentEvent {

        public MatrixPersistentEventJson(JsonObject obj) {
            super(obj);
        }

        @Override
        public String getId() {
            return findString(EventKey.Id.get()).orElse(""); // FIXME refactor event structure
        }

        @Override
        public String getType() {
            return getString(EventKey.Type.get());
        }

        @Override
        public Long getTime() {
            return getLong(EventKey.Timestamp.get());
        }

        @Override
        public MatrixID getSender() {
            return MatrixIDImpl.from(getString(EventKey.Sender.get())).acceptable();
        }
    }

    public class MatrixEphemeralEventJson extends MatrixJsonObject implements MatrixEphemeralEvent {

        public MatrixEphemeralEventJson(JsonObject obj) {
            super(obj);
        }

        @Override
        public String getType() {
            return getString(EventKey.Type.get());
        }

    }

    public class MatrixAccountDataEventJson extends MatrixJsonObject implements MatrixAccountDataEvent {

        public MatrixAccountDataEventJson(JsonObject obj) {
            super(obj);
        }

        @Override
        public String getType() {
            return getString(EventKey.Type.get());
        }

    }

    public class MatrixStateEventJson extends MatrixPersistentEventJson implements MatrixStateEvent {

        public MatrixStateEventJson(JsonObject obj) {
            super(obj);
        }

        @Override
        public String getStateKey() {
            return getString(EventKey.StateKey.get());
        }

    }

    public class StateJson extends MatrixJsonObject implements SyncData.State {

        private List<MatrixStateEvent> events = new ArrayList<>();

        public StateJson(JsonObject obj) {
            super(obj);

            findArray("events").ifPresent(array -> {
                for (JsonElement el : array) {
                    events.add(new MatrixStateEventJson(asObj(el)));
                }
            });
        }

        @Override
        public List<MatrixStateEvent> getEvents() {
            return events;
        }
    }

    public class TimelineJson extends MatrixJsonObject implements SyncData.Timeline {

        private List<MatrixPersistentEvent> events = new ArrayList<>();

        public TimelineJson(JsonObject obj) {
            super(obj);

            findArray("events").ifPresent(array -> {
                for (JsonElement el : array) {
                    events.add(new MatrixPersistentEventJson(asObj(el)));
                }
            });
        }

        @Override
        public List<MatrixPersistentEvent> getEvents() {
            return events;
        }

        @Override
        public boolean isLimited() {
            return findString("limited").map("true"::equals).orElse(false);
        }

        @Override
        public String getPreviousBatchToken() {
            return getString("prev_batch");
        }
    }

    public class EphemeralJson extends MatrixJsonObject implements SyncData.Ephemeral {

        private List<MatrixEphemeralEvent> events = new ArrayList<>();

        public EphemeralJson(JsonObject obj) {
            super(obj);

            findArray("events").ifPresent(array -> {
                for (JsonElement el : array) {
                    events.add(new MatrixEphemeralEventJson(asObj(el)));
                }
            });
        }

        @Override
        public List<MatrixEphemeralEvent> getEvents() {
            return events;
        }
    }

    public class AccountDataJson extends MatrixJsonObject implements SyncData.AccountData {

        private List<MatrixAccountDataEvent> events = new ArrayList<>();

        public AccountDataJson(JsonObject obj) {
            super(obj);

            findArray("events").ifPresent(array -> {
                for (JsonElement el : array) {
                    events.add(new MatrixAccountDataEventJson(asObj(el)));
                }
            });
        }

        @Override
        public List<MatrixAccountDataEvent> getEvents() {
            return events;
        }
    }

    public class InvitedRoomJson extends MatrixJsonObject implements SyncData.InvitedRoom {

        private String id;
        private State state;

        public InvitedRoomJson(String id, JsonObject data) {
            super(data);
            this.id = id;
            this.state = new StateJson(findObj("invite_state").orElseGet(JsonObject::new));
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public State getState() {
            return state;
        }
    }

    public class UnreadNotificationsJson extends MatrixJsonObject implements SyncData.UnreadNotifications {

        private long highlights;
        private long global;

        public UnreadNotificationsJson(JsonObject data) {
            super(data);
            this.highlights = findLong("highlight_count").orElse(0L);
            this.global = findLong("notification_count").orElse(0L);
        }

        @Override
        public long getHighlightCount() {
            return highlights;
        }

        @Override
        public long getNotificationCount() {
            return global;
        }

    }

    public class JoinedRoomJson extends MatrixJsonObject implements SyncData.JoinedRoom {

        private String id;
        private State state;
        private Timeline timeline;
        private UnreadNotifications unreadNotifications;
        private Ephemeral ephemeral;
        private AccountData accountData;

        public JoinedRoomJson(String id, JsonObject data) {
            super(data);
            this.id = id;
            this.state = new StateJson(findObj("state").orElseGet(JsonObject::new));
            this.timeline = new TimelineJson(findObj("timeline").orElseGet(JsonObject::new));
            this.unreadNotifications = new UnreadNotificationsJson(computeObj("unread_notifications"));
            this.ephemeral = new EphemeralJson(findObj("ephemeral").orElseGet(JsonObject::new));
            this.accountData = new AccountDataJson(findObj("account_data").orElseGet(JsonObject::new));
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public State getState() {
            return state;
        }

        @Override
        public Timeline getTimeline() {
            return timeline;
        }

        @Override
        public Ephemeral getEphemeral() {
            return ephemeral;
        }

        @Override
        public AccountData getAccountData() {
            return accountData;
        }

        @Override
        public UnreadNotifications getUnreadNotifications() {
            return unreadNotifications;
        }
    }

    public class LeftRoomJson extends MatrixPersistentEventJson implements SyncData.LeftRoom {

        private String id;
        private State state;
        private Timeline timeline;

        public LeftRoomJson(String id, JsonObject data) {
            super(data);
            this.id = id;
            this.state = new StateJson(findObj("state").orElseGet(JsonObject::new));
            this.timeline = new TimelineJson(findObj("timeline").orElseGet(JsonObject::new));
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public State getState() {
            return state;
        }

        @Override
        public Timeline getTimeline() {
            return timeline;
        }
    }

    public class RoomsJson extends MatrixJsonObject implements SyncData.Rooms {

        private Set<InvitedRoom> invited = new HashSet<>();
        private Set<JoinedRoom> joined = new HashSet<>();
        private Set<LeftRoom> left = new HashSet<>();

        public RoomsJson(JsonObject obj) {
            super(obj);
            findObj("invite").ifPresent(o -> {
                for (Map.Entry<String, JsonElement> entry : o.entrySet()) {
                    invited.add(new InvitedRoomJson(entry.getKey(), asObj(entry.getValue())));
                }
            });

            findObj("join").ifPresent(o -> {
                for (Map.Entry<String, JsonElement> entry : o.entrySet()) {
                    joined.add(new JoinedRoomJson(entry.getKey(), asObj(entry.getValue())));
                }
            });

            findObj("leave").ifPresent(o -> {
                for (Map.Entry<String, JsonElement> entry : o.entrySet()) {
                    left.add(new LeftRoomJson(entry.getKey(), asObj(entry.getValue())));
                }
            });
        }

        @Override
        public Set<InvitedRoom> getInvited() {
            return invited;
        }

        @Override
        public Set<JoinedRoom> getJoined() {
            return joined;
        }

        @Override
        public Set<LeftRoom> getLeft() {
            return left;
        }

    }

    private String nextBatch;
    private AccountDataJson accountData;
    private RoomsJson rooms;

    public SyncDataJson(JsonObject data) {
        super(data);
        nextBatch = getString("next_batch");
        accountData = new AccountDataJson(findObj("account_data").orElseGet(JsonObject::new));
        rooms = new RoomsJson(findObj("rooms").orElseGet(JsonObject::new));
    }

    @Override
    public String nextBatchToken() {
        return nextBatch;
    }

    @Override
    public AccountData getAccountData() {
        return accountData;
    }

    @Override
    public Rooms getRooms() {
        return rooms;
    }

}
