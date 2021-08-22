package com.sjmulhern.dndTracker.tools;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ability {

    private String name;

    private String description;

    public Ability(JsonObject jsonObject) {
        this(jsonObject.get("name").getAsString(), jsonObject.get("description").getAsString());
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("description", description);

        return jsonObject;
    }
}
