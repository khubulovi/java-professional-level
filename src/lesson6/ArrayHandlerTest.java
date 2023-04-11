package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTest {
    private final ArrayHandler arrayHandler = new ArrayHandler();

    @ParameterizedTest
    @MethodSource("dataForSuccessGettingValuesAfterLastFour")
    void getValueAfterLastFour(int [] originalArray, int[] expectedResultArray) {
        int[] actualResultArray = arrayHandler.getValueAfterLastFour(originalArray);

        Assertions.assertArrayEquals(expectedResultArray,actualResultArray);
    }

    private static Stream<Arguments> dataForSuccessGettingValuesAfterLastFour(){
        List <Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1,3,2,4,5,6,7},new int[]{5,6,7}));
            add(Arguments.arguments(new int[]{1,3,2,1,4,6,1,2},new int[] {6,1,2}));
            add(Arguments.arguments(new int[]{1,3,4,1,2,6,1,2},new int[] {1,2,6,1,2}));
            add(Arguments.arguments(new int[]{1,4,2,1,6,6,1,2},new int[] {2,1,6,6,1,2}));

        }};
        return arguments.stream();
    }

    @Test
    void getValuesAfterLastFourWaitException(){
        int[] originalArray = {1,2,3};
        Assertions.assertThrows(RuntimeException.class,() -> arrayHandler.getValueAfterLastFour(originalArray));
        int[] empty= {};
        Assertions.assertThrows(RuntimeException.class,() -> arrayHandler.getValueAfterLastFour(empty));
    }

    @ParameterizedTest
    @MethodSource("dataForFindFourOrOneNumberInArray")
    void findFourOrOneNumberInArray(int[] array,boolean expectedResult) {
        boolean actualResult = arrayHandler.findFourOrOneNumberInArray(array);
        Assertions.assertEquals(expectedResult,actualResult);
    }
    private static Stream<Arguments> dataForFindFourOrOneNumberInArray(){
        List <Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1,3,2,4,5,6,7},false));
            add(Arguments.arguments(new int[]{1,3,2,1,4,6,1,2},false));
            add(Arguments.arguments(new int[]{1,1,1,4,4,4,4},true));
            add(Arguments.arguments(new int[]{1,4,2,1,6,6,1,2},false));
        }};
        return arguments.stream();
    }
}