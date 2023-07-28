package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class
BOJ15649Test {
    OutputStream outputStream;

    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void solution() throws IOException {
        BOJ15649 boj15649 = new BOJ15649();
        String p = "4 4";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15649.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "1 2 3 4 \n" +
                "1 2 4 3 \n" +
                "1 3 2 4 \n" +
                "1 3 4 2 \n" +
                "1 4 2 3 \n" +
                "1 4 3 2 \n" +
                "2 1 3 4 \n" +
                "2 1 4 3 \n" +
                "2 3 1 4 \n" +
                "2 3 4 1 \n" +
                "2 4 1 3 \n" +
                "2 4 3 1 \n" +
                "3 1 2 4 \n" +
                "3 1 4 2 \n" +
                "3 2 1 4 \n" +
                "3 2 4 1 \n" +
                "3 4 1 2 \n" +
                "3 4 2 1 \n" +
                "4 1 2 3 \n" +
                "4 1 3 2 \n" +
                "4 2 1 3 \n" +
                "4 2 3 1 \n" +
                "4 3 1 2 \n" +
                "4 3 2 1");
    }

}