package Book;


/* 입력 조건
 * 3 <= N <= 100
 * 0 <= K <= 1000
*/
public class 개미전사 {

    public static void main(String[] args) {
        Book220 book220 =  new Book220();
        System.out.println(book220.solution(4, new int[]{3, 1, 1, 5}));
    }
}

class Book220 {
    public int solution(int K, int[] N) {
        int[] dp = new int[K];

        dp[0] = N[0];
        dp[1] = Math.max(N[0], N[1]);

        for(int i = 2; i < K; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + N[i]);
        }
        return dp[K - 1];
    }
}
