import java.util.ArrayList;
import java.util.List;

public class Owner extends User {

    public Owner(String name, String password) {
        super(name, password);
    }

    private List<Room> rooms = new ArrayList<>();

    public void add_room(Room room){
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
