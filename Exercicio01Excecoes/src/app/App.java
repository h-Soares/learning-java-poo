package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.entities.Reservation;
import models.exceptions.DomainException;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
                int roomNumber = scan.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
                scan.nextLine();
                LocalDate checkIn = LocalDate.parse(scan.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
                LocalDate checkOut = LocalDate.parse(scan.nextLine(), fmt);
        
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);  

            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = LocalDate.parse(scan.nextLine(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = LocalDate.parse(scan.nextLine(), fmt);
            reservation.updateDate(checkIn, checkOut);
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid input!");
        }
        catch(DateTimeParseException e) {
            System.out.println("Invalid date!");
        }
        catch(DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }

        scan.close();
    }
}