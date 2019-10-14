package com.csit321.farmeddversion2.Database.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Pests")
public class Pests {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "pestName")
    private String pestName;
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

    public String getPestName() {
        return pestName;
    }

    public void setPestName(String pestName) {
        this.pestName = pestName;
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

    public Pests(int id, String pestName, String description, String mitigationsNon, String mitigationsChemical, String protectiveMeasures, String image, String link)
	{
		this.id = id;
		this.pestName = pestName;
		this.description = description;
		this.mitigationsNon = mitigationsNon;
		this.mitigationsChemical = mitigationsChemical;
		this.protectiveMeasures = protectiveMeasures;
		this.image = image;
		this.link = link;
	}

    public static Pests[] populateData() {
        return new Pests[] {

        };
    }
}
