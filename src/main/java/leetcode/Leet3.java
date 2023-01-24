package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Leet3 {
    public static void main(String[] args) {
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Deque<String> deque = new ArrayDeque<>();
        Set<String> strings = new HashSet<>();

        if (s.length() == 0) {
            return max;
        }

        for (String string: s.split("")) {
            if (strings.contains(string)) {
                remove(deque, strings, string);
            }
            deque.add(string);
            strings.add(string);
            max = Math.max(max, deque.size());
        }
        return max;
    }

    private void remove(Deque<String> deque, Set<String> strings, String target) {
        String removed = deque.remove();
        strings.remove(removed);

        if (!removed.equals(target)) {
            remove(deque, strings, target);
        }
    }
}
