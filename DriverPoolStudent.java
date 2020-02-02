
import java.util.Scanner;
/**
 * This program is used to unit test the Pool class.
 * The format of the dollar amount is not important.
 * You should not be concerned that there are no 
 * dollar signs or there are more than two decimal
 * places.
 * 
 * @author Daniel Graham and James Hughes
 * @version Spring 2020
 */
public class DriverPoolStudent
{
    public static void main(String args[])
    {
        //1.  Create a Pool object.
        Pool p = new Pool();

        //2.  Test bounds of the range for pool days
        //2A. day - lower bound test 
        System.out.println(" START LOWER BOUND TEST POOL DAYS");
        System.out.println(p.addEntry(0, 5, "John", 2.0) + "  Expected: false");
        System.out.println(p.addEntry(1, 5, "John", 2.0) + "  Expected: true");
        System.out.println(p.addEntry(2, 5, "John", 2.0) + "  Expected: true");
        System.out.println("END OF LOWER BOUND TEST POOL DAYS\n");
        //2B. day - mid-range test
        System.out.println("START MID BOUND TEST POOL DAYS");
        System.out.println(p.addEntry(4, 5, "John", 2.0) + "  Expected: true");
        System.out.println("END MID BOUND TEST POOL DAYS\n");
        //2C. day - upper bound test
        System.out.println("START UPPER BOUND TEST POOL DAYS");
        System.out.println(p.addEntry(7, 5, "John", 2.0) + "  Expected: true");
        System.out.println(p.addEntry(8, 5, "John", 2.0) + "  Expected: false");
        System.out.println(p.addEntry(9, 5, "John", 2.0) + "  Expected: false");
        System.out.println("END UPPER BOUND TEST POOL DAYS\n");

        //3.  Test the bounds of the range for pool hours
        //3A. hour - lower bound test
        System.out.println("START LOWER BOUND TEST POOL HOURS");
        System.out.println(p.addEntry(4, -1, "John", 2.0) + "  Expected: false");
        System.out.println(p.addEntry(4, 0, "John", 2.0) + "  Expected: true");
        System.out.println(p.addEntry(4, 1, "John", 2.0) + "  Expected: true");
        System.out.println("END LOWER BOUND TEST POOL HOURS\n");
        //3B. hour - mid-range test
        System.out.println("START MID BOUND TEST POOL HOURS");
        System.out.println(p.addEntry(4, 15, "John", 2.0) + "  Expected: true");
        System.out.println("END MID BOUND TEST POOL HOURS\n");
        //3C. hour - upper bound test
        System.out.println("START UPPER BOUND TEST POOL HOURS");
        System.out.println(p.addEntry(4, 23, "John", 2.0) + "  Expected: true");
        System.out.println(p.addEntry(4, 24, "John", 2.0) + "  Expected: false");
        System.out.println(p.addEntry(4, 25, "John", 2.0) + "  Expected: false");
        System.out.println("END UPPER BOUND TEST POOL HOURS\n");

        //4A.  Test pool total; total is based on the pool entries above
        System.out.println("Pool total test: " + p.poolTotal() + "  Expected: 16.0");
        //4B.  Test pool total with a new pool and no entries.
        Pool myPool = new Pool();
        System.out.println("Blank pool total: " + myPool.poolTotal() + "  Expected: 0.0\n");

        //5A.  Test getWinner - winner exists
        System.out.println("TESTING WHEN WINNER EXISTS");
        System.out.println(p.getWinner(4, 5));
        //5B.  Test getWinner - no winner
        System.out.println("TESTING WHEN WINNER DOES NOT EXIST");
        System.out.println(p.getWinner(5, 17));

        //6.   print the complete matrix
        System.out.println("\n" + p);
        p.toString();
        /*
         * 7. 
         * Use the Pool object, p, you created above.  If there are entries 
         * still available (there should be lots!), ask the user to pick a day 
         * and time.  Keep asking until they have picked one that is not 
         * already used (is null).  Then, add the user to the pool.  You 
         * will need their name and the amount they would like to enter.
         * You only need to enter one user in the pool.
         */
        Scanner scnr = new Scanner(System.in);
        int day = -1;
        int hour = -1;
        String name = "";
        double amount = 0;

        System.out.println("Enter your name: ");
        name = scnr.next();

        System.out.println("Enter your amount: ");
        amount = scnr.nextDouble();

        while (true){
            System.out.println("Enter a day: ");
            day = scnr.nextInt();
            System.out.println("Enter a hour: ");
            hour = scnr.nextInt();
            if (p.addEntry(day, hour, name, amount) != false){
                p.addEntry(day, hour, name, amount);
                break;
            }
        }
        
        System.out.println("\n" + p);
    }
}

