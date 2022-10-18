package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1966 {

    static int n;
    static BufferedReader br;

    static List<Task> taskList;
    static int target;

    static class Task {
        int idx;
        int weight;

        public Task(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        while (n-- > 0) run();
    }

    private static void run() throws IOException {
        subInit();
        int i = 0;

        while (!taskList.isEmpty()) {
            Task task = taskList.remove(0);
            boolean isPrintable = check(task);
            if (!isPrintable) {
                taskList.add(task);
            } else {
                i++;
                if (task.idx == target + 1) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean check(Task task) {
        int weight = task.weight;

        for (Task t: taskList) {
            if (t.weight > weight) {
                return false;
            }
        }
        return  true;
    }

    private static void subInit() throws IOException {
        String[] strings = br.readLine().split(" ");
        int cnt = Integer.parseInt(strings[0]);
        target = Integer.parseInt(strings[1]);
        taskList = new ArrayList<>(cnt);

        String[] weights = br.readLine().split(" ");

        for (int idx = 1; idx <= cnt; idx++) {
            int weight = Integer.parseInt(weights[idx - 1]);
            taskList.add(new Task(idx, weight));
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}
