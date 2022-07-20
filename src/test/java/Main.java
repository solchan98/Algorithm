package test.java;


import leetcode.Leet1823;
import org.junit.jupiter.api.Test;

class Main {

    @Test
    void test() {
        Leet1823 solution = new Leet1823();
        int theWinner = solution.findTheWinner(6, 5);
        System.out.println(theWinner);
    }

}
