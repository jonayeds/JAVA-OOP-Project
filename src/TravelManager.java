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
        Package package1 = new Package("7 days at Maldives", "Maldives",200000);
        Package package2 = new Package("7 days at Sri Lanka", "Sri Lanka",100000);
        Tourist tourist1 = new Tourist("sajjad", 1, "123456", "sajjad@jonayed.com");
        Tourist tourist2 = new Tourist("kalia", 2, "123456", "kallu@kalia.com");
        Admin admin1 = new Admin("Buta Gorila", 3, "123456", "buta@buta.com");
        userManagement.addUser(tourist1);
        userManagement.addUser(tourist2);
        userManagement.addUser(admin1);
        packageManagement.addPackage(package1);
        packageManagement.addPackage(package2);

        int choice=4;
        while(choice == 4){
            System.out.println("1 --> Log In");
            System.out.println("2 --> Exit");
            System.out.print("Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 2){
                break;
            }

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

                    double pendingPayment=0;
                    while(choice != 3  ){
                        System.out.println();
                        System.out.println();
                        System.out.println("Choices");
                        System.out.println("1 --> Book an existing Package");
                        System.out.println("2 --> Create Your Custom package");
                        System.out.println("3 --> Exit");
                        System.out.println("4 --> Log out");

                        System.out.print("Your choice: ");
                        choice = sc.nextInt();
                        System.out.println();
                        switch (choice){
                            case 1:
                                System.out.println("Choose 1 Package");
                                packageManagement.displayPackages();
                                System.out.print("Your choice: ");
                                int chosenPackage = sc.nextInt();
                                pendingPayment = tourist.bookExistingPackage(packageManagement.getPackageByID(chosenPackage), pendingPayment, user.getId());
                                System.out.println("Pending payment is "+pendingPayment);
                                break;
                            case 2:
                                System.out.println("Chosen Choice 2");
                                break;
                        }
                        if(choice == 4){
                            System.out.println("--------Logged Out Successfully--------");
                            break;
                        }
                    }
                }else if(Objects.equals(user.role, "admin")){
                    AdminManagement admin = new AdminManagement();
//                int choice=0;
                    while(choice != 3){
                        System.out.println();
                        System.out.println();
                        System.out.println("Choices");
                        System.out.println("1 --> Add a Package");
                        System.out.println("2 --> Remove a package");
                        System.out.println("3 --> Exit");

                        System.out.print("Your choice: ");
                        choice = sc.nextInt();
                        System.out.println();
                        switch (choice){
                            case 1:
                                System.out.print("Enter package name: ");
                                String name = sc.nextLine();
                                name =  sc.nextLine();
                                System.out.println();
                                System.out.print("Enter tour Destination: ");
                                String destination = sc.nextLine();
                                System.out.print("Enter tour cost: ");
                                double cost = sc.nextDouble();
                                Package pack = new Package(name, destination, cost);
                                packageManagement.addPackage(pack);
                                packageManagement.displayPackages();
                                break;
                            case 2:
                                packageManagement.displayPackages();
                                System.out.println();
                                System.out.print("Choose a Package to Remove: ");
                                int chosenPackage = sc.nextInt();
                                packageManagement.deletePackage(chosenPackage);

                                packageManagement.displayPackages();
                        }
                        if(choice == 4){
                            System.out.println("--------Logged Out Successfully--------");
                            break;
                        }
                    }
                }
            }

        }



    }
}
