package task1;

/* Простая реализация структуры данных ArrayList
 * использующая массив с типом <T> для хранения элементов.
 */
public class MyArrayList<T> {

    private Object[] array;
    private int size; // размер MyArrayList

    /* конструктор создает MyArrayList по умолчанию будет
     * создан массив из 10-ти элементов типа Object
     * размером 0.
     */
    public MyArrayList() {

        this.array = new Object[10];
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
            Object[] newArray = new Object[(array.length * 3) / 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        array[size++] = item;
    }

    /* возвращает элемент по указанному индексу, если индекс выходит за пределы допустимого диапазона
     * выбрасывает IndexOutOfBoundsException
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T)array[index];
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
        T removedElement = (T) array[index];
        if (size - (index + 1) >= 0)
            System.arraycopy(array, index + 1, array, index + 1 - 1, size - (index + 1));
            size--;
        return removedElement;
    }

    /* возвращает индекс указанного элемента */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if(array[i]==null && element == null) {
                return i;
            } else if (element != null && element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

}
