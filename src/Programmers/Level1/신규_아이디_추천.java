package Programmers.Level1;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        Solution72410 solution72410 = new Solution72410();
        String result = solution72410.solution(	"././././가나;:./abcd/././././.");
        System.out.println(result);
    }
}

class Solution72410 {
    public String solution(String new_id) {
        if(!new_id.isEmpty()) {
            new_id = this.step1(new_id);
            new_id = this.step2(new_id);
            new_id = this.step3(new_id);
            new_id = this.step4(new_id);
            new_id = this.step6(new_id);
            new_id = this.step7(new_id);
        } else {
            new_id = this.step5();
        }
        return new_id;
    }

    public String step1(String id) {
        return id.toLowerCase();
    }
    public String step2(String id) {
        return id.replaceAll("[A-Z 가-힣 ㄱ-ㅎ ㅏ-ㅣ \\\\!?|~`:;@#$%^&\"',<>₩*()/{}\\[\\]+=]", "");
    }
    public String step3(String id) {
        return id.replaceAll("\\.+", ".");
    }
    public String step4(String id) {
        if(id.charAt(0) == '.') {
            id = id.substring(1);
        }
        if(id.length() != 0){
            if (id.charAt(id.length() - 1) == '.') {
                id = id.substring(0, id.length() - 1);
            }
        }
        return id;
    }
    public String step5() {
        String id = "a";
        while(id.length() < 3) {
            id = this.step7(id);
        }
        return id;
    }
    public String step6(String id) {
        if(id.length() > 15) {
            id = id.substring(0, 15);
            while (id.charAt(id.length() - 1) == '.') {
                id = this.step4(id);
            }
        }
        return id;
    }
    public String step7(String id) {
        if(id.isEmpty()) {
            id = this.step5();
        }
        char ch = id.charAt(id.length() - 1);
        while(id.length() < 3) {
            id += ch;
        }
        return id;
    }
}
