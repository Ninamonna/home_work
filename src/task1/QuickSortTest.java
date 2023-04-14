package task1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    private QuickSort quickSort;

    @BeforeEach
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testQuickSort() {
        // given
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(6);
        array.add(2);
        array.add(8);
        array.add(4);
        array.add(1);
        array.add(9);
        array.add(7);
        array.add(3);
        array.add(5);
        // when
        quickSort.quickSort(array);
        // then
        for (int i = 0; i < array.size() - 1; i++) {
            Assertions.assertTrue(array.get(i) <= array.get(i + 1));
        }
    }

    @Test
    public void testQuickSortWithDuplicates() {
        // given
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(6);
        array.add(2);
        array.add(8);
        array.add(4);
        array.add(1);
        array.add(9);
        array.add(7);
        array.add(3);
        array.add(5);
        array.add(4);
        // when
        quickSort.quickSort(array);
        // then
        for (int i = 0; i < array.size() - 1; i++) {
            Assertions.assertTrue(array.get(i) <= array.get(i + 1));
        }
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        // given
        MyArrayList<Integer> array = new MyArrayList<>();
        // when
        quickSort.quickSort(array);
        // then
        Assertions.assertEquals(0, array.size());
    }

}