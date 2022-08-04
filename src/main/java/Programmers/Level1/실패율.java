package Programmers.Level1;

import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {

    public static void main(String[] ages) {
        Solution42889 solution42889 = new Solution42889();
        System.out.println(Arrays.toString(solution42889.solution(4, new int[]{1, 2, 3, 2, 1})));
    }
}

class Solution42889 {
    public int[] solution(int N, int[] stages) {
        long user = stages.length;
        HashSet<Integer> stageNumberSet = getStageNumberBySort(stages, N);
        List<Long> numberOfUserOnStage = getNumberOfUserOnStage(stageNumberSet, stages);
        List<Double> answer = failRateByStage(N, user, numberOfUserOnStage);
        return getStageRank(answer);
    }

    private List<Double> failRateByStage(int N, long user, List<Long> numberOfUserOnStage) {
        List<Double> answer = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            if(user != 0) {
                answer.add((double) numberOfUserOnStage.get(i) / (double) user);
            } else {
                answer.add(0.0);
            }
            user -= numberOfUserOnStage.get(i);
        }
        return answer;
    }

    private int[] getStageRank(List<Double> answer) {
        int[] result = new int[answer.size()];
        List<Double> copy = new ArrayList<>(answer);
        answer.sort(Collections.reverseOrder());
        for(int i = 0; i < answer.size(); i++) {
            int index = copy.indexOf(answer.get(i));
            copy.set(index, 999.9);
            result[i] = index + 1;
        }
        return result;
    }

    private List<Long> getNumberOfUserOnStage(HashSet<Integer> stageNumber, int[] stages) {
        return stageNumber.stream().map(
                        x -> Arrays.stream(stages).filter(y -> y == x).count())
                .collect(Collectors.toList());
    }

    private HashSet<Integer> getStageNumberBySort(int[] stages, int n) {
        int max = Math.max(Arrays.stream(stages).max().getAsInt(), n);
        HashSet<Integer> stageNumberSet = new HashSet<>();
        for(int i = 1; i <= max; i++) {
            stageNumberSet.add(i);
        }
        return stageNumberSet;
    }
}