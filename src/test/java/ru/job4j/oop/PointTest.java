package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class PointTest {

    @Test
    public void when46to83then5() {
        Point a = new Point(4, 6);
        Point b = new Point(8, 3);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5, 0.01));
    }

    @Test
    public void when77to49then3() {
        Point a = new Point(7, 7);
        Point b = new Point(4, 9);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(3.6, 0.01));
    }

    @Test
    public void when63to11then5() {
        Point a = new Point(6, 3);
        Point b = new Point(1, 1);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5.38, 0.01));
    }

    @Test
    public void when535to878then58() {
        Point a = new Point(5, 3, 5);
        Point b = new Point(8, 7, 8);
        assertThat(a.distance3d(b), closeTo(5.83, 0.01));
    }
}