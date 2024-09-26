import tourpackages.Package;
import tourpackages.PackageManagement;
import users.*;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Scanner;

public class TravelManager {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        PackageManagement packageManagement = new PackageManagement();
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
        Package package1 = new Package(1,"7 days at Maldives", "Maldives",200000);
        Package package2 = new Package(2,"7 days at Sri Lanka", "Sri Lanka",100000);
        Tourist tourist1 = new Tourist("sajjad", 1, "123456", "sajjad@jonayed.com");
        Tourist tourist2 = new Tourist("kalia", 2, "123456", "kallu@kalia.com");
        Admin admin1 = new Admin("Buta Gorila", 3, "123456", "buta@buta.com");
        userManagement.addUser(tourist1);
        userManagement.addUser(tourist2);
        userManagement.addUser(admin1);
        packageManagement.addPackage(package1);
        packageManagement.addPackage(package2);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        UserTemplate user = userManagement.userVerification(email, password);
        if (user == null) {
            System.out.println("Wrong password or email!! ");
        }else{
            System.out.println("Welcome "+ user.getName() + "||  You are a "+ user.role);
            if(Objects.equals(user.role, "tourist")){
                TouristManagement tourist = new TouristManagement();
                System.out.println("Choices");
                System.out.println("1 --> Book an existing Package");
                System.out.println("2 --> Create Your Custom package");

                System.out.print("Your choice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        packageManagement.displayPackages();
                        break;
                    case 2:
                        System.out.println("Chosen Choice 2");
                }
            }
        }


    }
}
