package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem172Test {
    @Test
    void solution() throws IOException {
        Problem172 problem172 = new Problem172();
        String p = "10\n" +
                "5\n" +
                "0 0 100 100 70 40 30 10 10 5 90 70 50 20\n" +
                "6\n" +
                "88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\n" +
                "7\n" +
                "22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\n" +
                "8\n" +
                "30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\n" +
                "9\n" +
                "3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\n" +
                "10\n" +
                "39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\n" +
                "10\n" +
                "26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\n" +
                "10\n" +
                "46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\n" +
                "10\n" +
                "94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\n" +
                "10\n" +
                "32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem172.solution();
    }
}