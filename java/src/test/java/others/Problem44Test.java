package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem44Test {
    OutputStream outputStream;
    Problem44 problem44;

    @BeforeEach
    void init(){
        problem44 = new Problem44();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void solution() throws IOException {
        Problem44 problem44 = new Problem44();
        String p = "4 2\n" +
                "15 13 1 11\n" +
                "4 8 3 5\n" +
                "2 12 16 7\n" +
                "14 6 9 10\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem44.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "13 4 1 9 \n" +
                "12 15 7 11 \n" +
                "14 2 5 16 \n" +
                "6 8 3 10");
    }

}