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
        jsonObject.addProperty("shape", shape.name());
        jsonObject.addProperty("requirements", requirements);

        return jsonObject;
    }

    public Spell(JsonObject jsonObject) {
        this(jsonObject.get("name").toString(),
             jsonObject.get("effect").toString(),
             jsonObject.get("size").getAsInt(),
             Shape.valueOf(jsonObject.get("shape").getAsString()),
             jsonObject.get("requirements").toString());
    }

}
