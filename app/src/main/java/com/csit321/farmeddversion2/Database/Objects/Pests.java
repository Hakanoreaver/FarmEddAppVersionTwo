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
    @ColumnInfo(name = "Plants Affected")
    private String plantsAffected;
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

    public String getPlantsAffected() {
        return plantsAffected;
    }

    public void setPlantsAffected(String plantsAffected) {
        this.plantsAffected = plantsAffected;
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

    public Pests(String pestName, String description, String plantsAffected, String mitigationsNon, String mitigationsChemical, String protectiveMeasures, String image, String link) {
        this.pestName = pestName;
        this.description = description;
        this.plantsAffected = plantsAffected;
        this.mitigationsNon = mitigationsNon;
        this.mitigationsChemical = mitigationsChemical;
        this.protectiveMeasures = protectiveMeasures;
        this.image = image;
        this.link = link;
    }

    public Pests(String id, String pestName, String type, String description, String plantsAffected, String mitigationsNon, String mitigationsChemical, String protectiveMeasures, String image, String link)
	{
		this.pestName = pestName;
		this.description = description;
		this.plantsAffected = plantsAffected;
		this.mitigationsNon = mitigationsNon;
		this.mitigationsChemical = mitigationsChemical;
		this.protectiveMeasures = protectiveMeasures;
		this.image = image;
		this.link = link;
	}

    public static Pests[] populateData() {
        return new Pests[] {
                new Pests("13","Leaf miner flies","Pests","Irregular or serpentine pale grey lines appear on both sides of the leaf blades as the larvae feed. These burrows are usually limited by the leaf veins and contain black fecal material visible as slim trace inside the tunnels. Entire leaves may be covered with mines. Damaged leaves may drop prematurely (defoliation). Defoliation can reduce yield and fruit size and expose fruit to sunburn.","All","Minor infestation just leads to cosmetic damage and does not affect productivity. Parasitic wasps that kill leaf-miner larvae in the mine are commercially available. Ladybirds are also predators of the leaf miner fly. Neem oil, Neem Seed Kernal Extract (NSKE 5%), Neem oil (15000 ppm) @ 5ml/l or Spinosad deter adults from feeding and reduce egg laying, thus limiting damage. These products have a low impact on natural enemies and pollinators.","Broad-spectrum insecticides of the organophosphates, carbamates and pyrethroids families prevent adults from laying eggs, but they do not kill the larvae. Moreover, they can lead to the decrease of natural enemies and the development of resistance in the fly, which in some cases can actually result in an increase in their numbers. Products such as abamectin, bifenthrin, methoxyfenozide, chlorantraniliprole or spinetoram can be used in a rotation to avoid development of resistance.","Plant seedlings free of eggs of leafminer flies. Choose varieties with curled leaves that are less susceptible to the pest. Avoid planting alternative hosts next to infested fields. Monitor fields for signs of the insect on leaves. Use yellow sticky traps or yellow basins filled with water to catch the flies. Handpick and destroy mined leaves or heavily-infested plants. Plant hedge rows of flowering plants to prevent migration of the fly. Remove weeds and volunteer plants in and around the fields. Apply mulch around plants to prevent the flies from breeding in the soil. Do not use broad-spectrum insecticide that could affect natural enemies. Plow deep to expose the miners to natural enemies. Alternatively, burn infected plant debris after harvest. Rotate crops with non-susceptible crops.",null,"https://plantix.net/plant-disease/en/600022/leaf-miner-flies"),
                new Pests("8","Aphids","Pests","Aphids are small, soft bodied insects with long legs and antennae. Their size ranges from 0.5 to 2 mm and the color of their body can be yellow, brown, red or black, depending on the species. Their aspect ranges from the wingless varieties, that are generally predominant, to the winged, waxy or woolly types. They usually settle and feed in clusters on the underside of well-fed young leaves and shoot tips. Low to moderate numbers are not damaging to the crops. After an initial invasion in late spring or early summer, the aphid population usually diminishes naturally due to natural enemies.  Severe infestation can cause leaves and shoots to curl, wilt or yellow and stunted plant growth. Overall, a general decline in plant vigor will also be noticed. The honeydew secreted by the aphids as they feed on plant tissues causes an additional infection with opprtunistic fungi in many cases. The development of mold on the leaves indicate this. The honeydew attracts ants. Even small numbers of aphids can transmit viruses from plant to plant in a persistent way. Optimal conditions for their growth are dry and warm climates.","All","Beneficial insects such as predatory ladybugs, lacewings, soldier beetles and parasitoid wasps are important agents to control populations of aphids. These natural enemies will take care of the sucking insects in field conditions. In case of mild infestation, use a simple soft insecticidal soap solution or solutions based on plant oils. Aphids are also very susceptible to fungal diseases when it is humid. A simple spray of water on affected plants can also remove them.","Stem application with flonicamid and water @ 1:20 ratio at 30, 45, 60 Days after sowing (DAS) can be planned. Fipronil 2ml or thiamethoxam @ 0.2g or flonicamid @ 0.3g or acetamiprid @0.2g (per liter of water) can also be used. However, these chemicals can have negative impacts on predators, parasitoids, and pollinators.",null,null,"https://plantix.net/plant-disease/en/600002/aphids"),
                new Pests("9","Mealybug","Pests","White cotton-like masses made of flocks of bugs appear on the underside of leaves, stems, flowers and fruits. They are very active and even though low numbers have very little impact, infestations can lead to yellowing and curling of young leaves, stunted growth of plants and early fall of fruits. Older leaves are less likely to become deformed or distorted. The bugs excrete honeydew during sap sucking and this makes the tissues sticky and prone to be colonized by opportunistic bacteria and fungi. Fruits are particularly susceptible to be attacked and may become deformed or completely coated by wax secretions. Ants may be attracted by the honeydew and may spread the pest to other plants. Mealybugs are oval, wingless insects found in warm or temperate climates. Their body are protected by a layer of thin mealy wax that give them a cottony appearance. They insert their long piercing and sucking mouthparts (stylets) into plant tissues and suck sap out of them. The symptoms are a reaction to the toxic substances that they inject into plants while feeding. The eggs of the mealybug are also laid in the soil. After hatching, nymphs and adults can crawl to neighboring plants. They can also be dispersed over large distances by wind, ants, animals, birds or simply during field work activities such as pruning or harvesting. Warm temperatures and dry weather favor their life cycle and the severity of the symptoms.","All","At the first sign of slight infestation, smear the colonies of mealybugs with a cotton bud imbued with oil or spirit. You can also wash the plants with warm water and a small amount of detergent, petroleum oil or insecticidal soap. Nearby plants should be sprayed with neem oil or pyrethrins in order to prevent spread of the population. Natural antagonists include the green lacewing, parasitoid wasps, hover flies, ladybird beetles, mealybug destroyer and the predator butterfly Spalgis epius.","Treatments against mealybug are difficult because they are protected from adverse environmental conditions by their waxy layers and fibers. However, foliar spray with solutions based on imidacloprid, acetamiprid and chlorpyrifos can be effective against mealybugs.",null,null,"https://plantix.net/plant-disease/en/600019/mealybug"),
                new Pests("10","Thrips","Pests","Thrips are 1-2 mm long, yellow, black or fasciated insects. Some varieties have two pairs of wings, others do not have wings at all. They hibernate in plant residues or in the soil or on alternative hosts plants. They are also vectors for a broad range of viral diseases. Thrips do infest a broad variety of plants. Dry and warm weather conditions favor population growth. Humidity reduces it. Adults can be easily carried by winds, clothes, equipment and containers not properly cleaned after field work. Larvae and adults feed on plant tissues and produce small silver patches on the upper side of leaf blades, an effect known as 'silvering'. The same patches can appear on petals where the pigment has been removed. On the underside of the leaves, the thrips and their larvae sit together in groups alongside their black dung spots. Leaves of affected plants yellow, wither, deform or shrivel. Feeding during bud or flower development later results in scarred, stunted or deformed flowers or fruits respectively and loss of yield.","All","Some biological control measures have been developed for specific thrips. Predatory mites that feed on larvae or pupae are commercially available. Against varieties that attack the leaves and not the flower, try neem oil or natural pyrethrins, especially on the undersides of the leaves. Spinosad application is generally more effective against thrips than any of the chemical or other biological formulations. It lasts 1 week or more and moves short distances into sprayed tissue. It can however be toxic to certain natural enemies (e.g., predatory mites, syrphid fly larvae) and bees. Do not apply spinosad to plants that are flowering. In case of flower thrips infestation, some predatory mites or green lacewing larvae could be used. A combination of garlic extracts with some insecticides also seem to work well. Use of highly reflective UV mulch (metalized mulch) has been recommended.","Due to the high reproductive rates and their life cycles, thrips have developed resistance to different classes of pesticides. Effective contact insecticides include fipronil @2 ml, imidacloprid @ 0.25 ml or acetamiprid @ 0.2 g, which in many products are combined with piperonyl butoxide to enhance their effect.",null,null,"https://plantix.net/plant-disease/en/600003/thrips")
        };
    }
}
