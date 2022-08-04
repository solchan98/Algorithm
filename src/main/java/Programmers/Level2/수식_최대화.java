package Programmers.Level2;

import java.util.*;

public class 수식_최대화 {
    private static final List<String> opList = new ArrayList<>();
    private static final List<Long> numList = new ArrayList<>();
    private static final Set<String> opSet = new HashSet<>();
    private static final List<String[]> opCaseList = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0;
        makeOpListAndNumList(expression);
        findOpCaseList(new ArrayList<>(opSet));
        for (String[] opCase: opCaseList) {
            List<String> copyOpList = new ArrayList<>(opList);
            List<Long> copyNumList = new ArrayList<>(numList);
            for (String op: opCase) {
                for (int i = 0; i < copyOpList.size(); i++) {
                    if (!copyOpList.get(i).equals(op)) continue;
                    copyNumList.set(i, calc(copyNumList.get(i), copyNumList.get(i + 1), op));
                    copyNumList.remove(i + 1);
                    copyOpList.remove(i);
                    i--;
                }
            }
            answer = Math.max(answer, Math.abs(copyNumList.get(0)));
        }
        return answer;
    }

    private void makeOpListAndNumList(String expression) {
        StringBuilder numberStr = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                opList.add(String.valueOf(c));
                opSet.add(String.valueOf(c));
                numList.add(Long.valueOf(numberStr.toString()));

                numberStr = new StringBuilder();
            } else {
                numberStr.append(c);
            }
        }
        numList.add(Long.valueOf(numberStr.toString()));
    }

    private long calc(long num1, long num2, String op) {
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            default -> num1 * num2;
        };
    }

    private void findOpCaseList(List<String> arr) {
        boolean[] visited = new boolean[arr.size()];
        String[] output = new String[arr.size()];
        perm(arr, output, visited, 0, arr.size(), arr.size());
    }

    private void perm(List<String> arr, String[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            opCaseList.add(output.clone());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr.get(i);
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
