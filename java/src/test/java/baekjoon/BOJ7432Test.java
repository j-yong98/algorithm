package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ7432Test {
    @Test
    void solution() throws IOException {
        BOJ7432 boj7432 = new BOJ7432();
        String p = "7\n" +
                "WINNT\\SYSTEM32\\CONFIG\n" +
                "GAMES\n" +
                "WINNT\\DRIVERS\n" +
                "HOME\n" +
                "WIN\\SOFT\n" +
                "GAMES\\DRIVERS\n" +
                "WINNT\\SYSTEM32\\CERTSRV\\CERTCO~1\\X86";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj7432.solution();
    }
}