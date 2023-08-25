package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ17413Test {
    @Test
    void solution() throws IOException {
        BOJ17413 boj17413 = new BOJ17413();
        String p = "<int><max>2147483647<long long><max>9223372036854775807";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj17413.solution();
    }
}