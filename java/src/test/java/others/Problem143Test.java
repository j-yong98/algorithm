package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem143Test {
    @Test
    void solution() throws IOException {
        Problem143 problem143 = new Problem143();
        String p = "30\n" +
                "52 82\n" +
                "24 14\n" +
                "75 41\n" +
                "20 91\n" +
                "79 51\n" +
                "65 87\n" +
                "25 34\n" +
                "5 14\n" +
                "1 21\n" +
                "53 57\n" +
                "82 21\n" +
                "34 80\n" +
                "17 25\n" +
                "25 44\n" +
                "82 31\n" +
                "55 85\n" +
                "49 42\n" +
                "17 29\n" +
                "94 54\n" +
                "21 15\n" +
                "93 77\n" +
                "43 17\n" +
                "62 29\n" +
                "76 37\n" +
                "93 58\n" +
                "78 3\n" +
                "59 84\n" +
                "41 44\n" +
                "34 3\n" +
                "23 16\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem143.solution();
    }
}