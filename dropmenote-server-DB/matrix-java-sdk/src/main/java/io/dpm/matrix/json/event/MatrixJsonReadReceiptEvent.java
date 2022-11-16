/*
 * matrix-java-sdk - Matrix Client SDK for Java
 * Copyright (C) 2018 Arne Augenstein
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
 *
 */

package io.dpm.matrix.json.event;

import com.google.gson.JsonObject;

import io.dpm.matrix.event.api.ReadReceiptEvent;
import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.json.GsonUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

public class MatrixJsonReadReceiptEvent extends MatrixJsonEphemeralEvent implements ReadReceiptEvent {

    /**
     * Read receipts for a specific event.
     */
    public static class Receipt {
        /**
         * ID of the event, the read markers point to.
         */
        private String eventId;

        /**
         * Every user whose read marker is set to the event specified by eventId
         * and it's point in time when this marker has been set to this event.
         */
        private Map<MatrixIDImpl, Long> users;

        public Receipt(String id, Map<MatrixIDImpl, Long> readMarkers) {
            this.eventId = id;
            this.users = readMarkers;
        }

        public Map<MatrixIDImpl, Long> getUsersWithTimestamp() {
            return users;
        }

        public Set<MatrixIDImpl> getUsers() {
            return users.keySet();
        }

        public String getEventId() {
            return eventId;
        }
    }

    private List<Receipt> receipts;

    @Override
    public List<Receipt> getReceipts() {
        return receipts;
    }

    public MatrixJsonReadReceiptEvent(JsonObject obj) {
        super(obj);

        JsonObject content = getObj("content");
        List<String> eventIds = StreamSupport.stream(content.entrySet()).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        receipts = StreamSupport.stream(eventIds).map(id -> {
            JsonObject targetEvent = content.getAsJsonObject(id);
            JsonObject mRead = targetEvent.getAsJsonObject("m.read");

            Map<MatrixIDImpl, Long> readMarkers = StreamSupport.stream(mRead.entrySet())
                    .collect(Collectors.toMap(it -> MatrixIDImpl.asAcceptable(it.getKey()),
                            it -> GsonUtil.getLong(it.getValue().getAsJsonObject(), "ts")));
            return new Receipt(id, readMarkers);
        }).collect(Collectors.toList());
    }

}
