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

import io.dpm.matrix.client.MatrixClientContext;
import io.dpm.matrix.client.MatrixClientRequestException;
import io.dpm.matrix.client.MatrixHttpTest;
import io.dpm.matrix.client.MatrixPasswordCredentials;
import io.dpm.matrix.hs.MatrixHomeserverImpl;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AMatrixHttpClientLoginTest extends MatrixHttpTest {

    protected String wrongPassword = "wrongPassword";

    protected String errorInvalidPassword = "Invalid password";
    protected String errorInvalidPasswordResponse = String.format(errorResponseTemplate, errcodeForbidden,
            errorInvalidPassword);

    @Override
    public void logout() {
    }

    @Override
    public void login() {
    }

    @Test
    public void loginAndLogout() throws URISyntaxException {
        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs);
        MatrixHttpClient client = new MatrixHttpClient(context);

        MatrixPasswordCredentials credentials = new MatrixPasswordCredentials(user.getLocalPart(), password);
        client.login(credentials);

        assertTrue(StringUtils.isNotBlank(client.getAccessToken().get()));
        assertTrue(StringUtils.isNotBlank(client.getDeviceId().get()));
        assertTrue(StringUtils.isNotBlank(client.getUser().get().getId()));

        client.logout();
    }

    @Test
    public void loginWithDeviceIdAndLogout() throws URISyntaxException {
        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs);
        MatrixHttpClient client = new MatrixHttpClient(context);

        MatrixPasswordCredentials credentials = new MatrixPasswordCredentials(user.getLocalPart(), password);
        client.login(credentials);

        String deviceId = client.getDeviceId().get();

        client.logout();

        context = new MatrixClientContext(hs).setDeviceId(deviceId);
        client = new MatrixHttpClient(context);
        client.login(credentials);

        assertTrue(StringUtils.isNotBlank(client.getAccessToken().get()));
        assertTrue(StringUtils.isNotBlank(client.getDeviceId().get()));
        assertTrue(StringUtils.isNotBlank(client.getUser().get().getId()));
        assertEquals(deviceId, client.getDeviceId().get());

        client.logout();
    }

    @Test
    public void loginWithDeviceNameAndLogout() {
        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs).setInitialDeviceName("initialDeviceName");
        MatrixHttpClient client = new MatrixHttpClient(context);

        MatrixPasswordCredentials credentials = new MatrixPasswordCredentials(user.getLocalPart(), password);
        client.login(credentials);

        assertTrue(StringUtils.isNotBlank(client.getAccessToken().get()));
        assertTrue(StringUtils.isNotBlank(client.getDeviceId().get()));
        assertTrue(StringUtils.isNotBlank(client.getUser().get().getId()));

        client.logout();
    }

    @Test
    public void loginWrongPassword() throws URISyntaxException {
        MatrixHomeserverImpl hs = new MatrixHomeserverImpl(domain, baseUrl);
        MatrixClientContext context = new MatrixClientContext(hs);
        MatrixHttpClient client = new MatrixHttpClient(context);

        MatrixPasswordCredentials credentials = new MatrixPasswordCredentials(user.getLocalPart(), wrongPassword);
        MatrixClientRequestException e = assertThrows(MatrixClientRequestException.class,
                () -> client.login(credentials));
        checkErrorInfo(errcodeForbidden, "Invalid password", e.getError());
    }

}
