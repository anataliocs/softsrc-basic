import java.util.concurrent.TimeUnit;

/**
 * Created by canatalio on 1/28/16.
 */
public class Main {

    public static void main(String[] args) {


        long count = 0;
        long checkedTime = System.nanoTime();
        for(long i = 0; i < Long.MAX_VALUE; i++) {
            if(isPrime(i)) {
                long currentTime = System.nanoTime();

                //System.out.println(TimeUnit.MILLISECONDS.convert((currentTime-checkedTime), TimeUnit.NANOSECONDS));

                if(TimeUnit.MILLISECONDS.convert((currentTime-checkedTime), TimeUnit.NANOSECONDS) >= 1000) {
                    checkedTime = currentTime;
                    System.out.println("Prime #" + ++count + " " + i + " Current Time: " + currentTime);
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
}
