package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10866 {

    static List<Integer> deque = new ArrayList<>();

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
            case "push_front":
                deque.add(0, data);
                break;
            case "push_back":
                deque.add(data);
                break;
            case "pop_front":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer integer = deque.get(0);
                    deque.remove(0);
                    System.out.println(integer);
                }
                break;
            case "pop_back":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer integer = deque.get(deque.size() - 1);
                    deque.remove(deque.size() - 1);
                    System.out.println(integer);
                }
                break;
            case "size":
                System.out.println(deque.size());
                break;
            case "empty":
                int isEmptyFlag = deque.isEmpty() ? 1 : 0;
                System.out.println(isEmptyFlag);
                break;
            case "front":
                if(deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(0));
                }
                break;
            case "back":
                if(deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(deque.size() - 1));
                }
                break;
            default:
                System.out.println("커맨드를 확인하세요.");
        }
    }
}
