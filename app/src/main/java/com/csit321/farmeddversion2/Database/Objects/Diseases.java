package com.csit321.farmeddversion2.Database.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Diseases")
public class Diseases {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Name of Disease")
    private String diseaseName;
    @ColumnInfo(name = "Description")
    private String description;
    @ColumnInfo(name = "mitigationsNon")
    private String mitigationsNon;
    @ColumnInfo(name = "mitigationsChemical")
    private String mitigationsChemical;
    @ColumnInfo(name = "protectiveMeasures")
    private String protectiveMeasures;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "link")
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMitigationsNon() {
        return mitigationsNon;
    }

    public void setMitigationsNon(String mitigationsNon) {
        this.mitigationsNon = mitigationsNon;
    }

    public String getMitigationsChemical() {
        return mitigationsChemical;
    }

    public void setMitigationsChemical(String mitigationsChemical) {
        this.mitigationsChemical = mitigationsChemical;
    }

    public String getProtectiveMeasures() {
        return protectiveMeasures;
    }

    public void setProtectiveMeasures(String protectiveMeasures) {
        this.protectiveMeasures = protectiveMeasures;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static Diseases[] populateData() {
        return new Diseases[] {

        };
    }
}
