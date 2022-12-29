package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem47Test {

    @Test
    void solution() throws IOException {
        Problem47 problem47 = new Problem47();
        String p = "33 541 23 2\n" +
                "17 3 R 8\n" +
                "20 4 L 9\n" +
                "8 29 D 6\n" +
                "13 32 U 2\n" +
                "26 20 L 6\n" +
                "25 2 L 3\n" +
                "8 14 L 8\n" +
                "9 23 U 10\n" +
                "14 21 U 6\n" +
                "33 2 U 3\n" +
                "30 8 L 2\n" +
                "23 12 U 4\n" +
                "16 22 D 8\n" +
                "1 31 U 10\n" +
                "8 13 U 7\n" +
                "28 16 U 1\n" +
                "33 26 D 2\n" +
                "3 15 R 3\n" +
                "2 17 L 3\n" +
                "19 9 D 9\n" +
                "33 10 L 4\n" +
                "19 14 D 6\n" +
                "17 12 D 6\n" +
                "5 10 D 3\n" +
                "10 28 D 2\n" +
                "1 23 D 3\n" +
                "31 22 U 5\n" +
                "10 8 L 10\n" +
                "17 18 R 7\n" +
                "31 24 R 2\n" +
                "6 9 R 4\n" +
                "24 15 D 9\n" +
                "27 17 U 6\n" +
                "6 33 R 6\n" +
                "20 30 U 1\n" +
                "13 20 D 7\n" +
                "6 17 L 3\n" +
                "33 27 R 10\n" +
                "32 7 R 9\n" +
                "8 16 D 8\n" +
                "33 33 U 5\n" +
                "31 17 U 10\n" +
                "4 14 L 9\n" +
                "10 6 R 10\n" +
                "10 23 L 4\n" +
                "1 32 D 2\n" +
                "27 10 L 8\n" +
                "5 11 L 8\n" +
                "33 22 R 1\n" +
                "4 33 U 8\n" +
                "2 8 U 5\n" +
                "29 8 L 10\n" +
                "20 7 R 2\n" +
                "23 16 R 8\n" +
                "24 20 R 1\n" +
                "8 31 U 1\n" +
                "18 14 D 5\n" +
                "20 28 D 9\n" +
                "22 8 D 1\n" +
                "3 29 L 10\n" +
                "29 21 D 8\n" +
                "19 24 U 5\n" +
                "31 4 D 6\n" +
                "23 21 U 10\n" +
                "11 29 R 3\n" +
                "9 32 L 9\n" +
                "6 25 R 7\n" +
                "13 17 L 4\n" +
                "1 18 D 3\n" +
                "27 33 U 5\n" +
                "15 6 L 5\n" +
                "5 25 U 9\n" +
                "16 31 L 9\n" +
                "13 23 U 9\n" +
                "13 29 U 4\n" +
                "10 17 L 6\n" +
                "1 11 L 8\n" +
                "14 12 R 4\n" +
                "29 4 R 4\n" +
                "17 4 L 2\n" +
                "14 15 R 4\n" +
                "1 8 D 6\n" +
                "15 12 R 5\n" +
                "31 5 R 10\n" +
                "6 31 R 4\n" +
                "16 16 L 6\n" +
                "4 23 L 7\n" +
                "22 32 R 7\n" +
                "30 29 L 1\n" +
                "17 25 U 1\n" +
                "22 5 U 6\n" +
                "10 2 L 6\n" +
                "21 28 D 6\n" +
                "28 13 R 3\n" +
                "7 11 L 7\n" +
                "26 18 D 6\n" +
                "17 7 L 4\n" +
                "29 3 D 4\n" +
                "4 17 L 10\n" +
                "6 7 R 6\n" +
                "25 9 R 6\n" +
                "3 9 R 1\n" +
                "32 5 U 10\n" +
                "30 32 D 5\n" +
                "10 20 U 2\n" +
                "12 24 D 2\n" +
                "32 20 U 5\n" +
                "4 18 L 1\n" +
                "17 13 R 4\n" +
                "9 14 R 8\n" +
                "17 5 R 2\n" +
                "8 1 U 8\n" +
                "27 6 U 8\n" +
                "12 13 R 6\n" +
                "24 19 U 3\n" +
                "1 1 R 10\n" +
                "5 7 D 5\n" +
                "19 31 R 4\n" +
                "12 23 L 10\n" +
                "28 18 R 3\n" +
                "25 32 U 10\n" +
                "21 25 R 3\n" +
                "12 16 U 6\n" +
                "16 25 D 3\n" +
                "2 13 D 2\n" +
                "26 25 U 4\n" +
                "6 29 U 10\n" +
                "8 18 D 2\n" +
                "30 22 U 4\n" +
                "2 19 L 1\n" +
                "32 9 U 2\n" +
                "16 9 L 7\n" +
                "13 30 R 8\n" +
                "15 2 L 4\n" +
                "7 31 U 3\n" +
                "8 5 D 3\n" +
                "2 11 L 6\n" +
                "32 1 U 2\n" +
                "8 33 D 6\n" +
                "10 16 R 4\n" +
                "20 9 U 10\n" +
                "16 15 U 1\n" +
                "7 14 U 10\n" +
                "14 23 D 5\n" +
                "1 17 D 1\n" +
                "6 20 U 9\n" +
                "16 11 R 10\n" +
                "16 8 R 3\n" +
                "3 1 U 3\n" +
                "23 19 U 3\n" +
                "19 4 R 9\n" +
                "10 10 U 10\n" +
                "23 14 L 10\n" +
                "28 4 U 10\n" +
                "8 3 U 4\n" +
                "25 31 L 2\n" +
                "9 10 D 7\n" +
                "5 9 U 5\n" +
                "20 10 D 5\n" +
                "31 21 R 3\n" +
                "13 14 D 7\n" +
                "27 2 R 8\n" +
                "11 17 D 1\n" +
                "19 11 L 4\n" +
                "23 33 L 3\n" +
                "3 31 D 7\n" +
                "15 20 L 5\n" +
                "13 15 R 10\n" +
                "22 29 U 8\n" +
                "3 28 U 5\n" +
                "15 5 D 4\n" +
                "8 30 R 8\n" +
                "13 7 R 4\n" +
                "15 24 L 1\n" +
                "31 18 D 5\n" +
                "7 28 D 7\n" +
                "5 17 R 3\n" +
                "16 29 D 8\n" +
                "31 1 R 3\n" +
                "22 1 L 4\n" +
                "19 21 U 1\n" +
                "12 7 U 3\n" +
                "27 9 L 1\n" +
                "2 9 D 3\n" +
                "14 18 L 6\n" +
                "4 2 R 7\n" +
                "9 11 U 7\n" +
                "13 8 D 8\n" +
                "22 26 D 1\n" +
                "5 23 U 3\n" +
                "23 31 D 10\n" +
                "32 27 L 4\n" +
                "30 10 R 8\n" +
                "4 30 D 7\n" +
                "15 31 L 6\n" +
                "20 13 U 4\n" +
                "30 9 D 5\n" +
                "19 18 R 4\n" +
                "32 3 D 5\n" +
                "16 5 L 4\n" +
                "32 25 D 1\n" +
                "2 31 R 7\n" +
                "17 32 L 5\n" +
                "1 13 L 10\n" +
                "10 9 L 5\n" +
                "13 11 R 4\n" +
                "26 10 D 7\n" +
                "2 1 U 8\n" +
                "5 22 R 7\n" +
                "1 15 R 4\n" +
                "18 5 U 2\n" +
                "28 7 L 5\n" +
                "21 2 R 3\n" +
                "29 32 D 5\n" +
                "5 28 R 6\n" +
                "30 18 D 7\n" +
                "21 13 R 7\n" +
                "29 19 D 6\n" +
                "23 20 U 8\n" +
                "28 27 R 2\n" +
                "31 25 D 5\n" +
                "29 9 U 8\n" +
                "14 4 L 5\n" +
                "22 13 R 5\n" +
                "16 12 D 7\n" +
                "18 10 U 9\n" +
                "1 30 R 2\n" +
                "6 22 L 7\n" +
                "15 1 L 5\n" +
                "16 27 D 6\n" +
                "18 11 L 5\n" +
                "19 10 R 8\n" +
                "31 11 R 9\n" +
                "26 22 U 10\n" +
                "11 28 U 4\n" +
                "4 9 L 9\n" +
                "32 16 L 1\n" +
                "26 6 U 5\n" +
                "9 4 D 8\n" +
                "27 12 U 7\n" +
                "32 13 D 5\n" +
                "1 33 D 9\n" +
                "17 2 U 5\n" +
                "5 26 U 9\n" +
                "10 14 L 9\n" +
                "6 14 L 2\n" +
                "22 18 L 9\n" +
                "13 19 L 3\n" +
                "28 32 D 2\n" +
                "12 2 R 5\n" +
                "12 5 D 3\n" +
                "11 5 R 1\n" +
                "11 8 D 6\n" +
                "24 25 R 3\n" +
                "1 16 R 1\n" +
                "15 4 U 4\n" +
                "33 31 D 4\n" +
                "7 24 R 4\n" +
                "30 16 R 4\n" +
                "17 16 R 2\n" +
                "16 7 L 5\n" +
                "24 8 L 5\n" +
                "30 7 R 2\n" +
                "16 28 R 1\n" +
                "22 20 U 2\n" +
                "30 30 R 5\n" +
                "11 4 D 6\n" +
                "8 7 L 4\n" +
                "15 11 D 10\n" +
                "4 15 D 9\n" +
                "25 12 L 8\n" +
                "24 6 R 1\n" +
                "24 7 R 3\n" +
                "20 31 L 9\n" +
                "7 20 L 8\n" +
                "12 30 L 9\n" +
                "27 4 U 2\n" +
                "3 6 L 10\n" +
                "32 18 U 9\n" +
                "30 17 L 2\n" +
                "29 25 L 9\n" +
                "28 21 L 6\n" +
                "20 21 U 4\n" +
                "2 7 L 3\n" +
                "27 22 U 5\n" +
                "13 12 L 10\n" +
                "12 21 U 7\n" +
                "12 18 D 3\n" +
                "32 29 L 4\n" +
                "5 24 L 5\n" +
                "26 16 U 2\n" +
                "7 10 L 10\n" +
                "21 1 U 10\n" +
                "18 31 L 3\n" +
                "26 2 R 10\n" +
                "10 26 L 1\n" +
                "6 16 L 8\n" +
                "21 31 R 6\n" +
                "7 23 L 4\n" +
                "4 25 D 6\n" +
                "12 15 U 3\n" +
                "27 13 R 8\n" +
                "28 25 R 10\n" +
                "1 14 L 2\n" +
                "28 29 U 9\n" +
                "3 25 L 3\n" +
                "26 9 R 8\n" +
                "24 28 D 4\n" +
                "29 28 U 10\n" +
                "24 18 R 4\n" +
                "14 22 R 7\n" +
                "26 24 U 8\n" +
                "5 3 U 6\n" +
                "4 5 U 6\n" +
                "11 9 L 1\n" +
                "12 25 D 6\n" +
                "15 30 U 3\n" +
                "15 9 D 8\n" +
                "12 14 R 1\n" +
                "15 10 U 9\n" +
                "4 27 D 4\n" +
                "9 9 D 5\n" +
                "4 16 U 8\n" +
                "29 11 D 8\n" +
                "25 16 U 4\n" +
                "12 19 L 1\n" +
                "26 14 L 2\n" +
                "31 2 R 8\n" +
                "24 32 U 2\n" +
                "18 24 D 5\n" +
                "18 16 U 6\n" +
                "3 30 D 1\n" +
                "23 6 R 7\n" +
                "6 26 L 4\n" +
                "2 16 U 1\n" +
                "21 12 R 10\n" +
                "21 20 L 7\n" +
                "28 12 R 2\n" +
                "16 3 L 9\n" +
                "14 32 D 6\n" +
                "19 26 L 4\n" +
                "20 19 R 5\n" +
                "29 7 R 9\n" +
                "3 21 U 10\n" +
                "31 6 D 5\n" +
                "28 15 U 3\n" +
                "6 5 D 8\n" +
                "2 2 D 6\n" +
                "28 20 L 9\n" +
                "19 27 D 5\n" +
                "25 26 R 2\n" +
                "19 7 R 3\n" +
                "33 20 D 5\n" +
                "21 16 R 3\n" +
                "23 11 U 1\n" +
                "29 24 R 5\n" +
                "17 33 L 3\n" +
                "13 18 L 1\n" +
                "20 27 D 6\n" +
                "23 30 D 1\n" +
                "25 27 R 8\n" +
                "28 5 L 5\n" +
                "6 19 U 1\n" +
                "18 29 U 2\n" +
                "20 32 U 10\n" +
                "30 23 D 7\n" +
                "24 29 L 4\n" +
                "2 6 L 10\n" +
                "18 4 D 5\n" +
                "16 33 D 7\n" +
                "23 28 R 4\n" +
                "4 6 L 8\n" +
                "3 17 R 2\n" +
                "23 17 D 8\n" +
                "30 13 D 10\n" +
                "6 21 R 9\n" +
                "3 18 U 3\n" +
                "19 33 L 4\n" +
                "6 10 L 9\n" +
                "30 19 D 9\n" +
                "13 9 D 10\n" +
                "27 16 D 7\n" +
                "32 4 U 4\n" +
                "17 28 R 4\n" +
                "10 12 R 3\n" +
                "13 5 L 10\n" +
                "23 15 U 4\n" +
                "32 8 U 8\n" +
                "30 6 R 6\n" +
                "26 31 D 7\n" +
                "18 20 R 10\n" +
                "8 10 U 2\n" +
                "18 13 R 6\n" +
                "29 15 L 2\n" +
                "2 29 D 10\n" +
                "9 8 L 4\n" +
                "10 30 L 2\n" +
                "14 13 D 4\n" +
                "24 3 U 5\n" +
                "19 25 D 4\n" +
                "26 21 U 7\n" +
                "3 27 L 1\n" +
                "4 12 R 1\n" +
                "12 3 U 8\n" +
                "11 24 U 1\n" +
                "31 12 U 7\n" +
                "23 24 U 9\n" +
                "5 31 U 2\n" +
                "14 11 D 2\n" +
                "31 31 D 3\n" +
                "13 26 L 1\n" +
                "22 31 R 3\n" +
                "30 31 D 3\n" +
                "17 26 U 1\n" +
                "7 2 L 1\n" +
                "31 28 R 2\n" +
                "20 2 L 2\n" +
                "12 27 R 2\n" +
                "5 14 U 4\n" +
                "2 33 R 3\n" +
                "1 20 L 4\n" +
                "3 2 L 5\n" +
                "11 25 U 5\n" +
                "33 18 U 2\n" +
                "12 9 D 9\n" +
                "9 13 D 6\n" +
                "26 3 U 9\n" +
                "24 24 L 4\n" +
                "5 20 R 8\n" +
                "19 19 L 7\n" +
                "14 6 R 5\n" +
                "15 25 L 4\n" +
                "7 5 U 6\n" +
                "30 24 L 7\n" +
                "11 20 D 1\n" +
                "20 29 U 10\n" +
                "27 23 U 1\n" +
                "22 22 D 5\n" +
                "19 15 L 6\n" +
                "4 4 L 10\n" +
                "6 27 R 1\n" +
                "1 6 D 3\n" +
                "30 27 R 7\n" +
                "25 8 L 4\n" +
                "32 11 U 9\n" +
                "12 20 D 9\n" +
                "11 14 R 6\n" +
                "27 8 D 1\n" +
                "3 5 D 5\n" +
                "11 19 R 2\n" +
                "32 32 D 7\n" +
                "12 1 U 4\n" +
                "5 18 D 4\n" +
                "22 7 R 7\n" +
                "11 21 R 9\n" +
                "8 8 U 3\n" +
                "18 12 U 9\n" +
                "9 25 R 1\n" +
                "14 3 U 5\n" +
                "16 17 L 6\n" +
                "2 5 D 8\n" +
                "23 4 R 10\n" +
                "20 11 U 8\n" +
                "29 10 U 1\n" +
                "2 3 U 1\n" +
                "22 30 R 5\n" +
                "21 30 L 7\n" +
                "16 14 L 1\n" +
                "15 33 D 6\n" +
                "6 8 R 7\n" +
                "12 10 R 6\n" +
                "20 33 R 9\n" +
                "3 4 R 7\n" +
                "27 20 D 8\n" +
                "29 17 L 7\n" +
                "14 25 L 7\n" +
                "21 24 D 9\n" +
                "29 22 R 2\n" +
                "5 27 U 6\n" +
                "17 6 L 1\n" +
                "2 12 R 1\n" +
                "26 8 D 3\n" +
                "10 29 D 6\n" +
                "30 4 D 7\n" +
                "27 25 R 9\n" +
                "17 17 L 7\n" +
                "12 22 U 7\n" +
                "6 2 R 10\n" +
                "17 11 R 6\n" +
                "10 22 U 4\n" +
                "19 2 D 1\n" +
                "9 26 U 4\n" +
                "31 7 R 2\n" +
                "15 23 R 5\n" +
                "23 9 R 3\n" +
                "27 15 U 7\n" +
                "5 8 D 6\n" +
                "11 32 L 2\n" +
                "27 19 R 1\n" +
                "5 32 U 2\n" +
                "9 27 R 9\n" +
                "24 5 L 6\n" +
                "1 27 R 7\n" +
                "20 17 L 5\n" +
                "10 5 L 4\n" +
                "4 20 D 3\n" +
                "8 15 R 2\n" +
                "11 6 U 8\n" +
                "7 15 U 9\n" +
                "10 32 R 7\n" +
                "12 12 D 4\n" +
                "24 22 R 7\n" +
                "18 21 D 5\n" +
                "33 19 U 9\n" +
                "27 3 L 5\n" +
                "25 11 U 10\n" +
                "17 10 U 7\n" +
                "7 6 R 7\n" +
                "25 15 U 2\n" +
                "9 22 L 3\n" +
                "18 26 L 9\n" +
                "25 6 L 2\n" +
                "24 21 L 9\n" +
                "11 15 U 7\n" +
                "14 19 L 6\n" +
                "2 21 L 8\n" +
                "14 20 L 6\n" +
                "7 12 U 10\n" +
                "27 29 D 4\n" +
                "24 12 R 3\n" +
                "32 21 L 1\n" +
                "10 4 D 7\n" +
                "27 28 R 9\n" +
                "24 11 U 6\n" +
                "32 31 L 10\n" +
                "3 13 U 5\n" +
                "7 26 D 3\n" +
                "9 15 D 2\n" +
                "28 19 D 3\n" +
                "31 27 R 10\n" +
                "13 25 U 9\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem47.solution();
        Assertions.assertThat(solution).isEqualTo(343);
    }

}