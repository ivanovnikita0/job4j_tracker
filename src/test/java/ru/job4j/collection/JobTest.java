package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByAscName() {
        Comparator<Job> cmpByAscName = new JobAscByName();
        int rsl = cmpByAscName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByDescName() {
        Comparator<Job> cmpByAscName = new JobDescByName();
        int rsl = cmpByAscName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByDescPriority() {
        Comparator<Job> cmpByAscName = new JobDescByPriority();
        int rsl = cmpByAscName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscPriority() {
        Comparator<Job> cmpByAscName = new JobAscByPriority();
        int rsl = cmpByAscName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscPriorityAndAscName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByDescPriorityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}