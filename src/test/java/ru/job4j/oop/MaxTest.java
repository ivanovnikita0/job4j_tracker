package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

    public class MaxTest {

        @Test
        public void whenMax1To2To3To4Then4() {
            Max max = new Max();
            int expected = 4;
            Assert.assertEquals(max.max(1, 2, 3, 4), expected);
        }

        @Test
        public void whenMax100To10To5To70Then100() {
            Max max = new Max();
            int expected = 100;
            Assert.assertEquals(max.max(100, 10, 5, 70), expected);
        }
    }