package programmers;

import java.util.*;

public class PRO1 {
    Map<String, Integer> map;
    List<String> answer = new ArrayList<>();

    /**
     * 메뉴 리뉴얼
     */
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++)
                comb(orders[j], 0, 0, course[i], new StringBuilder());

            for (Integer value : map.values())
                max = Math.max(max, value);

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && max == entry.getValue())
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private void comb(String order, int cnt, int s, int e, StringBuilder sb) {
        if (cnt == e) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = s; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(order, cnt + 1, i + 1, e, sb);
            sb.delete(cnt, cnt + 1);
        }
    }
}
