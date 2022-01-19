package Programmers.Level1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        Solution92334 solution92334 = new Solution92334();

        System.out.println(Arrays.toString(solution92334.solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3
        )));
    }
}

class Solution92334 {
    public int[] solution( String[] idList, String[] reportList, int k) {
        Map<String, List<String>> reportStatus = new HashMap<>();
        List<String> reportedList = new ArrayList<>();
        setReportStatusAndReportedList(reportList, reportStatus, reportedList);
        Set<String> banList = getBanList(reportedList, k);
        return getSendMailList(idList, reportStatus, banList);
    }

    private void setReportStatusAndReportedList(String[] reportList, Map<String, List<String>> reportStatus, List<String> reportedList) {
        for (String report: reportList) {
            String[] list = report.split(" ");
            if(Objects.isNull(reportStatus.get(list[0]))) {
                reportStatus.put(list[0], new ArrayList<>());
            }
            if(!reportStatus.get(list[0]).contains(list[1])){
                reportStatus.get(list[0]).add(list[1]);
                reportedList.add(list[1]);
            }
        }
    }

    private int[] getSendMailList(String[] idList, Map<String, List<String>> reportStatus, Set<String> banList) {
        int[] result = new int[idList.length];
        for(int i = 0; i < idList.length; i++) {
            for(String ban: banList) {
                List<String> strings = reportStatus.get(idList[i]);
                if(!Objects.isNull(strings)) {
                    if(strings.contains(ban)) {
                        result[i] += 1;
                    }
                }
            }
        }
        return result;
    }

    private Set<String> getBanList(List<String> reportedList, int k) {
        Set<String> banList = new HashSet<>();
        for(int i = 0; i < reportedList.size(); i++) {
            int frequency = Collections.frequency(reportedList, reportedList.get(i));
            if(frequency >= k) {
                banList.add(reportedList.get(i));
            }
        }
        return banList;
    }
}