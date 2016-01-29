import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Chris Anatalio
 * Softsource Coding Practical
 */
public class Main {

    private static long checkedTime;
    private static long currentTime;

    //Generate URL that will prove a certain number is prime for verification
    private static final String DELIMITER = "@@Num@@";
    private static String proofStringBase = "http://www.numbersmath.com/is-prime/solved/is-" + DELIMITER + "-a-prime-number";


    public static void main(String[] args) {

        long count = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please type in 'Start' and press enter to begin:");

        //Wait until start is requested
        while(!sc.next().equalsIgnoreCase("Start")) {

        }

        //Initialize time check
        Main.checkedTime = System.nanoTime();

        for(long i = 0; i < Long.MAX_VALUE; i++) {
            if(isPrime(i)) {

                if(hasOneSecondElapsed(checkedTime)) {

                    String proof = new String(proofStringBase);
                    System.out.println("Prime #" + ++count + " " + i + " Current Time: " + convertNanoToMilli(Main.checkedTime));
                    System.out.println("Proof: " + proof.replace(DELIMITER, i+""));
                    System.out.println();
                }

                if(count == 60)
                    break;

            }
        }

    }


    public static boolean isPrime(long n)
    {

        //Short-circuit check if checked num is divisible by common factors
        if((n % 2 == 0 && n != 2) || (n % 3 == 0  && n != 3)|| (n % 5 == 0 && n != 5))
            return false;

        //Divide checked number by 5 and starting at 5 check if divisible by increasing values incremented by 2
        //If divisible by even number, then it would be divisible by 2 and caught in the first check
        for(int i = 5; i < n / 5; i += 2)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    //Calculate elapsed time
    public static boolean hasOneSecondElapsed(long checkedTime) {

        Main.currentTime = System.nanoTime();

        if(convertNanoToMilli(currentTime-checkedTime) >= 1000) {
            Main.checkedTime = currentTime;
            return true;
        }

        return false;
    }

    //Display nano seconds in more readable fashion
    public static long convertNanoToMilli(long timeInNanos) {
        return TimeUnit.MILLISECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS);
    }
}
