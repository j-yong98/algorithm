package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem42Test {

    Problem42 problem42;
    OutputStream outputStream;
    @BeforeEach
    void init(){
        problem42 = new Problem42();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void solution() throws IOException {
        String p = "4 2\n" +
                "0 0 1 0\n" +
                "1 1 1 2\n" +
                "0 2 1 0\n" +
                "0 0 0 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem42.solution();

        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "-1 -1 2 -1 \n" +
                "2 1 1 0 \n" +
                "-1 0 1 -1 \n" +
                "-1 -1 -1 -2"
        );
    }

}