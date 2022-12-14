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

package io.dpm.matrix.room.api;

import io.dpm.matrix.event.api.MatrixPersistentEvent;

import java.util.List;

/**
 * Room messages pagination chunk.
 */
public interface MatrixRoomMessageChunk {

    /**
     * The token the pagination starts from.
     * 
     * @return the token.
     */
    String getStartToken();

    /**
     * The token the pagination ends at.
     * 
     * @return the token.
     */
    String getEndToken();

    /**
     * A list of room events.
     * 
     * @return the list.
     */
    List<MatrixPersistentEvent> getEvents();

}
