package kakao.blind2018;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> que = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (que.contains(city)) {
                que.remove(city);
                answer += 1;
            } else {
                answer += 5;
            }

            que.offer(city);
            if (que.size() > cacheSize) {
                que.poll();
            }
        }
        return answer;
    }
}
