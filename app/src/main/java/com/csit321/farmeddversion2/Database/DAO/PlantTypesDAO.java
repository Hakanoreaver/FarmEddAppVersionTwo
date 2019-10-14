package com.csit321.farmeddversion2.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.csit321.farmeddversion2.Database.Objects.PlantTypes;

import java.util.List;

@Dao
public interface PlantTypesDAO
{
    @Insert
    void insertAll(PlantTypes... plantTypes);


    @Query("SELECT * FROM PlantTypes")
    List<PlantTypes> getAll();


}