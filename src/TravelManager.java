import users.Tourist;
import users.TouristManager;

import java.lang.reflect.Type;
import java.util.Scanner;

public class TravelManager {
    public static void main(String[] args) {
        TouristManager tm = new TouristManager();
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter Your name: ");
//        String name = sc.nextLine();
//        System.out.println();
//        System.out.print("Enter password: ");
//        String password = sc.nextLine();
//        System.out.println();
//        System.out.print("Enter your email: ");
//        String email = sc.nextLine();
//        System.out.println();
//        for(int i=0; i<3; i++){
//            Tourist tourist = new Tourist(name,i,password,email );
//            tm.addTourist(tourist);
//        }
        Tourist tourist1 = new Tourist("sajjad", 1, "123456", "sajjad@jonayed.com");
        Tourist tourist2 = new Tourist("kalia", 2, "123456", "kallu@kalia.com");
        Tourist tourist3 = new Tourist("Buta Gorila", 3, "123456", "buta@buta.com");
        tm.addTourist(tourist1);
        tm.addTourist(tourist2);
        tm.addTourist(tourist3);
        tm.displayTourist();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        Tourist tourist = tm.touristVerification(email, password);
        if (tourist == null) {
            System.out.println("Wrong password or email!! ");
        }else{
            System.out.println("Success");
            System.out.println(tourist);
        }


    }
}
