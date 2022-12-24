package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class Problem30Test {
    Problem30 problem30;
    OutputStream outputStream;

    @BeforeEach
    void init(){
        problem30 = new Problem30();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void solution() throws IOException {
        String p = "3 2\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem30.solution();

        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "1 1 \n" +
                "1 2 \n" +
                "1 3 \n" +
                "2 1 \n" +
                "2 2 \n" +
                "2 3 \n" +
                "3 1 \n" +
                "3 2 \n" +
                "3 3");
    }
}