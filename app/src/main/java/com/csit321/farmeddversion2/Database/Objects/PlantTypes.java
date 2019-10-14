package com.csit321.farmeddversion2.Database.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PlantTypes")
public class PlantTypes
{
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

    public PlantTypes(String plantTypeName) {
        this.plantTypeName = plantTypeName;
    }

    public static PlantTypes[] populateData() {
        return new PlantTypes[] {
                new PlantTypes("Banana"),
                new PlantTypes("Bitter Gourd"),
                new PlantTypes("Cassava"),
                new PlantTypes("Cauliflower"),
                new PlantTypes("Coconuts"),
                new PlantTypes("Cucumber"),
                new PlantTypes("Eggplant"),
                new PlantTypes("Maize"),
                new PlantTypes("Rice"),
                new PlantTypes("Sweet Potato"),
                new PlantTypes("Taro"),
        };
    }

    @Override
    public String toString() {
       return plantTypeName;
    }
}
