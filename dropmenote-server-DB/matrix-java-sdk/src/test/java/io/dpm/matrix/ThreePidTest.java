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

package io.dpm.matrix;

import io.dpm.matrix.api.ThreePid;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ThreePidTest {

    private static String medium1 = "email";
    private static String address1 = "john.doe@example.org";
    private static String medium2 = "msisdn";
    private static String address2 = "123456789";

    @Test
    public void basic() {
        ThreePid tp1 = new io.dpm.matrix.ThreePid(medium1, address1);
        assertTrue(medium1.contentEquals(tp1.getMedium()));
        assertTrue(address1.contentEquals(tp1.getAddress()));
    }

    @Test
    public void equal() {
        ThreePid tp11 = new io.dpm.matrix.ThreePid(medium1, address1);
        ThreePid tp12 = new io.dpm.matrix.ThreePid(medium1, address1);
        ThreePid tp21 = new io.dpm.matrix.ThreePid(medium2, address2);
        ThreePid tp22 = new io.dpm.matrix.ThreePid(medium2, address2);

        assertTrue(tp11.equals(tp12));
        assertTrue(tp12.equals(tp11));
        assertTrue(tp21.equals(tp22));
        assertTrue(tp22.equals(tp21));
        assertTrue(!tp11.equals(tp21));
        assertTrue(!tp22.equals(tp12));
    }
}
