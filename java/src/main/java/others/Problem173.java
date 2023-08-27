package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem173 {
    final int PERSON = 1;
    int T;
    int N;
    int[][] arr;
    int[][] stairs = new int[2][2];
    boolean[] checked;
    List<Person> persons;
    List<Integer> stair1;
    int ans;
    /**
     * 점심 식사시간
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int stairIdx = 0;
            ans = Integer.MAX_VALUE;
            persons = new ArrayList<>();
            stair1 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == PERSON)
                        persons.add(new Person(i, j));
                    else if (isStair(arr[i][j]))
                        stairs[stairIdx++] = new int[]{i, j};
                }
            }
            checked = new boolean[persons.size()];
            pickStair(0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private void pickStair(int n) {
        if (n == persons.size()) {
            ans = Math.min(ans, calcMinutes());
            return;
        }
        checked[n] = true;
        stair1.add(n);
        pickStair(n + 1);
        stair1.remove(stair1.size() - 1);
        checked[n] = false;
        pickStair(n + 1);
    }

    private int calcMinutes() {
        List<Integer> stair2 = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (checked[i]) continue;
            stair2.add(i);
        }

        int min1 = walkDown(stair1, 0);
        int min2 = walkDown(stair2, 1);

        return Math.max(min1, min2) + 1;
    }

    private int walkDown(List<Integer> stair, int idx) {
        if (stair.isEmpty()) return 0;
        List<Integer> dist = new ArrayList<>();
        int k = arr[stairs[idx][0]][stairs[idx][1]];
        for (int i = 0; i < stair.size(); i++)
            dist.add(getDist(stairs[idx], persons.get(stair.get(i))));
        Collections.sort(dist);

        for (int i = 3; i < dist.size(); i++)
            dist.set(i, Math.max(dist.get(i), dist.get(i - 3) + k));

        return dist.get(dist.size() - 1) + k;
    }

    private int getDist(int[] a, Person person) {
        return Math.abs(a[0] - person.y) + Math.abs(a[1] - person.x);
    }

    private boolean isStair(int num) {
        return num >= 2 && num <= 10;
    }

    static class Person {
        int y;
        int x;

        public Person(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
