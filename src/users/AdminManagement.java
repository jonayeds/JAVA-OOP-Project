package users;

import tourpackages.Package;

import java.util.Scanner;

public class AdminManagement {
    public Package touristRequestManagement( IncomingTourRequest request, Admin admin, UserManagement userManagement ){
        System.out.println(1+ " --> Accept");
        System.out.println(2+ " --> Reject");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.print("\nEnter package name: ");
            String packageName = sc.nextLine();
            packageName =  sc.nextLine();
            System.out.println();
            admin.deleteRequest(request);
            userManagement.handleRequest(false, request);
            return new Package(packageName, request.getDestination(), request.getBudget());
        }else if(choice == 2){
            System.out.println("Tourist Id: "+ request.touristID +" || Request Id: "+ request.getRequestId());
            admin.deleteRequest(request);
            userManagement.handleRequest(true, request);
            return null;
        }else{
            return null;
        }
    }

}

