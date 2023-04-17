package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem112Test {
    @Test
    void solution() throws IOException {
        Problem112 problem112 = new Problem112();
        String p = "3\n" +
                "......O.\n" +
                ".......O\n" +
                "...O....\n" +
                "O.......\n" +
                "....O...\n" +
                "..O.....\n" +
                ".O......\n" +
                ".....O..\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                "OOOOOOOO\n" +
                ".O.O.O.O\n" +
                "O.O.O.O.\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem112.solution();
    }
}