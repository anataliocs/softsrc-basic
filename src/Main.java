import java.util.concurrent.TimeUnit;

/**
 * Created by canatalio on 1/28/16.
 */
public class Main {

    private static long checkedTime;
    private static long currentTime;

    private static final String DELIMITER = "@@Num@@";
    private static String proofStringBase = "http://www.numbersmath.com/is-prime/solved/is-" + DELIMITER + "-a-prime-number";



    public static void main(String[] args) {

        long count = 0;
        //Initialize time
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
        if((n % 2 == 0 && n != 2) || (n % 3 == 0  && n != 3)|| (n % 5 == 0 && n != 5))
            return false;
        for(int i = 5; i < n / 5; i += 2)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean hasOneSecondElapsed(long checkedTime) {

        Main.currentTime = System.nanoTime();

        if(convertNanoToMilli(currentTime-checkedTime) >= 1000) {
            Main.checkedTime = currentTime;
            return true;
        }

        return false;
    }

    public static long convertNanoToMilli(long timeInNanos) {
        return TimeUnit.MILLISECONDS.convert(timeInNanos, TimeUnit.NANOSECONDS);
    }
}
