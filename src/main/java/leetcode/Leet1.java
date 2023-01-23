package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet1 {

    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>(nums.length * 2);
        int[] answer = new int[2];

        table.put(nums[0], 0);
        for (int idx = 1; idx < nums.length; idx++) {
            int match = target - nums[idx];

            if (table.containsKey(match)) {
                answer[0] = idx;
                answer[1] = table.get(match);
                break;
            }

            table.put(nums[idx], idx);
        }

        return answer;
    }

}
