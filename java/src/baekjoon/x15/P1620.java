package baekjoon.x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            String index = String.valueOf(i);
            map.put(name, index);
            map.put(index, name);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }
}
