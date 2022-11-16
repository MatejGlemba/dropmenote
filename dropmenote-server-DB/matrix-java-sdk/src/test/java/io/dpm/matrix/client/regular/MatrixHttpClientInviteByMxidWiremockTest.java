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

import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.client.MatrixClientContext;
import io.dpm.matrix.client.MatrixHttpTest;
import io.dpm.matrix.hs.MatrixHomeserverImpl;

import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MatrixHttpClientInviteByMxidWiremockTest extends MatrixHttpTest {

    private final String roomId = "!id:" + domain;
    private final String path = "/_matrix/client/r0/rooms/" + roomId + "/invite";

    private String getJson() {
        return "{}";
    }

    @Test
    public void doInvite() throws Exception {
        stubFor(post(urlPathEqualTo(path)).willReturn(aResponse().withStatus(200).withBody(getJson())));

        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs, MatrixIDImpl.from("bob", domain).valid(), "test");
        MatrixHttpClient client = new MatrixHttpClient(context);
        client.getRoom(roomId).invite(MatrixIDImpl.from("alice", domain).valid());

        verify(postRequestedFor(urlPathEqualTo(path)));
    }

}
