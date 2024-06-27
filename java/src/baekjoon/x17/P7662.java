package baekjoon.x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int k = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else {
                if (map.isEmpty()) {
                    continue;
                }
                Integer key;
                if (number == 1) {
                    key = map.lastKey();
                } else {
                    key = map.firstKey();
                }
                Integer count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }
        if (map.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            Entry<Integer, Integer> lastEntry = map.pollLastEntry();
            Entry<Integer, Integer> firstEntry;
            if (map.isEmpty()) {
                firstEntry = lastEntry;
            } else {
                firstEntry = map.pollFirstEntry();
            }
            System.out.printf("%d %d%n", lastEntry.getKey(), firstEntry.getKey());
        }
    }
}

/*
TreeSet 활용한 풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int k = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1 > o2 ? 1 : -1);
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            if (command.equals("I")) {
                set.add(number);
            } else {
                if (set.isEmpty()) {
                    continue;
                }
                if (number == 1) {
                    set.pollLast();
                } else {
                    set.pollFirst();
                }
            }
        }
        if (set.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.printf("%d %d%n", set.last(), set.first());
        }
    }
}
 */
