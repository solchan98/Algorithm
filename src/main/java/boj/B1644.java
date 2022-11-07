package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1644 {

    static int number;
    static List<Integer> primeList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws Exception {
        init();
        run();
        printResult();
    }

    private static void run() {
        for (int idx = 0; idx < primeList.size(); idx++) {
            boolean isOk = check(primeList.subList(idx, primeList.size()));
            if (isOk) result++;
        }
    }

    private static void printResult() {
        System.out.println(result);
    }

    private static boolean check(List<Integer> list) {
        int sum = 0;
        for (Integer num: list) {
            sum += num;
            if (sum >= number) {
               break;
            }
        }
        return sum == number;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        findAllPrime(number);
    }

    private static void findAllPrime(int num) {
        for (int n = 0; n <= num; n++) {
            if (isPrime(n)) {
                primeList.add(n);
            }
        }
    }

    private static boolean isPrime(int num) {
        int count = 0;

        for(int i = 1; i <= num; i++)
        {
            if(num % i == 0) {
                count += 1;
            } else if(count >= 3) {
                break;
            }
        }

        return count == 2;
    }
}
