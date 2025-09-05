import java.util.*;

public class TaxiBookingSystem {
    static List<Taxi> taxis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int customerCounter = 1;

    public static void main(String[] args) {
        System.out.println("Enter number of Taxis: ");
        int numTaxis = sc.nextInt(); //2
        initializeTaxis(numTaxis);

        while(true){
            System.out.println("\n1. Book Taxi \n2.Display Taxi Details\n3. Exit");
            System.out.println("Enter ypur choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice. Try again");
            }

        }
    }

    public static void initializeTaxis(int n){
        for(int i=1;i<=n;i++){
            taxis.add(new Taxi(i));
        }
    }

    public static void bookTaxi(){
        int customerId = customerCounter++;
        System.out.println("Enter Pickup Point (A-F): ");
        char Pickup = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the drop point ");
        char drop = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter Pickup Time (in hours): ");
        int pickupTime = sc.nextInt();

        Taxi selectTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        for(Taxi taxi : taxis){
            if(taxi.isAvailable(pickupTime)){
                int distance = Math.abs(taxi.currentPoint - Pickup);
                if(distance < minDistance || 
                         (distance == minDistance && taxi.totalEarnings < selectTaxi.totalEarnings)){
                    selectTaxi = taxi;
                    minDistance = distance;
                }

            }
        }
        if(selectTaxi == null){
            System.out.println("Booking rejected. No taxis available");
            return;
        }

        int dropTime = pickupTime + Math.abs(drop - Pickup);
        int amount = selectTaxi.calculateEarnings(Pickup, drop);
        int bookingId = selectTaxi.bookings.size()+1;

        Booking booking = new Booking(bookingId, customerId, Pickup, drop, pickupTime, dropTime, amount);
        selectTaxi.addBooking(booking);
        System.out.println("Taxi-"+selectTaxi.id+"is allocated.");

    }

    public static void displayTaxiDetails(){
        for(Taxi taxi : taxis){
            System.out.println("Taxi -"+ taxi.id + "Total Earnings: Rs."+taxi.totalEarnings);
            System.out.println();
        }
    }



}
