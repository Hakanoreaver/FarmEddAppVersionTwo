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
public interface DiseasesDAO {
    @Query("SELECT * FROM Diseases")
    List<Diseases> getAll();

    @Insert
    void insertAll(Diseases... diseases);

    @Query("SELECT * FROM Diseases WHERE id = :id")
    Diseases findById(int id);
}
