package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class BOJ15650Test {
    OutputStream outputStream;
    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void solution() throws IOException {
        BOJ15650 boj15650 = new BOJ15650();
        String p = "4 2";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15650.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "1 2 \n" +
                        "1 3 \n" +
                        "1 4 \n" +
                        "2 3 \n" +
                        "2 4 \n" +
                        "3 4"
        );
    }

}