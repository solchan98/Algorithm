package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.Map;
import java.util.StringTokenizer;

public class B10816 {

    static StringTokenizer st;
    static Map<Integer, Integer> cardMap;
    static int targetNumCnt;
    static StringBuilder result;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCnt = Integer.parseInt(br.readLine());
        cardMap = new HashMap<>(cardCnt);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cardCnt; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            if (cardMap.containsKey(cardNum)) {
                cardMap.replace(cardNum, cardMap.get(cardNum) + 1);
            } else {
                cardMap.put(cardNum, 1);
            }
        }

        targetNumCnt = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        result = new StringBuilder();

    }

    public static void main(String[] args) throws IOException {
        init();

        for (int idx = 0; idx < targetNumCnt; idx++) {
            int targetNum = Integer.parseInt(st.nextToken());
            boolean isContains = cardMap.containsKey(targetNum);

            if (isContains) {
                result.append(cardMap.get(targetNum));
            } else {
                result.append("0");
            }

            if (idx != targetNumCnt - 1) result.append(" ");
        }
        System.out.println(result);
    }
}
