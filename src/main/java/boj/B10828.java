package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10828 {

    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            String[] strings = br.readLine().split(" ");
            if (strings.length == 1) {
                execute(strings[0], null);
            } else {
                execute(strings[0], Integer.parseInt(strings[1]));
            }
        }
    }

    private static void execute(String command, Integer data) {
        switch (command) {
            case "push":
                stack.add(data);
                break;
            case "pop":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer integer = stack.get(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    System.out.println(integer);
                }
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                int isEmptyFlag = stack.isEmpty() ? 1 : 0;
                System.out.println(isEmptyFlag);
                break;
            case "top":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer integer = stack.get(stack.size() - 1);
                    System.out.println(integer);
                }
                break;
            default:
                System.out.println("커맨드를 확인하세요.");
        }
    }
}
