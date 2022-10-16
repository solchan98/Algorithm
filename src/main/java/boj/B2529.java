package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2529 {

    static int n;
    static boolean[] visited;
    static String[] flagArr;
    static List<String> resultList = new ArrayList<>();

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flagArr = br.readLine().split(" ");
//        flagArr = new boolean[strings.length];
//        for (int idx = 0; idx < strings.length; idx++) {
//            flagArr[idx] = strings[idx].equals(">");
//        }
        visited = new boolean[10];
    }

    private static void dfs(String num, int idx) {
        if(idx == n + 1) {
            resultList.add(num);
            return;
        }

        for(int i = 0 ; i < 10; i++) {
            if (!visited[i]) {
                if(idx == 0 || validate(Integer.parseInt(num.substring(idx - 1, idx)), i, flagArr[idx-1])) {
                    visited[i] = true;
                    dfs(num + i, idx + 1);
                    visited[i] = false;
                }
            }
        }

    }

    private static boolean validate(int a, int b, String flag) {
        return flag.equals(">") ? a > b : a < b;
    }

    private static void print() {
        if (!resultList.isEmpty()) {
            System.out.println(resultList.get(resultList.size() - 1));
            System.out.println(resultList.get(0));
        } else {
            System.out.println("결과가 존재하지 않습니다.");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs("",0);
        print();
    }
}
