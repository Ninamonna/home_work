package task1;
/* Простая реализация структуры данных ArrayList
 использующая массив с типом <T> для хранения элементов.*/
public class MyArrayList<T> {

    private T[] array; // массив типа <T>
    private int size; // размер MyArrayList

    /* конструктор создает MyArrayList по умолчанию будет
    создан массив из 10-ти элементов типа <T>
    размером 0.
    */
    public MyArrayList() {

        this.array = (T[]) new Object[10];
        this.size = 0;
    }
    /* возвращает размер MyArrayList */
    public int size() {
        return size;
    }
    /* добавляет элемент в конец MyArrayList, когда массив заполняется
    *  происходит перезапись массива с новой длинной по формуле (length * 3)/ 2 + 1
    */
    public void add(T item) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[(this.array.length * 3)/ 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        array[size++] = item;
    }
    /* возвращает элемент по указанному индексу, если индекс выходит за пределы допустимого диапазона
    * выбрасывает IndexOutOfBoundsException */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    /* устанавливает элемент на определенную позицию */
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = item;
    }
    /* удаляет определенный элемент */
    public boolean removeByElement(T element) {
        int index = indexOf(element);
        if (index != -1) {
            removeByIndex(index);
            return true;
        }
        return false;
    }
    /* удаляет элемент по указанному индексу */
    public T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return removedElement;
    }
    /* возвращает индекс указанного элемента */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

}
