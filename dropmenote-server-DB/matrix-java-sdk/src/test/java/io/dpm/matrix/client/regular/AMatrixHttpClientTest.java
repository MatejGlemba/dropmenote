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

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AMatrixHttpClientTest extends MatrixHttpTest {
    protected String displayName = "display name";

    @Test
    public void setDisplayName() throws URISyntaxException {
        createClientObject().setDisplayName(displayName);
    }

    @Test
    public void setDisplayNameErrorRateLimited() throws URISyntaxException {
        MatrixClientRequestException e = assertThrows(MatrixClientRequestException.class,
                () -> createClientObject().setDisplayName(displayName));
        checkErrorInfoRateLimited(e);
    }

    private MatrixHttpClient createClientObject() throws URISyntaxException {
        MatrixClientContext context = getOrCreateClientContext();
        return new MatrixHttpClient(context);
    }
}
