package Program;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date CheckIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date CheckOut = sdf.parse(sc.next());

        if(!CheckOut.after(CheckIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, CheckIn, CheckOut);

            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            CheckIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            CheckOut = sdf.parse(sc.next());

            Date now = new Date();
            if (CheckIn.before(now) || CheckOut.before(now)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else if (!CheckOut.after(CheckIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else{
                reservation.updateDates(CheckIn, CheckOut);
                System.out.println("Reservation: " + reservation);
            }
        }




        sc.close();

    }
}
