package Programmers.Level1;

public class 삼총사 {
    static int result = 0;

    public static void main(String[] args) {}

    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        combination(number, visited, 0, 3);
        return result;
    }

    private void combination(int[] arr, boolean[] visited, int start, int cnt) {
        if (cnt == 0) {
            result += checkTrio(arr, visited) ? 1 : 0;
        } else {
            for (int idx = start; idx < arr.length; idx++) {
                visited[idx] = true;
                combination(arr, visited, idx + 1, cnt - 1);
                visited[idx] = false;
            }
        }
    }

    private boolean checkTrio(int[] arr, boolean[] visited) {
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            if (visited[idx]) {
                sum += arr[idx];
            }
        }
        return sum == 0;
    }
}
