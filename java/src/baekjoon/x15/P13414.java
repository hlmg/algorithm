package baekjoon.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class P13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kl = br.readLine().split(" ");
        int k = Integer.parseInt(kl[0]);
        int l = Integer.parseInt(kl[1]);

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String input = br.readLine();
            set.remove(input);
            set.add(input);
        }

        String[] arr = set.toArray(new String[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k && i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
