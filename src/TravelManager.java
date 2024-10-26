import exceptions.UserInputException;
import loader.FileLoader;
import tourpackages.Package;
import tourpackages.PackageManagement;
import users.*;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


//----------------Features-----------------
// --> users can Log in as Tourist or admin.
// --> Can Log out.
// --> Tourist can Book an Available package.
// --> Tourist can not Book a package twice.
// --> Tourist`s ID will be saved in to Booked by array of the Package.
// --> Tourist will get their Pending payment after Booking a Package.
// --> Tourist`s pending payment will be saved Even If the tourist Logged Out.
// --> Admin can Add or Remove A package.
// --> A unique Package ID is added when a package is Created.
// --> Tourist`s Pending payment will be reduced when Admin removes a package if He Booked the package earlier.
// --> If a package is booked by 4 person, The package is confirmed and removed from available packages list.
// --> Admin can view all confirmed packages.



public class TravelManager {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        PackageManagement packageManagement = new PackageManagement();
        Scanner sc = new Scanner(System.in);
        FileLoader loader= new FileLoader();
        loader.readTouristData(userManagement);
        Package package1 = new Package("7 days at Maldives", "Maldives",200000);
        Package package2 = new Package("7 days at Sri Lanka", "Sri Lanka",100000);
        Tourist tourist1 = new Tourist("sajjad", "123456", "sajjad@jonayed.com");
        Tourist tourist2 = new Tourist("Sam Jones", "123456", "sam@gmail.com");
        Admin admin1 = new Admin("John Stones", "123456", "john@stones.com");
        userManagement.addTourist(tourist1);
        userManagement.addTourist(tourist2);
        userManagement.addAdmin(admin1);
        packageManagement.addPackage(package1);
        packageManagement.addPackage(package2);
        String name, email, password, role;

        int choice=4;
        while(choice == 4){
            System.out.println("1 --> Log In");
            System.out.println("2 --> Exit");
            System.out.println("3 --> Register");
            System.out.print("Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 2){
                break;
            }
            if(choice != 1 && choice != 3){
                choice=4;
                System.out.println("Wrong Choice");
                continue;
            }

            if(choice == 3){
                System.out.print("Enter Name: ");
                 name = sc.nextLine();
                System.out.print("Enter email: ");
                 email = sc.nextLine();
                System.out.print("Enter Password: ");
                 password = sc.nextLine();
                Tourist tourist = new Tourist(name, password, email);
                userManagement.addTourist(tourist);
                choice = 0;
                System.out.println("\nRegistration Successful ");
                role="tourist";
            }else {
                System.out.print("Enter email: ");
                 email = sc.nextLine();
                System.out.print("Enter Password: ");
                 password = sc.nextLine();
                role = userManagement.userVerification(email, password);
            }



            if(Objects.equals(role, "admin")){
                Admin admin = userManagement.getAdmin(email, password);
                System.out.println("Welcome "+ admin.getName() + "||  You are a "+ admin.role);
                AdminManagement adminManagement = new AdminManagement();
                while(choice != 3){
                    System.out.println();
                    System.out.println();
                    System.out.println("Choices");
                    System.out.println("1 --> Add a Package");
                    System.out.println("2 --> Remove a package");
                    System.out.println("3 --> Exit");
                    System.out.println("4 --> Log out");
                    System.out.println("5 -> View Confirmed packages");
                    System.out.println("6 --> Manage Incoming Tour Requests");
                    System.out.print("Your choice: ");
                    choice = sc.nextInt();
                    System.out.println();
                    switch (choice){
                        case 1:
                                System.out.print("Enter package name: ");
                                String packageName = sc.nextLine();
                                packageName =  sc.nextLine();
                                System.out.println();
                                System.out.print("Enter tour Destination: ");
                                String destination = sc.nextLine();
                            try{
                                System.out.print("Enter tour cost: ");
                                double cost = sc.nextDouble();
                                Package pack = new Package(packageName, destination, cost);
                                packageManagement.addPackage(pack);
                            }catch (InputMismatchException e){
                                System.out.println("Package cost Cannot be A String!!!!");
                                throw new UserInputException("Package cost Cannot be A String!!!!");
                            }
                            finally {
                                sc.nextLine();
                                packageManagement.displayPackages();
                                break;
                            }
                        case 2:
                            packageManagement.displayPackages();
                            System.out.println();
                            System.out.print("Choose a Package to Remove: ");
                            int chosenPackage = sc.nextInt();
                            try{
                                packageManagement.deletePackage(packageManagement.getPackageByIndex(chosenPackage-1) , userManagement);
                            }catch (IndexOutOfBoundsException e){
                                System.out.println("Package not found");
                                throw new UserInputException("Package not found");
                            }
                            finally {
                                packageManagement.displayPackages();
                                break;
                            }
                            case 5:
                                packageManagement.displayConfirmedPackages();
                                break;
                            case 6:
                                int requestNum = admin.viewAllIncomingRequests();
                                System.out.println(requestNum+1 +" ---------> Go Back");
                                System.out.print("\nChoose a Request: ");
                                int chooses  = sc.nextInt();
                                if(chooses == requestNum+1) break;
                                Package pac = adminManagement.touristRequestManagement(admin.getRequestByIndex(chooses-1), admin,  userManagement);
                                if(pac != null) {
                                    packageManagement.addPackage(pac);

                                }

                    }
                    if(choice == 4){
                        System.out.println("--------Logged Out Successfully--------");
                        break;
                    }
                }


            }else if(Objects.equals(role, "tourist")){
                Tourist tourist = userManagement.getTourist(email, password);
                TouristManagement touristManagement = new TouristManagement();
                System.out.println("Welcome "+ tourist.getName() + "||  You are a "+ tourist.role);
                double pendingPayment= tourist.getPendingPayment();
                while(choice != 3  ){
                    System.out.println();
                    System.out.println();
                    System.out.println("Choices");
                    System.out.println("1 --> Book an available Package");
                    System.out.println("2 --> Request a Custom package");
                    System.out.println("3 --> Exit");
                    System.out.println("4 --> Log out");
                    System.out.println("5 --> Your Tour Requests");

                    System.out.print("Your choice: ");
                    choice = sc.nextInt();
                    System.out.println();
                    switch (choice){
                        case 1:
                            System.out.println("Choose 1 Package");
                            packageManagement.displayPackages();
                            System.out.print("Your choice: ");
                            int chosenPackage = sc.nextInt();
                            try {
                                pendingPayment = touristManagement.bookExistingPackage(packageManagement.getPackageByIndex(chosenPackage-1), pendingPayment, tourist.getId(), packageManagement);
                                tourist.setPendingPayment(pendingPayment);
                            }catch(IndexOutOfBoundsException e) {
                                System.out.println("Package does not exist");
                                throw new UserInputException("Package Not Found");
                            }
                            finally {
                                System.out.println("Pending payment is "+pendingPayment);
                                break;
                            }

                        case 2:
                            String[] destinations = packageManagement.showTourDestinations();
                            System.out.print("\nChoose Destination: ");
                            int packageNum = sc.nextInt();
                            System.out.print("\nYour Budget($): ");
                            double budget = sc.nextDouble();
                            TouristRequest request = new TouristRequest(destinations[packageNum-1], budget);
                            tourist.addTourRequest(request);
                            userManagement.sendRequestToAdmin(request, tourist.getId(), tourist.getName(), tourist.getEmail());
                            System.out.println("Request sent to  admin");
                            break;
                        case 5:
                            tourist.displayAllTourRequests();
                            break;
                    }
                    if(choice == 4){
                        System.out.println("--------Logged Out Successfully--------");
                        System.out.println();
                        break;
                    }
                }
            }else if(role == null) {
                System.out.println("Wrong password or email!!!");
                choice =4;
            }

        }
    }
}
