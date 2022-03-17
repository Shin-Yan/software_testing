import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){
        // TODO: return Stream
        return Stream.of(
                arguments(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}),
                arguments(new int[]{-3, -1, -5, -2}, new int[]{-5, -3, -2, -1}),
                arguments(new int[]{-99, 100, 2 ,0}, new int[]{-99, 0, 2, 100}),
                arguments(new int[]{3, 0}, new int[]{0, 3}),
                arguments(new int[]{0, 5, 3}, new int[] {0, 3, 5})
        );
    }

    @ParameterizedTest(name="#{index} - Test with argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        //TODO: random_array add to PriorityQueue
        while(index < random_array.length) {
            test.add(random_array[index]);
            index++;
        }
        //TODO: get PriorityQueue result
        for(int i=0;i<result.length;i++){
            result[i] = test.poll();
        }
        assertArrayEquals(correct_array,result);
    }
    @Test
    public void PriorityQueueAddExceptionTest() {
        PriorityQueue<Integer> test = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> test.add(null));
        assertEquals(null, exception.getMessage());
    }
    @Test
    public void PriorityQueueAddAllExceptionTest() {
        PriorityQueue<Integer> test = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> test.addAll(null));
        assertEquals(null, exception.getMessage());
    }
    @Test
    public void PriorityQueueOfferExceptionTest() {
        PriorityQueue<Integer> test = new PriorityQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> test.offer(null));
        assertEquals(null, exception.getMessage());
    }
}
