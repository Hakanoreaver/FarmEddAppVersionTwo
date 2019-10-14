package com.csit321.farmeddversion2.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.csit321.farmeddversion2.Database.Objects.Diseases;
import com.csit321.farmeddversion2.Database.Objects.PlantVarieties;

import java.util.List;
@Dao
public interface PlantVarietiesDAO
{
    @Insert
    void insertAll(PlantVarieties... plantVarieties);

    @Query("SELECT * FROM PlantVarieties")
    List<PlantVarieties> getAll();

    @Query("SELECT * FROM PlantVarieties WHERE cropName = :type")
    List<PlantVarieties> findByType(String type);

    @Query("SELECT * FROM PlantVarieties WHERE id = :id")
    PlantVarieties findById(int id);
}