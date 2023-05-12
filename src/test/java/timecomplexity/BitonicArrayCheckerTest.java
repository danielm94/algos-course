package timecomplexity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static timecomplexity.BitonicArrayChecker.*;
class BitonicArrayCheckerTest {

    @Test
    void checkBitonicArray() {
        int[] arr = new int[]{1,2,3,4,5,4,3,2,1};
        assertTrue(isBitonic(arr));
    }

    @Test
    void checkNonBitonicArray() {
        int[]arr = new int[]{1,2,1,3,4,1,5,1,6,9,10,55,-5};
        assertFalse(isBitonic(arr));
    }

    @Test
    void checkIncreasingOnlyArray() {
        int[] arr = new int[]{1,2,3,4,5};
        assertFalse(isBitonic(arr));
    }
}