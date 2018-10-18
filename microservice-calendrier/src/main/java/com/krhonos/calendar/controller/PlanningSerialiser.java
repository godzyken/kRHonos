package com.krhonos.calendar.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.krhonos.calendar.model.Planning;

import java.lang.reflect.Type;

public class PlanningSerialiser implements JsonSerializer<Planning> {

<<<<<<< HEAD
  @Override
  public JsonElement serialize(Planning planning, Type typeOfSrc, final JsonSerializationContext context) {
    final JsonObject jsonObject = new JsonObject();

    jsonObject.addProperty("id", planning.getId());
    jsonObject.addProperty("start", planning.getTimeStart().toString());
    jsonObject.addProperty("end", planning.getTimeEnd().toString());
    final JsonElement jsonDow = context.serialize(planning.getDow());
    jsonObject.add("dow", jsonDow);
    final JsonElement jsonRanges = context.serialize(planning.getRange());
    jsonObject.add("ranges", jsonRanges);

    return jsonObject;
  }
=======
    @Override
    public JsonElement serialize(Planning planning, Type typeOfSrc, final JsonSerializationContext context) {

        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", planning.getId());
        jsonObject.addProperty("start", planning.getTimeStart().toString());
        jsonObject.addProperty("end", planning.getTimeEnd().toString());
        final JsonElement jsonDow = context.serialize(planning.getDow());
        jsonObject.add("dow", jsonDow);
        final JsonElement jsonRanges = context.serialize(planning.getRange());
        jsonObject.add("ranges", jsonRanges);

        return jsonObject;
    }
>>>>>>> master
}
