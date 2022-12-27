package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem39Test {

    Problem39 problem39;
    OutputStream outputStream;
    @BeforeEach
    void init(){
        problem39 = new Problem39();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void solution() throws IOException {
        String p = "4 5 2\n" +
                "1 2 0 1\n" +
                "3 1 1 2\n" +
                "2 1 2 0\n" +
                "2 0 0 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem39.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "0 -1 0 0 \n" +
                "0 0 0 2 \n" +
                "1 0 2 0 \n" +
                "2 0 0 0");
    }

}