package baekjoon.x0f;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Long num = Long.valueOf(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Long maxKey = 0L;
        int maxValue = 0;
        for (Entry<Long, Integer> entry : map.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        System.out.print(maxKey);
    }
}
