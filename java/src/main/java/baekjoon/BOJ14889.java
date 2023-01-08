package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14889 {
    int n;
    int[][] arr;
    int ans = Integer.MAX_VALUE;
    List<Integer> team1 = new ArrayList<>();
    List<Integer> team2 = new ArrayList<>();
    private int getTotalAbility(List<Integer> team){
        int ability = 0;
        for (int i = 0; i < team.size(); i++){
            int a = team.get(i);
            for (int j = 0; j < team.size(); j++){
                if (i == j) continue;
                int b = team.get(j);
                ability += arr[a][b];
            }
        }
        return ability;
    }
    private int valueTeamAbility(){
        if (team1.size() != team2.size()) return Integer.MAX_VALUE;
        int t1 = getTotalAbility(team1);
        int t2 = getTotalAbility(team2);
        return Math.abs(t1-t2);
    }
    private void makeTeam(int l){
        if (l == n){
            ans = Math.min(ans,valueTeamAbility());
            return;
        }
        team1.add(l);
        makeTeam(l+1);
        team1.remove(team1.size()-1);

        team2.add(l);
        makeTeam(l+1);
        team2.remove(team2.size()-1);
    }
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0);
        System.out.println(ans);
        return ans;
    }
}
