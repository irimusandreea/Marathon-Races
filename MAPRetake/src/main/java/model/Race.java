package model;

public class Race implements Identifiable<Integer> {

    private int id;
    private String name;
    private String type;
    private String distance;
    private String date;

    public Race(String name, String type, String distance, String date) {

        this.name = name;
        this.type = type;
        this.distance = distance;
        this.date = date;

    }

    public Race(int id, String name, String type, String distance, String date) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.distance = distance;
        this.date = date;

    }

    public Race() {

        this.id = 0;
        this.name = "";
        this.type = "";
        this.distance = "";
        this.date = "";

    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Race) {
            Race c = (Race) ob;
            if (c.name.equals(name) && c.type.equals(type) && c.distance.equals(distance) && c.date.equals(date))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  id + " | "  + name + " | " + type + " | " + distance + " km " + " | " + date;
    }

}
