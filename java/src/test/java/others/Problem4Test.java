package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import others.Problem4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem4Test {


    @ParameterizedTest
    @MethodSource("init")
    void solution(String p, int ans) throws IOException {
        Problem4 problem4 = new Problem4();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem4.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    static Stream<Arguments> init(){
        return Stream.of(
                arguments("3 1\n" +
                        "1 0 0\n" +
                        "0 0 0\n" +
                        "0 0 1", 1),
                arguments("5 5\n" +
                        "0 0 0 0 0\n" +
                        "0 1 0 0 0\n" +
                        "0 0 1 0 1\n" +
                        "0 0 0 0 0\n" +
                        "0 0 0 1 0\n",3)
        );
    }
}