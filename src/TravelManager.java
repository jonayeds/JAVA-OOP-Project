import users.Tourist;
import users.TouristManager;

public class TravelManager {
    public static void main(String[] args) {
        TouristManager tm = new TouristManager();
        Tourist tourist1 = new Tourist("sajjad", 1, "butagorila", "1juunaayeed@gmail.com");
        Tourist tourist2 = new Tourist("Nobita", 2, "123456", "nobi@nobita.com");
        Tourist tourist3 = new Tourist("Buta Gorila", 3, "123456", "buta@buta.com");

        tm.addTourist(tourist1);
        tm.addTourist(tourist2);
        tm.addTourist(tourist3);
        tm.displayTourist();
    }
}
