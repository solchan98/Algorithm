package Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p217 {

    public static int[] d = new int[30001];

    public static  void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());

        for(int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
            if(i % 5 == 0) d[i] = Math.min(d[i], d[i / 5] + 1);
        }
        System.out.println(d[x]);
    }
}

/** 풀이
 * Bottom Up 방식의 반복문
 * 계산 방식은 -1, %2, %3, %5가 있다.
 * 우선, 작은 계산인 -1 결과를 d에 저장.
 * 2, 3, 5로 나누어 떨어지는 경우에 앞에 계산한 d[i / 2]와 d[i / 3], d[i / 5]  현재의 d[i]와 비교를 하여
 * 그 중 최소 값을 d[i]에 다시 저장(메모이제이션)합니다.
 */