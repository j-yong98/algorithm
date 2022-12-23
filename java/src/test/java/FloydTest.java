import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FloydTest {

    @Test
    void floydTest(){
        Floyd floyd = new Floyd();
        int[][] arr = new int[][]{
                {1,2,2},
                {1,3,5},
                {1,4,1},
                {2,3,3},
                {2,4,2},
                {3,4,3},
                {3,5,1},
                {3,6,5},
                {4,5,1},
                {5,6,2}
        };
        int[][] res = floyd.floyd(6, arr);

        int[][] ans = {
                {0,2,3,1,2,4 },
                {2,0,3,2,3,5},
                {3,3,0,2,1,3},
                {1,2,2,0,1,3 },
                {2,3,1,1,0,2 },
                {4,5,3,3,2,0}};
        assertThat(res).isEqualTo(ans);
    }
}