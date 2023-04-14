package task1;

/* Класс QuickSort предоставляет статический метод для выполнения
 * алгоритма quickSort используя MyArrayList.
 * Алгоритм сортирует элементы в порядке возрастания.
 */
public class QuickSort {

    /* Сортирует элементы в MyArrayList в порядке возрастания, используя quickSortAlgorithm.*/
    public <T extends Comparable<T>> void quickSort(MyArrayList<T> array) {
        quickSortAlgorithm(array, 0, array.size() - 1);
    }

    /* Рекурсивно разделяет MyArrayList и сортирует его элементы между левым и правым индексами.*/
    private <T extends Comparable<T>> void quickSortAlgorithm(MyArrayList<T> array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // находим опорный элемент
            quickSortAlgorithm(array, left, pivotIndex - 1);
            quickSortAlgorithm(array, pivotIndex + 1, right);
        }
    }

    /* разделяем массив на две части относительно опорного элемента
     * проходим циклом от левой до правой границы массива. Если элемент,
     * находящейся на текущей позиции, меньше опорного элемента
     * то меняем его местами с элементом на позиции i и увеличиваем переменную i на 1.
     */
    private <T extends Comparable<T>> int partition(MyArrayList<T> array, int left, int right) {
        T pivotValue = array.get(right); // опорный элемент со значением элемента массива справа
        int i = left; // позиция опорного элемента до сортировки

        for (int j = left; j < right; j++) {
            if (array.get(j).compareTo(pivotValue) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i; // позиция опорного элемента после сортировки
    }

    /* Меняет местами элементы в MyArrayList по заданным индексам. */
    private <T> void swap(MyArrayList<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}