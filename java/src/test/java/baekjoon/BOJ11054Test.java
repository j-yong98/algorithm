package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BOJ11054Test {

    @Test
    void solution() throws IOException {
        BOJ11054 boj11054 = new BOJ11054();
        String p = "10\n" +
                "1 5 2 1 4 3 4 5 2 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj11054.solution();
    }

}