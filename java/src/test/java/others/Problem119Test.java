package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem119Test {
    @Test
    void solution() throws IOException {
        Problem119 problem119 = new Problem119();
        String p = "4\n" +
                "3\n" +
                "...\n" +
                ".##\n" +
                ".##\n" +
                "4\n" +
                "#..#\n" +
                "....\n" +
                "....\n" +
                "#..#\n" +
                "5\n" +
                "#####\n" +
                "#####\n" +
                "#####\n" +
                "#####\n" +
                "#####\n" +
                "3\n" +
                ".#.\n" +
                "###\n" +
                ".#.";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem119.solution();
    }
}