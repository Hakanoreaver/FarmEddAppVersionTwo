package com.csit321.farmeddversion2.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.csit321.farmeddversion2.Database.Objects.Diseases;
import com.csit321.farmeddversion2.Database.Objects.Pests;
import com.csit321.farmeddversion2.Database.Objects.PlantVarieties;

import java.util.List;

@Dao
public interface PestsDAO
{
    @Insert
    void insertAll(Pests... pests);

    @Query("SELECT * FROM Pests")
    List<Pests> getAll();

    @Query("SELECT * FROM Pests WHERE id = :id")
    Pests findById(int id);
}
