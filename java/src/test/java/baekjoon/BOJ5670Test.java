package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ5670Test {
    @Test
    void solution() throws IOException {
        BOJ5670 boj5670 = new BOJ5670();
        String p = "4\n" +
                "hello\n" +
                "hell\n" +
                "heaven\n" +
                "goodbye\n" +
                "3\n" +
                "hi\n" +
                "he\n" +
                "h\n" +
                "7\n" +
                "structure\n" +
                "structures\n" +
                "ride\n" +
                "riders\n" +
                "stress\n" +
                "solstice\n" +
                "ridiculous";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj5670.solution();
    }
}