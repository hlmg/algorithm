package kakao.blind2019;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] reached = new int[N + 2];

        int person = stages.length;
        for (int stage : stages) {
            reached[stage]++;
        }

        Map<Integer, Double> stageToFailureRate = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (reached[i] == 0) {
                stageToFailureRate.put(i, 0.0);
            } else {
                stageToFailureRate.put(i, reached[i] * 1.0 / person);
            }
            person -= reached[i];
        }

        List<Integer> failureRate = stageToFailureRate.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Entry::getKey)
                .collect(Collectors.toList());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failureRate.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        실패율 solution = new 실패율();
        solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution.solution(4, new int[]{4,4,4,4,4});
        solution.solution(4, new int[]{3, 3, 3, 3, 3});
    }
}
