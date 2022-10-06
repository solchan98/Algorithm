package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCnt = Integer.parseInt(st.nextToken());
        int[] pricePerLiterArr = new int[cityCnt];
        int[] milArr = new int[cityCnt - 1];

        for(int i = 0; i < pricePerLiterArr.length; i++) {
            st = new StringTokenizer(br.readLine());
            pricePerLiterArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < milArr.length; i++) {
            st = new StringTokenizer(br.readLine());
            milArr[i] = Integer.parseInt(st.nextToken());
        }

        int nextStation = -1;
        int totalPrice = 0;

//        for (int i = 0; i < pricePerLiterArr.length; i++) {
//
//        }
    }

    private static int findMinPricePerLiter(int[] pricePerLiterArr) {
        return 0;
    }
}
