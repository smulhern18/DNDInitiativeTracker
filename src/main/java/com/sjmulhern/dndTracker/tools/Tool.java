package com.sjmulhern.dndTracker.tools;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tool {

    private String name = null;

    private String description = null;

    private DamageType damageType = DamageType.None;

    private String toHit = null;

    private String damage = null;

    public Tool(JsonObject jsonObject) {
        this(
                jsonObject.get("name").toString(),
                jsonObject.get("description").toString(),
                DamageType.getEnum(jsonObject.get("damageType").getAsInt()),
                jsonObject.get("toHit").toString(),
                jsonObject.get("damage").toString());
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("description", getDescription());
        jsonObject.addProperty("damageType", getDamageType().ordinal());
        jsonObject.addProperty("toHit", getToHit());
        jsonObject.addProperty("damage", getDamage());

        return jsonObject;
    }
}
