package com.sjmulhern.dndTracker.tools;

import com.google.gson.JsonObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
        
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("description", getDescription());
        jsonObject.addProperty("damageType", getDamageType().toString());
        jsonObject.addProperty("toHit", getToHit());
        jsonObject.addProperty("damage", getDamage());

        return jsonObject;
    }
}
