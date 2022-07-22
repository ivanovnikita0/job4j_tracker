package ru.job4j.function;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

public class FunctionCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCount function = new FunctionCount();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        FunctionCount function = new FunctionCount();
        List<Double> result = function.diapason(2, 5, x -> 3 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(13D, 28D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        FunctionCount function = new FunctionCount();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}