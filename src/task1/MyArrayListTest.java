package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayListTest {

    @Test
    void testSize() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>();
        // when
        list.add(1);
        list.add(2);
        // then
        assertEquals(2, list.size());
    }

    @Test
    void testAdd() {
        // given
        MyArrayList<String> list = new MyArrayList<>();
        // when
        list.add("a");
        list.add("b");
        // then
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
    }

    @Test
    void testGet() {
        // given
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.0);
        list.add(2.0);
        // when
        Double result = list.get(1);
        // then
        assertEquals(2.0, result);
    }

    @Test
    void testGetOutOfBounds() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>();
        // when-then
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void testSet() {
        // given
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        // when
        list.set(1, "c");
        // then
        assertEquals("c", list.get(1));
    }

    @Test
    void testSetOutOfBounds() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>();
        // when-then
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 1));
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 3));
    }

    @Test
    public void testRemoveByElement() {
        // given
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        // when
        boolean removed = list.removeByElement(1.0);
        // then
        Assertions.assertTrue(removed);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(2.0, list.get(0));
        Assertions.assertEquals(3.0, list.get(1));
    }

    @Test
    public void testRemoveByElementElementNotFound() {
        // given
        MyArrayList<Character> list = new MyArrayList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        char elementToRemove = '4';
        // when
        boolean removed = list.removeByElement(elementToRemove);
        // then
        Assertions.assertFalse(removed);
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int elementIndexToRemove = 1;
        // when
        int removedElement = list.removeByIndex(elementIndexToRemove);
        // then
        Assertions.assertEquals(2, removedElement);
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(3, list.get(1));
    }

    @Test
    public void testRemoveByIndexIndexOutOfBounds() {
        // given
        MyArrayList<String> list = new MyArrayList<>();
        list.add("joke");
        list.add("feel");
        list.add("doc");
        int elementIndexToRemove = 3;
        // when & then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                list.removeByIndex(elementIndexToRemove));
    }

    @Test
    public void testIndexOf() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(13);
        list.add(42);
        list.add(31);
        int elementToFind = 31;
        // when
        int elementIndex = list.indexOf(elementToFind);
        // then
        Assertions.assertEquals(2, elementIndex);
    }

    @Test
    public void testIndexOfElementNotFound() {
        // given
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Yes");
        list.add("No");
        list.add("Ok");
        String elementToFind = "Hello";
        // when
        int elementIndex = list.indexOf(elementToFind);
        // then
        Assertions.assertEquals(-1, elementIndex);
    }
}

