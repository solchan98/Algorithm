package Programmers.Level1;

public class 나머지가_1이_되는_수_찾기 {
    public static void main(String[] args) {
        Solution87389 solution87389 = new Solution87389();
        System.out.println(solution87389.solution(12));

    }
}

class Solution87389 {
    public int solution(int n) {
        int answer = -1;
        for(int i = 1; i < n; i ++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
