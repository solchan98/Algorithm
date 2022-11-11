package Programmers.Level1;

import java.util.*;

public class 햄버거_만들기 {

    static final String BURGER = "1231";

    public static void main(String[] args) {}

    public int solution(int[] ingredient) {
        int burgerCnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int ingr : ingredient) {
            list.add(ingr);

            if (list.size() >= 4) {
                StringBuilder sb = new StringBuilder();
                for (int jdx = 4; jdx > 0; jdx--) sb.append(list.get(list.size() - jdx));

                if (sb.toString().equals(BURGER)) {
                    burgerCnt += 1;
                    for (int kdx = 0; kdx < 4; kdx++) list.remove(list.size() - 1);
                }
            }
        }
        return burgerCnt;
    }
}
