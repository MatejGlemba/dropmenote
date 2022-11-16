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

package io.dpm.matrix.json.event;

import com.google.gson.JsonObject;

import io.dpm.matrix.event.api.RoomMembershipEvent;
import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.api.MatrixID;
import io.dpm.matrix.json.MatrixJsonObject;

import java8.util.Optional;

public class MatrixJsonRoomMembershipEvent extends MatrixJsonRoomEvent implements RoomMembershipEvent {

    public static class Content extends MatrixJsonObject {

        private String membership;
        private String avatar;
        private String displayName;

        public Content(JsonObject obj) {
            super(obj);

            setMembership(getString("membership"));
            setAvatar(avatar = getStringOrNull("avatar_url"));
            setDisplayName(displayName = getStringOrNull("displayname"));
        }

        public String getMembership() {
            return membership;
        }

        public void setMembership(String membership) {
            this.membership = membership;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

    }

    protected Content content;
    private MatrixID invitee;

    public MatrixJsonRoomMembershipEvent(JsonObject obj) {
        super(obj);

        content = new Content(getObj("content"));
        invitee = new MatrixIDImpl(getString("state_key"));
    }

    @Override
    public String getMembership() {
        return content.getMembership();
    }

    @Override
    public Optional<String> getAvatarUrl() {
        return Optional.ofNullable(content.getAvatar());
    }

    @Override
    public Optional<String> getDisplayName() {
        return Optional.ofNullable(content.getDisplayName());
    }

    @Override
    public MatrixID getInvitee() {
        return invitee;
    }

}
