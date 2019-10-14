package com.csit321.farmeddversion2.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.csit321.farmeddversion2.Database.DAO.DiseasesDAO;
import com.csit321.farmeddversion2.Database.DAO.PestsDAO;
import com.csit321.farmeddversion2.Database.DAO.PlantTypesDAO;
import com.csit321.farmeddversion2.Database.DAO.PlantVarietiesDAO;
import com.csit321.farmeddversion2.Database.Objects.Diseases;
import com.csit321.farmeddversion2.Database.Objects.Pests;
import com.csit321.farmeddversion2.Database.Objects.PlantTypes;
import com.csit321.farmeddversion2.Database.Objects.PlantVarieties;

import java.util.concurrent.Executors;

@Database(entities = {Pests.class, PlantVarieties.class, PlantTypes.class, Diseases.class}, version = 9)
public abstract class FarmEdDatabase extends RoomDatabase {

    private static FarmEdDatabase INSTANCE;

    public abstract DiseasesDAO diseasesDAO();
    public abstract PestsDAO pestsDAO();
    public abstract PlantTypesDAO plantTypesDAO();
    public abstract PlantVarietiesDAO plantVarietiesDAO();


    public synchronized static FarmEdDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static FarmEdDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                FarmEdDatabase.class,
                "mydb")
                .allowMainThreadQueries()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Inserting Diseases");
                                getInstance(context).diseasesDAO().insertAll(Diseases.populateData());
                                System.out.println(getInstance(context).diseasesDAO().getAll());
                                System.out.println("Inserting Pests");
                                getInstance(context).pestsDAO().insertAll(Pests.populateData());
                                System.out.println(getInstance(context).pestsDAO().getAll());
                                System.out.println("Inserting Plant Types");
                                getInstance(context).plantTypesDAO().insertAll(PlantTypes.populateData());
                                System.out.println(getInstance(context).plantTypesDAO().getAll());
                                System.out.println("Inserting Plant Varieties");
                                getInstance(context).plantVarietiesDAO().insertAll(PlantVarieties.populateData());
                                System.out.println(getInstance(context).plantVarietiesDAO().getAll());
                            }
                        };
                        Thread t = new Thread(r);
                        t.start();
                    }
                })
                .fallbackToDestructiveMigration()
                .build();
    }

}
