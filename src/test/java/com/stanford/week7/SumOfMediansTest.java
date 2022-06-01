package com.stanford.week7;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfMediansTest {

    SumOfMedians sumOfMedians;

    @Test
    void testCaseOne() {
        sumOfMedians = new SumOfMedians();
        List<Integer> nums = Arrays.asList(1, 666, 10 , 667, 100, 2, 3);
        nums.stream().forEach((number) -> sumOfMedians.addNumber(number));
        assertEquals(142, sumOfMedians.sum % 10000);
    }

    @Test
    void testCaseTwo() {
        sumOfMedians = new SumOfMedians();
        List<Integer> nums = Arrays.asList(6331, 2793, 1640, 9290, 225, 625, 6195, 2303, 5685, 1354);
        nums.stream().forEach((number) -> sumOfMedians.addNumber(number));
        assertEquals(9335, sumOfMedians.sum % 10000);
    }

    @Test
    void testCaseThree() throws IOException {
        sumOfMedians = new SumOfMedians();
        String file = "/Users/saketh.nandagiri/Documents/Projects/Stanford/src/main/resources/median.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.lines().forEach((line) -> {
            int number = Integer.parseInt(line);
            sumOfMedians.addNumber(number);
        });

        assertEquals(1213, sumOfMedians.sum % 10000);
    }


}
