package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1406 {

    static int commandCnt;

    static StringBuilder str = new StringBuilder();
    static int current;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str.append(br.readLine());
        current = str.length();
        commandCnt = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < commandCnt; idx++) {
            String s = br.readLine();
            execute(s);
        }

        System.out.println(str.toString());

    }

    public static void execute(String command) {
        switch (command.charAt(0)) {
            case 'P': {
                String[] strings = command.split(" ");
                str.insert(current, strings[1]);
                current++;
                break;
            }
            case 'L' : {
                if (current > 0) current--;
                break;
            }
            case 'D': {
                if (current < str.length()) current++;
                break;
            }
            case 'B': {
                if (current == 0) break;

                str.delete(current - 1, current);
                execute("L");
                break;
            }
            default:
        }
    }
}
