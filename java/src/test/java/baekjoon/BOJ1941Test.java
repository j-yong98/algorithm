package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ1941Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ1941 boj1941 = new BOJ1941();
        String pro = "YYYYS\n" +
                "YYYYY\n" +
                "YYYYS\n" +
                "YYYYY\n" +
                "YYSYS";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj1941.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }


    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("YYYYY\n" +
                        "SYSYS\n" +
                        "YYYYY\n" +
                        "YSYYS\n" +
                        "YYYYY", 2),
                arguments("SYSYY\n" +
                        "YYYYY\n" +
                        "YYSYY\n" +
                        "YYYYY\n" +
                        "YYSYY", 1),
                arguments("SYSYS\n" +
                        "YYYYY\n" +
                        "YYYYS\n" +
                        "YYYYY\n" +
                        "YYYYY", 1),
                arguments("SYSYS\n" +
                        "YYYYY\n" +
                        "YYYYS\n" +
                        "YYYYY\n" +
                        "YYYYY", 1),
                arguments("SYYYY\n" +
                        "YYYYY\n" +
                        "SYYYY\n" +
                        "YYYYY\n" +
                        "SYSYY", 1),
                arguments("YYYYS\n" +
                        "YYYYY\n" +
                        "YYYYS\n" +
                        "YYYYY\n" +
                        "YYSYS", 1),
                arguments("YYYYY\n" +
                        "YYYYY\n" +
                        "YYYYY\n" +
                        "YYYYY\n" +
                        "YYYYY", 0),
                arguments("SSSSS\n" +
                        "SSSSS\n" +
                        "SSSSS\n" +
                        "SSSSS\n" +
                        "SSSSS", 3546)
        );
    }
}