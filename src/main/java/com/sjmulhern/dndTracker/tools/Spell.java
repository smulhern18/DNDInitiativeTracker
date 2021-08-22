package com.sjmulhern.dndTracker.tools;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Spell {

    String name;

    String effect;

    Integer size;

    Shape shape;

    String requirements;

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("effect", effect);
        jsonObject.addProperty("size", size);
        jsonObject.addProperty("shape", shape.ordinal());
        jsonObject.addProperty("requirements", requirements);

        return jsonObject;
    }

    public Spell(JsonObject jsonObject) {
        this(
                jsonObject.get("name").getAsString(),
                jsonObject.get("effect").getAsString(),
                jsonObject.get("size").getAsInt(),
                Shape.getEnum(jsonObject.get("shape").getAsInt()),
                jsonObject.get("requirements").getAsString());
    }
}
