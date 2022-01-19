package Programmers.Level1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        Solution92334 solution92334 = new Solution92334();

        System.out.println(Arrays.toString(solution92334.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        )));
    }
}

class Solution92334 {
    public int[] solution( String[] idList, String[] reportList, int k) {
        Map<String, List<String>> reportStatus = new HashMap<>();
        List<String> reportedList = new ArrayList<>();
        setReportStatusAndReportedList(reportList, reportStatus, reportedList);
        Set<String> banList = getBanList(reportStatus, k);
        return getSendMailList(idList, reportStatus, banList);
    }

    private int[] getSendMailList(String[] idList, Map<String, List<String>> reportStatus, Set<String> banList) {
        Map<String, Integer> sendMailCntMap = new LinkedHashMap<>();
        initSendMailCntMap(idList, sendMailCntMap);
        calSendMailCntMap(reportStatus, banList, sendMailCntMap);
        return calSendMailCntList(idList, sendMailCntMap);
    }

    private int[] calSendMailCntList(String[] idList, Map<String, Integer> sendMailCntMap) {
        int[] sendMailCntList = new int[idList.length];
        final int[] i = {0};
        sendMailCntMap.forEach((key, value) -> sendMailCntList[i[0]++] = value);
        return sendMailCntList;
    }

    private void calSendMailCntMap(Map<String, List<String>> reportStatus, Set<String> banList, Map<String, Integer> sendMailCntMap) {
        for(String ban: banList) {
            List<String> strings = reportStatus.get(ban);
            strings.forEach( x-> sendMailCntMap.put(x, sendMailCntMap.get(x) +1));
        }
    }

    private void initSendMailCntMap(String[] idList, Map<String, Integer> sendMailCntMap) {
        for(String id: idList) {
            sendMailCntMap.put(id, 0);
        }
    }

    private Set<String> getBanList(Map<String, List<String>> reportStatus, int k) {
        Set<String> banList = new HashSet<>();
        reportStatus.forEach((key, value) -> {
            if(value.size() >= k) {
                banList.add(key);
            }
        });
        return banList;
    }

    private void setReportStatusAndReportedList(String[] reportList, Map<String, List<String>> reportStatus, List<String> reportedList) {
        for (String report: reportList) {
            String[] list = report.split(" ");
            if(!Objects.equals(list[0], list[1])){
                if(Objects.isNull(reportStatus.get(list[1]))) {
                    reportStatus.put(list[1], new ArrayList<>());
                }
                if(!reportStatus.get(list[1]).contains(list[0])){
                    reportStatus.get(list[1]).add(list[0]);
                }
            }
        }
    }
}