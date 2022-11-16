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

import io.dpm.matrix.api.MatrixID;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixIDImplTest {

    private static String validMxId1 = "@john.doe:example.org";
    private static String validMxId2 = "@john.doe:example.com";
    private static String validMxId3 = "@JoHn.dOe:ExamPLE.ORG";
    private static String validMxid4 = "@john:example.org:8449";
    private static String validMxid5 = "@john:::1:8449";

    private static String invalidMxId1 = "john.doe:example.org";
    private static String invalidMxId2 = "@john.doeexample.org";
    private static String invalidMxId3 = "john.doe";
    private static String invalidMxId4 = "@:";
    private static String invalidMxId5 = "@john.doe:";

    @Test
    public void validMatrixIDs() {
        MatrixID mxId1 = new MatrixIDImpl(validMxId1);
        MatrixID mxId3 = new MatrixIDImpl(validMxId3);
        MatrixID mxId4 = new MatrixIDImpl(validMxid4);
        MatrixID mxId5 = new MatrixIDImpl(validMxid5);
        assertTrue(validMxId1.contentEquals(mxId1.getId()));
        assertTrue("john.doe".contentEquals(mxId1.getLocalPart()));
        assertTrue("example.org".contentEquals(mxId1.getDomain()));
        assertTrue("example.org:8449".contentEquals(mxId4.getDomain()));
        assertTrue("::1:8449".contentEquals(mxId5.getDomain()));
    }

    @Test
    public void validateEqual() {
        MatrixID mxId1 = new MatrixIDImpl(validMxId1);
        MatrixID mxId2 = new MatrixIDImpl(validMxId1);
        MatrixID mxId3 = new MatrixIDImpl(validMxId2);

        assertTrue(mxId1.equals(mxId2));
        assertTrue(mxId2.equals(mxId1));
        assertTrue(!mxId1.equals(mxId3));
        assertTrue(!mxId2.equals(mxId3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMatrixIDs1() {
        new MatrixIDImpl(invalidMxId1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMatrixIDs2() {
        new MatrixIDImpl(invalidMxId2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMatrixIDs3() {
        new MatrixIDImpl(invalidMxId3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMatrixIDs4() {
        new MatrixIDImpl(invalidMxId4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidMatrixIDs5() {
        new MatrixIDImpl(invalidMxId5);
    }

}
