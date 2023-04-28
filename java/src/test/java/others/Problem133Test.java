package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem133Test {
    @Test
    void solution() throws IOException {
        Problem133 problem133 = new Problem133();
        String p = "4\n" +
                "5\n" +
                "....o\n" +
                "...o.\n" +
                "..o..\n" +
                ".o...\n" +
                "o....\n" +
                "5\n" +
                "...o.\n" +
                "ooooo\n" +
                "...o.\n" +
                "...o.\n" +
                ".....\n" +
                "5\n" +
                ".o.oo\n" +
                "oo.oo\n" +
                ".oo..\n" +
                ".o...\n" +
                ".o...\n" +
                "5\n" +
                ".o.o.\n" +
                "o.o.o\n" +
                ".o.o.\n" +
                "o.o.o\n" +
                ".o.o.";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem133.solution();
    }
}