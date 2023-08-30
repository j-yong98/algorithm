package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ9202Test {
    @Test
    void solution() throws IOException {
        BOJ9202 boj9202 = new BOJ9202();
        String p = "5\n" +
                "ICPC\n" +
                "ACM\n" +
                "CONTEST\n" +
                "GCPC\n" +
                "PROGRAMM\n" +
                "\n" +
                "3\n" +
                "ACMA\n" +
                "APCA\n" +
                "TOGI\n" +
                "NEST\n" +
                "\n" +
                "PCMM\n" +
                "RXAI\n" +
                "ORCN\n" +
                "GPCG\n" +
                "\n" +
                "ICPC\n" +
                "GCPC\n" +
                "ICPC\n" +
                "GCPC";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj9202.solution();
    }
}