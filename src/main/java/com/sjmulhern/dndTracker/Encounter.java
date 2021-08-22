package com.sjmulhern.dndTracker;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Encounter {

    private String name;

    private String description;

    private InitativeRoundRobin initativeRoundRobin;

    public Encounter(JsonObject jsonObject) {
        setName(jsonObject.get("name").getAsString());
        setDescription(jsonObject.get("description").getAsString());
        setInitativeRoundRobin(new InitativeRoundRobin(jsonObject.get("initativeRoundRobin").getAsJsonObject()));
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("description", description);
        jsonObject.add("initativeRoundRobin", initativeRoundRobin.toJson());

        return jsonObject;
    }
}
