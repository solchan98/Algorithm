package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10814 {

    static Member[] members;

    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(members, (a, b) -> a.age - b.age);
        Arrays.stream(members).forEach((m) -> System.out.println(m.toString()));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        members = new Member[N];

        for(int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            members[i] = new Member(Integer.parseInt(strings[0]), strings[1]);
        }
    }
}
