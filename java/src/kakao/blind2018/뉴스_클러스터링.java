package kakao.blind2018;

import java.util.*;

public class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();


        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> keys = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }

            String s = str1.substring(i, i + 2);
            map1.put(s, map1.getOrDefault(s, 0) + 1);
            keys.add(s);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }

            String s = str2.substring(i, i + 2);
            map2.put(s, map2.getOrDefault(s, 0) + 1);
            keys.add(s);
        }

        if (keys.isEmpty()) {
            return 65536;
        }

        int intersection = 0;
        int union = 0;
        for (String key : keys) {
            boolean has1 = map1.containsKey(key);
            boolean has2 = map2.containsKey(key);

            if (has1 && has2) {
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else if (has1) {
                union += map1.get(key);
            } else if (has2) {
                union += map2.get(key);
            }
        }

        if (union == 0) {
            return 0;
        }

        return (int) (intersection * 1.0 / union * 65536);
    }

    public static void main(String[] args) {
    }
}
