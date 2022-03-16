import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.atomic.AtomicReference;
class hw1Test {

    private hw1 testHw =new hw1();
    @org.junit.jupiter.api.Test
    void DfindLast() {
        int[] x= new int[]{2, 3, 5};
        int y=2;
        assertEquals(0,testHw.findLast(x,y));
    }

    @org.junit.jupiter.api.Test
    void lastZero() {
        int[] x= new int[]{0, 1, 0};
        assertEquals(2,testHw.lastZero(x));
    }

    @org.junit.jupiter.api.Test
    void countPositive() {
        int[] x= new int[]{-4, 2, 0, 2};
        assertEquals(2,testHw.countPositive(x));
    }

    @org.junit.jupiter.api.Test
    void oddOrPos() {
        int[] x= new int[]{-3, -2, 0, 1, 4};
        assertEquals(3,testHw.oddOrPos(x));
    }
}