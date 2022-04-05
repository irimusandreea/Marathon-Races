package model;

public class Registration implements Identifiable<Integer> {

    private int id;
    private String participant;
    private String phoneNr;
    private String address;
    private String age;
    private String race;

    public Registration(String participant, String phoneNr, String address, String age, String race) {

        this.participant = participant;
        this.phoneNr = phoneNr;
        this.address = address;
        this.age = age;
        this.race = race;

    }

    public Registration(int id, String participant, String phoneNr, String address, String age, String race) {

        this.id = id;
        this.participant = participant;
        this.phoneNr = phoneNr;
        this.address = address;
        this.age = age;
        this.race = race;

    }

    public Registration() {

        this.id = 0;
        this.participant = "";
        this.phoneNr = "";
        this.address = "";
        this.age = "";
        this.race = "";

    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Registration) {
            Registration c = (Registration) ob;
            if (c.participant.equals(participant) && c.phoneNr.equals(phoneNr) && c.address.equals(address) && c.age.equals(age) && c.race.equals(race))
                return true;
        }
        return false;
    }

    public String toString() {
        return id + " | "  + participant + " | " + phoneNr + " | " + address + " | " + age + " | " + race;
    }


}
