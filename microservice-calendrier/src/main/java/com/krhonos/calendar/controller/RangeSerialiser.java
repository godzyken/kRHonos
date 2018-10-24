package com.krhonos.calendar.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.krhonos.calendar.model.Range;

import java.lang.reflect.Type;

public class RangeSerialiser implements JsonSerializer<Range> {

    @Override
    public JsonElement serialize(Range range, Type typeOfSrc, final JsonSerializationContext context) {

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty( "start", range.getDateStart().toString());

        if (range.getDateEnd() != null)
        {
            jsonObject.addProperty("end", range.getDateEnd().toString());
        }

        return jsonObject;
    }
}
