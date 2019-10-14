package com.csit321.farmeddversion2.Database.Objects;

        import android.arch.persistence.room.ColumnInfo;
        import android.arch.persistence.room.Entity;
        import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PlantVarieties") //Table name
public class PlantVarieties
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    String cropName;
    @ColumnInfo
    String varietyName;
    @ColumnInfo
    String suitableSoils;
    @ColumnInfo
    String unsuitableSoils;
    @ColumnInfo
    double phMin;
    @ColumnInfo
    double phMax;
    @ColumnInfo
    int temperatureMin;
    @ColumnInfo
    int getTemperatureMax;
    @ColumnInfo
    String droughtTolerance;
    @ColumnInfo
    String pestAndDiseases;
    @ColumnInfo
    int cropDurationMin;
    @ColumnInfo
    int cropDurationMax;
    @ColumnInfo
    String otherInformation;
    @ColumnInfo
    String reference;
    @ColumnInfo
    String location;
    @ColumnInfo
    String season;
    @ColumnInfo
    String bestTimeToGrow;
    @ColumnInfo
    int averageYield;
    @ColumnInfo
    String yieldUnit;
    @ColumnInfo
    String yieldReference;
    @ColumnInfo
    double seedRate;
    @ColumnInfo
    String seedRateUnit;
    @ColumnInfo
    String seedRateReference;
    @ColumnInfo
    String images;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getSuitableSoils() {
        return suitableSoils;
    }

    public void setSuitableSoils(String suitableSoils) {
        this.suitableSoils = suitableSoils;
    }

    public String getUnsuitableSoils() {
        return unsuitableSoils;
    }

    public void setUnsuitableSoils(String unsuitableSoils) {
        this.unsuitableSoils = unsuitableSoils;
    }

    public double getPhMin() {
        return phMin;
    }

    public void setPhMin(double phMin) {
        this.phMin = phMin;
    }

    public double getPhMax() {
        return phMax;
    }

    public void setPhMax(double phMax) {
        this.phMax = phMax;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public int getGetTemperatureMax() {
        return getTemperatureMax;
    }

    public void setGetTemperatureMax(int getTemperatureMax) {
        this.getTemperatureMax = getTemperatureMax;
    }

    public String getDroughtTolerance() {
        return droughtTolerance;
    }

    public void setDroughtTolerance(String droughtTolerance) {
        this.droughtTolerance = droughtTolerance;
    }

    public String getPestAndDiseases() {
        return pestAndDiseases;
    }

    public void setPestAndDiseases(String pestAndDiseases) {
        this.pestAndDiseases = pestAndDiseases;
    }

    public int getCropDurationMin() {
        return cropDurationMin;
    }

    public void setCropDurationMin(int cropDurationMin) {
        this.cropDurationMin = cropDurationMin;
    }

    public int getCropDurationMax() {
        return cropDurationMax;
    }

    public void setCropDurationMax(int cropDurationMax) {
        this.cropDurationMax = cropDurationMax;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getBestTimeToGrow() {
        return bestTimeToGrow;
    }

    public void setBestTimeToGrow(String bestTimeToGrow) {
        this.bestTimeToGrow = bestTimeToGrow;
    }

    public int getAverageYield() {
        return averageYield;
    }

    public void setAverageYield(int averageYield) {
        this.averageYield = averageYield;
    }

    public String getYieldUnit() {
        return yieldUnit;
    }

    public void setYieldUnit(String yieldUnit) {
        this.yieldUnit = yieldUnit;
    }

    public String getYieldReference() {
        return yieldReference;
    }

    public void setYieldReference(String yieldReference) {
        this.yieldReference = yieldReference;
    }

    public double getSeedRate() {
        return seedRate;
    }

    public String getSeedRateUnit() {
        return seedRateUnit;
    }

    public void setSeedRateUnit(String seedRateUnit) {
        this.seedRateUnit = seedRateUnit;
    }

    public String getSeedRateReference() {
        return seedRateReference;
    }

    public void setSeedRateReference(String seedRateReference) {
        this.seedRateReference = seedRateReference;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public PlantVarieties(String cropName, String varietyName, String suitableSoils, double phMin, double phMax, int temperatureMin, int getTemperatureMax, String droughtTolerance, String pestAndDiseases, int cropDurationMin, int cropDurationMax, String otherInformation, String reference, String location, String season, String bestTimeToGrow, int averageYield, String yieldUnit, String yieldReference, double seedRate, String seedRateUnit, String seedRateReference, String images) {
        this.cropName = cropName;
        this.varietyName = varietyName;
        this.suitableSoils = suitableSoils;
        this.unsuitableSoils = unsuitableSoils;
        this.phMin = phMin;
        this.phMax = phMax;
        this.temperatureMin = temperatureMin;
        this.getTemperatureMax = getTemperatureMax;
        this.droughtTolerance = droughtTolerance;
        this.pestAndDiseases = pestAndDiseases;
        this.cropDurationMin = cropDurationMin;
        this.cropDurationMax = cropDurationMax;
        this.otherInformation = otherInformation;
        this.reference = reference;
        this.location = location;
        this.season = season;
        this.bestTimeToGrow = bestTimeToGrow;
        this.averageYield = averageYield;
        this.yieldUnit = yieldUnit;
        this.yieldReference = yieldReference;
        this.seedRate = seedRate;
        this.seedRateUnit = seedRateUnit;
        this.seedRateReference = seedRateReference;
        this.images = images;
    }

    public static PlantVarieties[] populateData() {
        return new PlantVarieties[] {
                //Bananas
                new PlantVarieties("Banana", "Veimama", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                new PlantVarieties("Banana", "Jaina Balavu,", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                new PlantVarieties("Banana", "Jaina Leka", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round","Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                new PlantVarieties("Banana", "Lady Finger", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null) ,
                new PlantVarieties("Banana", "Smith", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                new PlantVarieties("Banana", "Mili", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                new PlantVarieties("Banana", "Timoci", "Rich, dark, fertile soils", 4.5,5.2, 26,30, null, "Prone to: Weeds, Fungal and Viral Disease, Black Sigatoka Disease, Banana Aphid, Banana Weevil, Banana Root Nematodes",270, 270, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 4950, "kg", null, 1668, "Plants/Hectare", null, null),
                //Gourds
                new PlantVarieties("Bitter Gourd", "Pusa Do Mausmi", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Coimbatore Long", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Akra Harit", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "VK-1-Priya", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Phule Priyanka", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Phule Green", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Phule Ujwala", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                new PlantVarieties("Bitter Gourd", "Pride of Gujarat", "well drained sandy to sandy loam; medium black soils rich in organic matter. Alluvial soil along the river beds is also good for production of bitter gourds", 5.5, 6.7, 20, 30, null, "Prone to: Brown Weevils, Pumpkin Beetle, Squash Bugs",49, 49, null, null, null, "Wet", "Best in wet/hot seasons October to December; May to July ", 9900, "kg", null, 4, "kg", null, null),
                //Casava
                new PlantVarieties("Cassava", "Beqa", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Farm Management Manual 2014", "All", "Year Round", "Year Round", 24000, "kg",  null, 40, "kg", null, null),
                new PlantVarieties("Cassava", "Yabia Damu", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000,  "kg",  null,40, "kg", null, null),
                new PlantVarieties("Cassava", "New Guinea", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, "Wet conditions after maturity cause root rot, delayed harvest and substandard quality", "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000, "kg", null, 40, "kg", null, null),
                new PlantVarieties("Cassava", "Sokobale", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000, "kg", null, 40, "kg", null, null),
                new PlantVarieties("Cassava", "Nadelei", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000, "kg", null, 40, "kg", null, null),
                new PlantVarieties("Cassava", "Vulatolu", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000, "kg", null, 40, "kg", null, null),
                new PlantVarieties("Cassava", "Nuinui", " Highly tolerant to acid soils, and has formed a symbiotic association with soil fungi that help its roots take up phosphorus and micronutrients.", 4.5, 6.5, 30, 30, null, "Prone to: Red Spider Mite, Black Scale & White, Peach Scale, Spiraling white fly", 240, 240, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 24000, "kg", null, 40, "kg", null, null),
                //Cauliflower
                new PlantVarieties("Cauliflower", "Tropical Sureheart",  "Loamy", 6.5, 6.8, 20, 23, null, "Prone to: Lepidopteran pest, Diamond Back moth, Large cabbage moth, Centre grub, Greasy cutworm:", 65, 80, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Dry", "April to August", 9900,  "kg", null, 120, "Plants/Hectare", null, null),
                new PlantVarieties("Cauliflower", "Snowqueen",  "Loamy", 6.5, 6.8, 20, 23, null, "Prone to: Lepidopteran pest, Diamond Back moth, Large cabbage moth, Centre grub, Greasy cutworm:", 65, 80, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Dry", "April to August", 9900,  "kg", null, 120, "Plants/Hectare", null, null),
                new PlantVarieties("Cauliflower", "White Contessa",  "Loamy", 6.5, 6.8, 20, 23, null, "Prone to: Lepidopteran pest, Diamond Back moth, Large cabbage moth, Centre grub, Greasy cutworm:", 65, 80, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Dry", "April to August", 9900,  "kg", null, 120, "Plants/Hectare", null, null),
                new PlantVarieties("Cauliflower", "Market Wonder", "Loamy", 6.5, 6.8, 20, 23, null, "Prone to: Lepidopteran pest, Diamond Back moth, Large cabbage moth, Centre grub, Greasy cutworm:", 65, 80, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Dry", "April to August", 9900, "kg", null, 120, "Plants/Hectare", null, null),
                new PlantVarieties("Cauliflower", "Pioneer", "Loamy", 6.5, 6.8, 20, 23, null, "Prone to: Lepidopteran pest, Diamond Back moth, Large cabbage moth, Centre grub, Greasy cutworm:", 65, 80, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Dry", "April to August", 9900, "kg", null, 120, "Plants/Hectare", null, null),
                //Coconuts
                new PlantVarieties("Coconuts", "Fiji Tall",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Rotuman Tall",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Niu Leka",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Niu Magimagi",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881, "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Niu Kitu",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Niu Yabia",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                new PlantVarieties("Coconuts", "Malayen Red",  "light sandy and sandy-loam soil", 5.2, 6.8, 21, 33, null, "Prone to: Weeds, Bud Rot, Rhinoceros Beetle, Stick Insect", 2190, 2190, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "October to April", 11881,  "kg", null, 123, "Plants/Hectare", null, null),
                //Cucumber
                new PlantVarieties("Cucumber", "Early Set",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Cascade",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Bountiful No.2",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Space Master",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Early Perfection",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Mili",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                new PlantVarieties("Cucumber", "Timoci",  "loose, well-drained soil rich with nutritious organic matter, such as compost or manure.", 6.0, 7.0, 16, 35, null, "Prone to: Weeds, Gummy Stem Blight, Downey Mildew, Aphids", 50, 50, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 12000,  "kg", null, 4, "kg", null, null),
                // Eggplant
                new PlantVarieties("Eggplant", "Chahat",  "Sandy loams or alluvial soils that are well drained and deep", 6.0, 7.0, 21, 30, null, "Prone to: Blossom End Rot, Fruit Rot, Bacterial wilt, Lygus Bug, Tobacco Flea Beetle, Thrips", 240, 240, null, "Fiji Department of Agriculture", "All", "Year round, but best in the wet and hot seasons", "Year round, but best in the wet and hot seasons", 6072,  "kg", null, 0.3, "kg", null, null),
                new PlantVarieties("Eggplant", "Pritam",  "Sandy loams or alluvial soils that are well drained and deep", 6.0, 7.0, 21, 30, null, "Prone to: Blossom End Rot, Fruit Rot, Bacterial wilt, Lygus Bug, Tobacco Flea Beetle, Thrips", 240, 240, null, "Fiji Department of Agriculture", "All", "Year round, but best in the wet and hot seasons", "Year round, but best in the wet and hot seasons", 6072,  "kg", null, 0.3, "kg", null, null),
                //Maize
                new PlantVarieties("Maize", "Siegers Seed Co",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Abbott & Cobb",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Stokes Seeds",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Syngenta",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Rupp Seeds",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Harris Seeds",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                new PlantVarieties("Maize", "Seminis",  "well-drained, preferably a sandy loam", 5.5, 7.0, 20, 25, null, "Prone to: Maize Smut, Corn Earworm,Corn leaf hopper and Maize Aphids", 60, 60, null, "https://www.daf.qld.gov.au/business-priorities/plants/fruit-and-vegetables/vegetables/sweet-corn/pests-and-diseases-sweet-corn", null, "Year round", "Best in wet/hot seasons", 20000,  "kg", null, 24, "kg", null, null),
                //Rice
                new PlantVarieties("Rice", "Star",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Wet", "Dec-Jan (Planting), May-July (Harvesting)", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Maleka",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Totoka",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Boldgrain",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Uttam",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Deepak",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Nuinui",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "Viand",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                new PlantVarieties("Rice", "YRK5",  "Fertile riverine alluvial soil; clayey loam", 6.5, 7.0, 20, 40, null, "No apparent pests and/or diseases that the crop is tolerant to", 30, 35, null, "Fiji Ministry of Agriculture Crop Farmer's Guide", "All", "Year Round", "Year Round", 2000,  "kg", null, 80, "kg", null, null),
                //Sweet Potato
                new PlantVarieties("Sweet Potato", "Nothern Star",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Susceptible to root-knot nematodes", 90, 90, null, "DAF QLD", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Kestle",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "It is less susceptible to sweetpotato weevil than dessert types, Over-fertilising with nitrogen will result in excessive vegetative growth at the expense of storage root production.", 90, 90, "Wet conditions after maturity cause root rot, delayed harvest and substandard quality", "DAF QLD", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Hernandez",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate -Resistant Root knot: Intermediate-Resistant Fusarium wilt: Intermediate-Resistant Bacterial root rot: Resistant-Susceptible Intermediate Rhizopus soft rot: Susceptible-Intermediate Sclerotial blight: Unknown Fusarium root rot: Intermediate", 90, 90, "Late Developing", "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Orleans",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate: Intermediate to Resistant Root knot: Susceptible Fusarium wilt: Resistant Rhizopus soft rot: Resistant Bacterial soft rot: Susceptible (Beauregard is Susceptible) Fusarium root rot: Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Bayou Belle",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows:Soil rot: Intermediate: Resistant Root knot: Intermediate to resistant Fusarium wilt: Resistant Rhizopus soft rot: Highly resistant Fusarium root rot: Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Bellevue",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows:Soil rot: Intermediate - Resistant Root knot: Highly Resistant Fusarium wilt: Resistant Rhizopus soft rot: Intermediate Bacterial soft rot: Very Susceptible", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Burgundy",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate - Resistant Root knot: Highly Resistant Fusarium wilt: Resistant Rhizopus soft rot: Susceptible Bacterial soft rot: Intermediate - Susceptible", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Evangeline",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate - Resistant Root knot: Highly resistant Fusarium wilt: Resistant Rhizopus soft rot: Resistant  Sclerotial blight: Susceptible Fusarium root rot: Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "O-Henry",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Assumed Similar to Beauregard", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Murasaki-29",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows:Soil rot: Intermediate -Resistant Root knot: Highly resistant Fusarium wilt: Resistant Rhizopus soft rot: Highly Resistant Fusarium root rot: Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Bonita",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate Root knot: Highly resistant Fusarium wilt: Intermediate - resistant Rhizopus soft rot: Susceptible Fusarium root rot: Susceptible", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Porto Rico (PR-6)",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Susceptible Root knot: Susceptible-Intermediate Fusarium wilt: Susceptible,Bacterial root rot: Resistant-Susceptible Intermediate Rhizopus soft rot: Unknown Sclerotial blight: Susceptible Fusarium root rot: Intermediate-Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Texas Porto Rico",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Assumed similar to Porto Rico", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200,  "kg", null, 60000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Heartogold",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Susceptible-Intermediate Root knot: Resistant Fusarium wilt: Susceptible Bacterial root rot: Intermediate Rhizopus soft rot: Unknown Sclerotial blight: Susceptible Fusarium root rot: Susceptible-Intermediate", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200, "kg", null, 25000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Jewel",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Susceptible Root knot: Resistant Fusarium wilt: Resistant Bacterial root rot: Intermediate Rhizopus soft rot: Intermediate Sclerotial blight: Intermediate Fusarium root rot: Intermediate", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200, "kg", null, 25000, "Plants/Hectare", null, null),
                new PlantVarieties("Sweet Potato", "Bienville",  "Black Earth, Grey Podsolic, Sandy Loam", 5.5, 6.0, 20, 30, null, "Resistance rates are as follows: Soil rot: Intermediate -Resistant Root knot: Resistant Fusarium wilt: Resistant Bacterial root rot: Resistant-Susceptible Intermediate Rhizopus soft rot: Resistant Sclerotial blight: Unknown Fusarium root rot: Resistant", 90, 90, null, "LSU Sweet Potato Research Station", "All", "Year Round", "Year Round", 11200, "kg", null, 60000, "Plants/Hectare", null, null),
                //Taro
                new PlantVarieties("Taro", "Vulaono",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 25, 35, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Jaina Balavu",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Jaina Leka",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Lady Finger",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Smith",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Mili",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null),
                new PlantVarieties("Taro", "Timoci",  "Well-drained soil enriched with plenty of organic matter", 5.5, 7.0, 26, 30, null, "Prone to: Many chewing insect grubs that feed on the rich, starchy corm. Cluster caterpillars can be a major problem as they strip the upper surface of the taro blade. The eggs are laid in clusters and are covered with fine hair-like scales. Various beetles feed on taro. Erwinia soft rot is caused by Erwinia atroseptica. The corm becomes mushy and smelly and the affected plants eventually wilt and die.Shot hole leaf disease is a common fungal disease in the wet tropics.", 270, 360, null, "DAF QLD", "All", "Wet", "Wet Season", 3960, "kg", null, 675, "Plants/Hectare", null, null)
        };
    }
}
