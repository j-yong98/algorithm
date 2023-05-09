package others;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem149 {
    int T;
    /**
     * 신뢰
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Deque<Integer> B = new ArrayDeque<>();
            Deque<Integer> O = new ArrayDeque<>();
            Deque<String> orders = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                String turn = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                if (turn.equals("O"))
                    O.add(k);
                else
                    B.add(k);
                orders.add(turn);
            }
            int Bx = 1, Ox = 1, time = 0;
            while (!orders.isEmpty()) {
                if (orders.peek().equals("B")) {
                    if (Bx < B.peek())
                        Bx++;
                    else if (Bx > B.peek())
                        Bx--;
                    else {
                        B.pollFirst();
                        orders.pollFirst();
                    }
                    if (!O.isEmpty()) {
                        if (O.peek() > Ox)
                            Ox++;
                        else if (O.peek() < Ox)
                            Ox--;
                    }
                }
                else {
                    if (Ox < O.peek())
                        Ox++;
                    else if (Ox > O.peek())
                        Ox--;
                    else {
                        O.pollFirst();
                        orders.pollFirst();
                    }
                    if (!B.isEmpty()) {
                        if (Bx < B.peek())
                            Bx++;
                        else if (Bx > B.peek())
                            Bx--;
                    }
                }
                time++;
            }
            bw.write(time + "\n");
        }
        bw.flush();
        bw.close();
    }
}
