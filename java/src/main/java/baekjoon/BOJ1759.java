package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    int l,c;
    char[] arr;
    char[] words;
    int[] check;

    private boolean isPossible(){
        int cCnt = 0;
        int vCnt = 0;

        for (int i = 0; i < l; i++){
            if (words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u'){
                vCnt++;
            }
            else{
                cCnt++;
            }
        }
        if (cCnt >= 2 && vCnt >= 1){
            return true;
        }
        return false;
    }
    private void print(){
        for (char word : words) {
            System.out.print(word);
        }
        System.out.println();
    }
    private void f(int cnt,int idx){
        if (cnt == l){
            if (isPossible()){
                print();
            }
            return;
        }
        for (int i = idx; i < c; i++){
            if (check[i] == 0) {
                words[cnt] = arr[i];
                check[i] = 1;
                f(cnt + 1,i);
                check[i] = 0;
            }
        }
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        words = new char[l];
        check = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        f(0,0);
    }
}
