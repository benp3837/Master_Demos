package org.fnma.models;

//I don't need this to be a Spring Bean - we're just passing it in requests/responses
public class Herb {

    private int herbId;
    private String name;
    private String climate;


    // boilerplate----------------

    public Herb() {
    }

    public Herb(int herbId, String name, String climate) {
        this.herbId = herbId;
        this.name = name;
        this.climate = climate;
    }

    public int getHerbId() {
        return herbId;
    }

    public void setHerbId(int herbId) {
        this.herbId = herbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    @Override
    public String toString() {
        return "Herb{" +
                "herbId=" + herbId +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                '}';
    }
}
