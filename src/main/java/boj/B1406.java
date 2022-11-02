package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1406 {

    static int commandCnt;

    static Stack<Character> leftStack = new Stack<>();
    static Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for (int idx = 0; idx < s.length(); idx++) {
            leftStack.push(s.charAt(idx));
        }

        commandCnt = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < commandCnt; idx++) {
            String cmd = br.readLine();
            execute(cmd);
        }
        print();
    }

    public static void execute(String command) {
        switch (command.charAt(0)) {
            case 'P': {
                leftStack.push(command.charAt(2));
                break;
            }
            case 'L' : {
                if (leftStack.isEmpty()) break;
                rightStack.push(leftStack.pop());
                break;
            }
            case 'D': {
                if (rightStack.isEmpty()) break;
                leftStack.push(rightStack.pop());
                break;
            }
            case 'B': {
                if (leftStack.isEmpty()) break;
                leftStack.pop();
            }
        }
    }

    public static void print() {

        StringBuilder str = new StringBuilder();

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            str.append(rightStack.pop());
        }

        System.out.println(str);
    }
}


