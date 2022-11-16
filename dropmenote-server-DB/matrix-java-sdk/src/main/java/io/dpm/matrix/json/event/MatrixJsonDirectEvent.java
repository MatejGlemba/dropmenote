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

package io.dpm.matrix.json.event;

import com.google.gson.JsonObject;

import io.dpm.matrix.event.api.DirectEvent;
import io.dpm.matrix.MatrixIDImpl;
import io.dpm.matrix.api.MatrixID;
import io.dpm.matrix.json.GsonUtil;
import io.dpm.matrix.json.InvalidJsonException;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixJsonDirectEvent extends MatrixJsonEphemeralEvent implements DirectEvent {

    private Map<MatrixID, List<String>> mappings = new HashMap<>();

    public MatrixJsonDirectEvent(JsonObject obj) {
        super(obj);

        if (!StringUtils.equals(Type, getType())) { // FIXME check should be done in the abstract class
            throw new InvalidJsonException("Type is not " + Type);
        }

        getObj("content").entrySet().forEach(entry -> {
            if (!entry.getValue().isJsonArray()) {
                throw new InvalidJsonException("Content key " + entry.getKey() + " is not an array");
            }
            MatrixID id = MatrixIDImpl.asAcceptable(entry.getKey());
            mappings.put(id, GsonUtil.asList(entry.getValue().getAsJsonArray(), String.class));
        });
    }

    @Override
    public Map<MatrixID, List<String>> getMappings() {
        return Collections.unmodifiableMap(mappings);
    }

}
