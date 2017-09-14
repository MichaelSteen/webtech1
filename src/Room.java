public class Room {

    private int rent;
    private String place;
    private int surface;

    public Room(int rent, String place, int surface) {
        this.rent = rent;
        this.place = place;
        this.surface = surface;
    }

    public int getRent() {
        return rent;
    }

    public String getPlace() {
        return place;
    }

    public int getSurface() {
        return surface;
    }

    @Override
    public String toString() {
        return (place + ", " + surface + " m2 surface area, " + rent + " euro per month.");
    }
}
