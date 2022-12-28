package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem45Test {
    OutputStream outputStream;
    Problem45 problem45;

    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        problem45 = new Problem45();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void solution() throws IOException {
        String p = "3\n" +
                "2 2\n" +
                "1 1 L\n" +
                "2 2 R\n" +
                "2 2\n" +
                "1 1 D\n" +
                "2 2 R\n" +
                "2 2\n" +
                "1 1 L\n" +
                "1 2 R\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem45.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("2\n" +
                "0\n" +
                "2");
    }

}