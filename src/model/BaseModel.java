package model;

import java.util.UUID;

public abstract class BaseModel {
    protected UUID id;

    protected String name;

    public BaseModel() {
        this.id = UUID.randomUUID();
    }

    public BaseModel(String name) {
        this();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
