package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class Problem166Test {
    @Test
    void solution() throws Exception {
        Problem166 problem166 = new Problem166();
        String p = "3\n" +
                "7\n" +
                "love\n" +
                "10\n" +
                "food\n" +
                "281\n" +
                "tfbpqyuekmsonzgdlvjhcawxr";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem166.solution();
    }
}