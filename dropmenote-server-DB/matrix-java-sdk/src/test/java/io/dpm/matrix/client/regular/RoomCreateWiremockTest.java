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

import com.google.gson.JsonObject;

import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.client.MatrixClientContext;
import io.dpm.matrix.client.MatrixHttpTest;
import io.dpm.matrix.hs.MatrixHomeserverImpl;
import io.dpm.matrix.hs.api.MatrixRoom;
import io.dpm.matrix.json.GsonUtil;
import io.dpm.matrix.room.RoomCreationOptionsImpl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.TestCase.assertTrue;

public class RoomCreateWiremockTest extends MatrixHttpTest {

    private final String syncPath = "/_matrix/client/r0/createRoom";

    @Test
    public void createRoomWithNoOption() throws Exception {
        String roomId = "!roomId:" + domain;
        JsonObject resBody = new JsonObject();
        resBody.addProperty("room_id", roomId);
        String resBodyRaw = GsonUtil.get().toJson(resBody);
        stubFor(post(urlPathEqualTo("/_matrix/client/r0/createRoom"))
                .willReturn(aResponse().withStatus(200).withBody(resBodyRaw)));

        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs, MatrixIDImpl.asValid("@user:localhost"), "test");
        MatrixHttpClient client = new MatrixHttpClient(context);

        MatrixRoom room = client.createRoom(RoomCreationOptionsImpl.none());
        assertTrue(StringUtils.equals(room.getAddress(), roomId));

        verify(postRequestedFor(urlPathEqualTo(syncPath)));
    }

}
