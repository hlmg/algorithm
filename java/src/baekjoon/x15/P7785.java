package baekjoon.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine().split(" ")[0];
            if (set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
