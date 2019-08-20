package com.csit321.farmeddversion2.db;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

public class PlantGenus {
    @PrimaryKey
    @NonNull
    public String id;

    public String genus;
}
