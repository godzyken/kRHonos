package com.krhonos.calendar.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.krhonos.calendar.model.Planning;
import com.krhonos.calendar.model.Ranges;

import java.lang.reflect.Type;

public class RangeSerialiser implements JsonSerializer<Ranges> {

    @Override
    public JsonElement serialize(Ranges ranges, Type typeOfSrc, final JsonSerializationContext context) {

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty( "start", ranges.getDateStart().toString());

        if (ranges.getDateEnd() != null)
        {
            jsonObject.addProperty("end", ranges.getDateEnd().toString());
        }

        return jsonObject;
    }
}
