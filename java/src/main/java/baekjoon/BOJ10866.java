package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10866 {
    int n;

    /**
     * 덱
     */
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Deque q = new Deque();
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                int num = Integer.parseInt(cmd[1]);
                q.push_front(num);
            } else if (cmd[0].equals("push_back")) {
                int num = Integer.parseInt(cmd[1]);
                q.push_back(num);
            } else if (cmd[0].equals("pop_front")) {
                sb.append(q.pop_front()).append("\n");
            } else if (cmd[0].equals("pop_back")) {
                sb.append(q.pop_back()).append("\n");
            } else if (cmd[0].equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (cmd[0].equals("empty")) {
                sb.append(q.empty() ? 1 : 0).append("\n");
            } else if (cmd[0].equals("front")) {
                sb.append(q.front()).append("\n");
            } else if (cmd[0].equals("back")) {
                sb.append(q.back()).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static class Deque {
        final int MAX = 10_000;
        int[] data;
        int size;
        int front;
        int rear;

        public Deque() {
            data = new int[MAX + 1];
            front = 0;
            rear = 0;
            size = 0;
        }

        void push_front(int item) {
            int idx = (front + MAX - 1) % MAX;
            if (idx == rear) throw new IllegalStateException();
            data[front] = item;
            front = idx;
            size++;
        }

        void push_back(int item) {
            int idx = (rear + 1) % MAX;
            if (idx == front) throw new IllegalStateException();
            rear = idx;
            data[rear] = item;
            size++;
        }

        int pop_front() {
            if (empty()) return -1;
            front = (front + 1) % MAX;
            size--;
            return data[front];
        }

        int pop_back() {
            if (empty()) return -1;
            int tmp = data[rear];
            rear = (rear + MAX - 1) % MAX;
            size--;
            return tmp;
        }

        int size() {
            return size;
        }

        boolean empty() {
            if (size() == 0) return true;
            return false;
        }

        int front() {
            if (empty()) return -1;
            int idx = (front + 1) % MAX;
            return data[idx];
        }

        int back() {
            if (empty()) return -1;
            return data[rear];
        }
    }
}
