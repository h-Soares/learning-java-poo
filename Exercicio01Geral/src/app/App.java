package app;

import java.util.Scanner;
import models.entities.Contact;
import models.entities.Schedule;
import models.exceptions.ContactDoesntExistException;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Schedule schedule =  new Schedule();

        int ans;
        do {
            System.out.println("MENU: ");
            System.out.println("1 - Consult contact\t2 - Add contact");
            System.out.print("Option: ");
                ans = scan.nextInt();
            System.out.println();
            scan.nextLine(); //clean buffer

            if(ans == 1) {
                System.out.print("Contact name: ");
                    String name = scan.nextLine();
                try {
                    schedule.consultContact(name);
                }
                catch(ContactDoesntExistException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(ans == 2) {
                System.out.print("Contact name: ");
                    String name = scan.nextLine();
                System.out.print("Phone: ");
                    int phone = scan.nextInt();
                schedule.addContact(new Contact(name, phone)); 
            }
                System.out.print("\n0 to continue: ");
                    ans = scan.nextInt();
            
        }while(ans == 0);

        scan.close();
    }
}