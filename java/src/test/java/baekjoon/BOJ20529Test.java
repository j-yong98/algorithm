package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ20529Test {
    @Test
    void solution() throws IOException {
        BOJ20529 boj20529 = new BOJ20529();
        String p = "3\n" +
                "3\n" +
                "ENTJ INTP ESFJ\n" +
                "4\n" +
                "ESFP ESFP ESFP ESFP\n" +
                "5\n" +
                "INFP INFP ESTP ESTJ ISTJ";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj20529.solution();
    }
}