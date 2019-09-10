package com.csit321.farmeddversion2.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Plant Types")
public class PlantType {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Name Of Plant")
    private String plantTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlantTypeName() {
        return plantTypeName;
    }

    public void setPlantTypeName(String plantTypeName) {
        this.plantTypeName = plantTypeName;
    }
}
