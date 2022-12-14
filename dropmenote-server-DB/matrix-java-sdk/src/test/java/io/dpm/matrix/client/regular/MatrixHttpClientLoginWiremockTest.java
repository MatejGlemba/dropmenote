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
package io.dpm.matrix.client.regular;

import org.junit.Test;

import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MatrixHttpClientLoginWiremockTest extends AMatrixHttpClientLoginTest {
    private String loginUrl = "/_matrix/client/r0/login";
    private String logoutUrl = "/_matrix/client/r0/logout";
    private String deviceId = "testDeviceId_892377";

    @Test
    @Override
    public void loginAndLogout() throws URISyntaxException {
        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + password + "\"}"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"user_id\": \"" + user.getId() + "\"," + //
                                "\"access_token\": \"" + testToken + "\"," + //
                                "\"home_server\": \"" + hostname + "\"," + //
                                "\"device_id\": \"" + deviceId + "\"}")));

        stubFor(post(urlEqualTo(logoutUrl)));

        super.loginAndLogout();

        verify(postRequestedFor(urlEqualTo(logoutUrl)).withHeader("Authorization", equalTo("Bearer " + testToken)));
    }

    @Test
    @Override
    public void loginWithDeviceIdAndLogout() throws URISyntaxException {
        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + password + "\"}"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"user_id\": \"" + user.getId() + "\"," + //
                                "\"access_token\": \"" + testToken + "\"," + //
                                "\"home_server\": \"" + hostname + "\"," + //
                                "\"device_id\": \"" + deviceId + "\"}")));

        stubFor(post(urlEqualTo(logoutUrl)));

        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + password + "\"," + //
                        "\"device_id\": \"" + deviceId + "\"}"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"user_id\": \"" + user.getId() + "\"," + //
                                "\"access_token\": \"" + testToken + "\"," + //
                                "\"home_server\": \"" + hostname + "\"," + //
                                "\"device_id\": \"" + deviceId + "\"}")));

        super.loginWithDeviceIdAndLogout();
    }

    @Test
    @Override
    public void loginWithDeviceNameAndLogout() {
        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + password + "\"," + //
                        "\"initial_device_display_name\": \"initialDeviceName\"}"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"user_id\": \"" + user.getId() + "\"," + //
                                "\"access_token\": \"" + testToken + "\"," + //
                                "\"home_server\": \"" + hostname + "\"," + //
                                "\"device_id\": \"" + deviceId + "\"}")));

        stubFor(post(urlEqualTo(logoutUrl)));

        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + password + "\"," + //
                        "\"device_id\": \"" + deviceId + "\"}"))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{\"user_id\": \"" + user.getId() + "\"," + //
                                "\"access_token\": \"" + testToken + "\"," + //
                                "\"home_server\": \"" + hostname + "\"," + //
                                "\"device_id\": \"" + deviceId + "\"}")));

        super.loginWithDeviceNameAndLogout();
    }

    @Test
    @Override
    public void loginWrongPassword() throws URISyntaxException {
        stubFor(post(urlEqualTo(loginUrl))
                .withRequestBody(equalToJson("{\"type\": \"m.login.password\"," + //
                        "\"user\": \"" + user.getLocalPart() + "\"," + //
                        "\"password\": \"" + wrongPassword + "\"}"))
                .willReturn(aResponse().withStatus(403).withBody(errorInvalidPasswordResponse)));

        super.loginWrongPassword();
    }

}
