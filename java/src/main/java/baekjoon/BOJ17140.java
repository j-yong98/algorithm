package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {
    class NumCount implements Comparable<NumCount> {
        int num;
        int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(NumCount o) {
            if (this.count == o.count)
                return this.num - o.num;
            return this.count - o.count;
        }
    }
    final int LIMIT = 100;
    int r, c, k;
    int[][] arr = new int[3][3];
    int tries = 0;

    private NumCount findNumCount(List<NumCount> list, int find) {
        for (NumCount numCount : list) {
            if (numCount.num == find)
                return numCount;
        }
        return null;
    }

    public int[] makeNewArray(int[] tmp) {
        List<NumCount> list = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            NumCount find = findNumCount(list, tmp[i]);
            if (tmp[i] == 0)
                continue;
            if (find == null)
                list.add(new NumCount(tmp[i], 1));
            else
                find.count++;
        }
        Collections.sort(list);
        tmp = new int[list.size() * 2];
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            NumCount nc = list.get(i);
            tmp[idx++] = nc.num;
            tmp[idx++] = nc.count;
        }
        return tmp;
    }

    private int[][] calcNewArray(int y, int x, int classify) {
        List<int[]> tmpList = new ArrayList<>();
        int[] tmp;
        tmp = new int[classify == 0 ? y : x];
        for (int i = 0; i < y; i++) {
            int[] res;
            for (int j = 0; j < x; j++) {
                if (classify == 0)
                    tmp[j] = arr[i][j];
                else
                    tmp[j] = arr[j][i];
            }
            res = makeNewArray(tmp);
            tmpList.add(res);
        }
        int maxLength = Integer.MIN_VALUE;
        for (int[] ints : tmpList)
            maxLength = Math.max(maxLength, Long.valueOf(Arrays.stream(ints).count()).intValue());
        int[][] newArray;
        if (classify == 0)
            newArray = new int[y][maxLength];
        else
            newArray = new int[maxLength][y];
        for (int i = 0; i < tmpList.size(); i++) {
            tmp = tmpList.get(i);
            for (int j = 0; j < tmp.length; j++) {
                if (classify == 0)
                    newArray[i][j] = tmp[j];
                else
                    newArray[j][i] = tmp[j];
            }
        }
        return newArray;
    }
    private void printArray(int[][] printArray) {
        for (int[] ints : printArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
    private boolean inRange(int y, int x, int r, int c) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
    private int[][] resize(int[][] check) {
        int rowSize = Long.valueOf(Arrays.stream(check).count()).intValue();
        int colSize = Long.valueOf(Arrays.stream(check).flatMapToInt(Arrays::stream).count()).intValue() / rowSize;
        int[][] tmp = check;
        if (rowSize > LIMIT) {
            tmp = new int[rowSize - LIMIT][colSize];
            for (int i = LIMIT + 1; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++)
                    tmp[i - LIMIT][j] = check[i][j];
            }
            rowSize -= LIMIT;
        }
        if (colSize > LIMIT) {
            tmp = new int[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) {
                for (int j = LIMIT + 1; j < colSize; j++) {
                    tmp[i][j - LIMIT] = check[i][j];
                }
            }
        }
        return tmp;
    }
    private void calc() {
        while (tries <= LIMIT) {
            int rowSize = Long.valueOf(Arrays.stream(arr).count()).intValue();
            int colSize = Long.valueOf(Arrays.stream(arr).flatMapToInt(Arrays::stream).count()).intValue() / rowSize;
            if (inRange(r,c, rowSize, colSize) && arr[r][c] == k)
                break;
            if (rowSize >= colSize) {
                arr = calcNewArray(rowSize, colSize, 0);
            } else {
                arr = calcNewArray(colSize, rowSize, 1);
            }
            arr = resize(arr);
            tries++;
        }
    }

    /**
     * 이차원 배열과 연산
     */
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        calc();
        System.out.println(tries == LIMIT + 1 ? -1 : tries);
        return tries == LIMIT + 1 ? -1 : tries;
    }
}