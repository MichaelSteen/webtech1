import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        //placeholder gebruikers
        users.add(new Owner("Bob", "bob123"));
        users.add(new Owner("John", "JohnnyRulezzz"));

        //login test
        System.out.println(login("Bob", "bob124"));
        System.out.println(login("Bob", "bob123"));
        System.out.println(login("Merel", "HWND"));
        System.out.println(login("John", "JohnnyRulezzz"));

        //placeholder kamers
        if (users.get(0) instanceof Owner) {
            ((Owner) users.get(0)).add_room(new Room(500, "Enschede", 50));
            ((Owner) users.get(0)).add_room(new Room(700, "Enschede", 100));
            ((Owner) users.get(0)).add_room(new Room(400, "Hengelo", 50));
        }

        //placeholder kamer voor andere verhuurder om te checken of dat ook werkt
        if (users.get(1) instanceof Owner) {
            ((Owner) users.get(0)).add_room(new Room(1500, "Delft", 145));
        }

        //een paar testjes om kamers te vinden
        System.out.println(find_rooms("Almelo", null, null));
        System.out.println(find_rooms("Enschede", null, null));
        System.out.println(find_rooms(null, 6000, 10));
        System.out.println(find_rooms(null, null, null));

    }

    /**
     * Test of er een gebruiker is dezelfde naam en wachtwoord.
     * @param name     gebruikersnaam
     * @param password wachtwoord van gebruiker
     * @return true als er een gebruiker is met die naam en dat wachtwoord
     */
    public boolean login(String name, String password) {
        boolean login_ok = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)) {
                login_ok = true;
            }
        }
        return login_ok;
    }

    /**
     * Zoekt een kamer van welkde verhuurder dan ook die voldoet aan de meegegeven filters.
     *
     * @param place       filter voor de plaats waar de kamer zich bevindt, mag null zijn.
     * @param max_rent    filter voor maximale hoeveelheid rente, mag null zijn.
     * @param min_surface filter voor minimaal oppervlakte, mag null zijn
     * @return lijst van kamers die voldoen aan de meegegeven filters.
     */
    public List<Room> find_rooms(String place, Integer max_rent, Integer min_surface) {
        List<Room> found_rooms = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Owner) {
                for (int j = 0; j < ((Owner) users.get(i)).getRooms().size(); j++) {
                    if (place != null && max_rent == null && min_surface == null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getPlace().equals(place)) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place != null && max_rent != null && min_surface == null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getPlace().equals(place) && ((Owner) users.get(i)).getRooms().get(j).getRent() <= max_rent) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place != null && max_rent == null && min_surface != null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getPlace().equals(place) && ((Owner) users.get(i)).getRooms().get(j).getSurface() >= min_surface) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place != null && max_rent != null && min_surface != null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getPlace().equals(place) && ((Owner) users.get(i)).getRooms().get(j).getRent() <= max_rent
                                && ((Owner) users.get(i)).getRooms().get(j).getSurface() >= min_surface) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place == null && max_rent != null && min_surface == null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getRent() <= max_rent) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place == null && max_rent == null && min_surface != null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getSurface() >= min_surface) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place == null && max_rent != null && min_surface != null) {
                        if (((Owner) users.get(i)).getRooms().get(j).getRent() <= max_rent && ((Owner) users.get(i)).getRooms().get(j).getSurface() >= min_surface) {
                            found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                        }
                    }
                    if (place == null && max_rent == null && min_surface == null) {
                        found_rooms.add(((Owner) users.get(i)).getRooms().get(j));
                    }
                }
            }
        }
        return found_rooms;
    }
}
