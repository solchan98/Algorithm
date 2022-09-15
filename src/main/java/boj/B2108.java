package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int[] numArr = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAvg(numArr));
        System.out.println(getMiddle(numArr));
        System.out.println(getSecondFrequency(numArr));
        System.out.println(getRangeBetweenMinMax(numArr));
    }

    private static int getAvg(int[] arr) {
        double avg = (double) Arrays.stream(arr).sum() / (double) arr.length;
        return (int) Math.round(avg);
    }

    private static int getMiddle(int[] arr) {
        Arrays.sort(arr);
        return arr[(arr.length - 1) / 2];
    }

    private static int getSecondFrequency(int[] arr) {
        Map<Integer, Integer> arrMap =  new HashMap<>(arr.length);
        for (int num: arr) {
            if (arrMap.containsKey(num)) {
                Integer value = arrMap.get(num);
                arrMap.put(num, value + 1);
            } else {
                arrMap.put(num, 1);
            }
        }

        int max = 0;
        Set<Integer> maxKeySet = new HashSet<>();
        for(Integer key : arrMap.keySet() ){
            Integer value = arrMap.get(key);
            if (value > max) {
                max = value;
                maxKeySet = new HashSet<>();
                maxKeySet.add(key);
            } else if (value == max) {
                maxKeySet.add(key);
            }
        }
        if (maxKeySet.size() > 1) {
            Integer minKey = Collections.min(maxKeySet);
            maxKeySet.remove(minKey);
        }
        return Collections.min(maxKeySet);
    }

    private static int getRangeBetweenMinMax(int[] arr) {
        if (arr.length == 0) return 0;
        OptionalInt max = Arrays.stream(arr).max();
        OptionalInt min = Arrays.stream(arr).min();

        return max.getAsInt() - min.getAsInt();
    }
}
