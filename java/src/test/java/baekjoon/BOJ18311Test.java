package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class BOJ18311Test {
    @Test
    void solution() {
        String p = "5 28\n" +
                "7 4 2 4 5";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
    }
}