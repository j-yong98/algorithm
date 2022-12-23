import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortingTest {

    @Test
    void topoloTest(){
        int[][] arr = {
                {3,8},
                {3,2},
                {5,2},
                {5,9},
                {4,6},
                {2,8},
                {2,1},
                {2,9},
                {1,8},
                {8,9},
                {9,7},
        };
        TopologicalSorting topologicalSorting = new TopologicalSorting();
        int[] topolo = topologicalSorting.topolo(9, arr);

        assertThat(topolo).isEqualTo(new int[]{3, 4, 5, 6, 2, 1, 8, 9, 7});
    }

}