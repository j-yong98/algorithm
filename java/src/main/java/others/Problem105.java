package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem105 {
    int n, m;
    String[] arr1;
    String[] arr2;
    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();
    int cnt = 0;

    /**
     * ATGC
     * ATGC가 조합된 M개의 알파벳이 적혀있다.
     * 이 중에 3자리를 이용해 A,B로 그룹을 나눌 때 경우의 수를 출력하라.
     * n = 1 to 500
     * m = 3 to 50
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new String[n];
        arr2 = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = st.nextToken();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i] = st.nextToken();
        }
        for (int j = 0; j < m; j++) {
            for (int k = j + 1; k < m; k++) {
                for (int l = k + 1; l < m; l++) {
                    set1.clear();
                    set2.clear();
                    boolean flag = true;
                    for (int i = 0; i < n; i++) {
                        String cb1 = Character.toString(arr1[i].charAt(j)) + Character.toString(arr1[i].charAt(k)) + Character.toString(arr1[i].charAt(l));
                        String cb2 = Character.toString(arr2[i].charAt(j)) + Character.toString(arr2[i].charAt(k)) + Character.toString(arr2[i].charAt(l));
                        set1.add(cb1);
                        set2.add(cb2);
                    }
                    for (String s : set1) {
                        if (set2.contains(s)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
