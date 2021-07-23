package com.sjmulhern.dndTracker.tools;

import com.google.gson.JsonObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;

public class Ability {

    private StringProperty name = null;

    private StringProperty description = null;

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.getValue();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public String getDescription() {
        return description.getValue();
    }

    public Ability(String name, String description) {
        setName(name);
        setDescription(description);
    }


    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name.getValue());
        jsonObject.addProperty("description", description.getValue());

        return  jsonObject;
    }

}
