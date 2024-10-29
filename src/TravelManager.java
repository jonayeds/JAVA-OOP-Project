import exceptions.UserInputException;
import filehandler.FileLoader;
import filehandler.WriteData;
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
// --> Tourists can request a custom package according to their chosen destination and budget.
// --> Admin and Accept or reject tourists requests If accepts then have to add a package according to the request.
// --> Tourist can see their request is accepted or rejected.
// --> FileLoader will read user and package data from csv file.
// --> Write data will re write all updated data before user exit the application.
// --> used Password and Email validation.



public class TravelManager {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        PackageManagement packageManagement = new PackageManagement();
        Scanner sc = new Scanner(System.in);
        FileLoader loader= new FileLoader();
        loader.readAdminData(userManagement);
        loader.readTouristData(userManagement);
        loader.readPackageData(packageManagement);
        loader.readConfirmedPackages(packageManagement);
        String name, email = "", password = "", role;

        int choice=4;
        while(choice == 4){
            System.out.println("----------------------------------------");
            System.out.println("\t\t1 --> Log In");
            System.out.println("\t\t2 --> Exit");
            System.out.println("\t\t3 --> Register");
            System.out.println("----------------------------------------");
            System.out.print("\t\tYour Choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            if(choice == 2){
                break;
            }
            if(choice != 1 && choice != 3){
                choice=4;
                System.out.println("!!!----------------->Wrong Choice");
                continue;
            }

            if(choice == 3){
                System.out.print("\t\tEnter Name: ");
                 name = sc.nextLine();

                 boolean isValid  = false;

                 while(!isValid){
                    System.out.print("\t\tEnter email: ");
                    email = sc.nextLine();
                    isValid = userManagement.validateEmail(email);
                    if(!isValid) System.out.println("!!!---------------->Invalid Email");
                 }
                 isValid=false;
                while(!isValid){
                    System.out.print("\t\tEnter Password: ");
                    password = sc.nextLine();
                    isValid = userManagement.validatePassword(password);
                    if(!isValid) System.out.println( "!!!---------------->You have to include capital and small Letter, Number, and a special character  password. ");
                }


                Tourist tourist = new Tourist(name, password, email);
                userManagement.addTourist(tourist);
                choice = 0;
                System.out.println("\n--------------Registration Successful----------------- ");
                role="tourist";
            }else {
                System.out.println("\t\t-------------Log In--------------");
                System.out.print("\t\tEnter email: ");
                 email = sc.nextLine();
                System.out.print("\t\tEnter Password: ");
                 password = sc.nextLine();
                System.out.println("\t\t----------------------------------\n");

                role = userManagement.userVerification(email, password);
            }



            if(Objects.equals(role, "admin")){
                Admin admin = userManagement.getAdmin(email, password);
                System.out.println("\t\tWelcome "+ admin.getName() + "||  You are a "+ admin.role);
                AdminManagement adminManagement = new AdminManagement();
                while(choice != 3){
                    System.out.println();
                    System.out.println();
                    System.out.println("\n\t\t-----------Choices-----------");
                    System.out.println("\t\t1 --> Add a Package");
                    System.out.println("\t\t2 --> Remove a package");
                    System.out.println("\t\t3 --> Exit");
                    System.out.println("\t\t4 --> Log out");
                    System.out.println("\t\t5 -> View Confirmed packages");
                    System.out.println("\t\t6 --> Manage Incoming Tour Requests");
                    System.out.println("\t\t-------------------------------------------");
                    System.out.print("\t\tYour choice: ");
                    choice = sc.nextInt();
                    System.out.println();
                    switch (choice){
                        case 1:
                                System.out.print("\t\tEnter package name: ");
                                String packageName = sc.nextLine();
                                packageName =  sc.nextLine();
                                System.out.print("\t\tEnter tour Destination: ");
                                String destination = sc.nextLine();
                            try{
                                System.out.print("\t\tEnter tour cost: ");
                                double cost = sc.nextDouble();
                                Package pack = new Package(packageName, destination, cost);
                                packageManagement.addPackage(pack);
                            }catch (InputMismatchException e){
                                System.out.println("\t\t!!!-------------> Package cost Cannot be A String!!!!");
                                throw new UserInputException("Package cost Cannot be A String!!!!");
                            }
                            finally {
                                sc.nextLine();
                                System.out.println("\n\t\t------------- Packages --------------");
                                packageManagement.displayPackages();
                                break;
                            }
                        case 2:
                            System.out.println("\n\t\t------------- Packages --------------");
                            packageManagement.displayPackages();
                            System.out.println();
                            System.out.print("\t\tChoose a Package to Remove: ");
                            int chosenPackage = sc.nextInt();
                            try{
                                packageManagement.deletePackage(packageManagement.getPackageByIndex(chosenPackage-1) , userManagement);
                            }catch (IndexOutOfBoundsException e){
                                System.out.println("Package not found");
                                throw new UserInputException("Package not found");
                            }
                            finally {
                                System.out.println("\t\t--------------  New Package List --------------");
                                packageManagement.displayPackages();
                                break;
                            }
                            case 5:
                                packageManagement.displayConfirmedPackages(userManagement);
                                break;
                            case 6:
                                int requestNum = admin.viewAllIncomingRequests();
                                System.out.println("\t\t"+requestNum +"---------> Go Back");
                                System.out.println("\t\t------------------------------------------------------");
                                System.out.print("\n\t\tChoose a Request: ");
                                int chooses  = sc.nextInt();
                                if(chooses == requestNum) break;
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
                System.out.println("\t\tWelcome "+ tourist.getName() + " || You are a "+ tourist.role);
                double pendingPayment= tourist.getPendingPayment();
                while(choice != 3  ){
                    System.out.println("\n\t\t-----------Choices-----------");
                    System.out.println("\t\t1 --> Book an available Package");
                    System.out.println("\t\t2 --> Request a Custom package");
                    System.out.println("\t\t3 --> Exit");
                    System.out.println("\t\t4 --> Log out");
                    System.out.println("\t\t5 --> Your Tour Requests");
                    System.out.println("\t\t--------------------------------");

                    System.out.print("\t\tYour choice: ");
                    choice = sc.nextInt();
                    System.out.println();
                    switch (choice){
                        case 1:
                            System.out.println("\t\t----------------Choose 1 Package----------------");
                            packageManagement.displayPackages();
                            System.out.print("\t\tYour choice: ");
                            int chosenPackage = sc.nextInt();
                            try {
                                pendingPayment = touristManagement.bookExistingPackage(packageManagement.getPackageByIndex(chosenPackage-1), pendingPayment, tourist.getId(), packageManagement);
                                tourist.setPendingPayment(pendingPayment);
                            }catch(IndexOutOfBoundsException e) {
                                System.out.println("!!!---------------->Package does not exist");
                                throw new UserInputException("Package Not Found");
                            }
                            finally {
                                System.out.println("\t\t~~~~~~~~~~~~~~~~~>Pending payment is "+pendingPayment);
                                break;
                            }

                        case 2:
                            String[] destinations = packageManagement.showTourDestinations();
                            System.out.print("\t\tChoose Destination: ");
                            int packageNum = sc.nextInt();
                            System.out.print("\t\tYour Budget($): ");
                            double budget = sc.nextDouble();
                            TouristRequest request = new TouristRequest(destinations[packageNum-1], budget);
                            tourist.addTourRequest(request);
                            userManagement.sendRequestToAdmin(request, tourist.getId(), tourist.getName(), tourist.getEmail());
                            System.out.println("\n\t\t--------------------> Request sent to  admin <--------------------");
                            break;
                        case 5:
                            tourist.displayAllTourRequests();
                            break;
                    }
                    if(choice == 4){
                        System.out.println("\t\t--------Logged Out Successfully--------");
                        System.out.println();
                        break;
                    }
                }
            }else if(role == null) {
                System.out.println("!!!------------> Wrong password or email!!!");
                choice =4;
            }
        }
        WriteData writer = new WriteData();
        writer.writePackageData(packageManagement.getPackageList());
        writer.writeConfirmedPackages(packageManagement.getConfirmedPackageList());
        writer.writeTourist(userManagement.getAllTourists());
    }
}
