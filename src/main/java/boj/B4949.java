package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            checkStringIsBalanced(str);
        }

    }

    private static void checkStringIsBalanced(String str) {
        Map<String, String> bracketMap = new HashMap<>(2);
        bracketMap.put("(", ")");
        bracketMap.put("[", "]");

        Deque<String> deque = new LinkedList<>();

        for (String s: str.split("")) {
            if (s.equals("(") || s.equals("[")) {
                deque.push(s);
            } else if (s.equals(")") || s.equals("]")) {
                if (deque.size() == 0) {
                    printResult("no");
                    return;
                }
                String bracket = deque.pop();
                if (!bracketMap.get(bracket).equals(s)) {
                    printResult("no");
                    return;
                }
            }
        }

        if (deque.size() > 0) {
            printResult("no");
        } else {
            printResult("yes");
        }
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}
