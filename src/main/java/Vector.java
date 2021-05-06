public class Vector<T extends Object> {

    private static final int DEFAULT_SIZE = 16;
    private Object[] data;
    private int size = 0;

    public Vector() {
        this.data = new Object[DEFAULT_SIZE];

    }

    public Vector(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }

        this.data = new Object[capacity];
        this.size = 0;

    }

    public static <T> void copy(Vector<T> source, Vector<T> target) {

        target.clear();
        target.reserve(source.getSize());

        for (int i = 0; i < source.getSize(); i++) {
            target.add(source.get(i));
        }

    }

    private boolean indexCheck(int index) {
        return index >= 0 && index < data.length;
    }

    private T data(int index) {
        return (T) data[index];
    }

    public int getCapacity() {
        return this.data.length;
    }

    public int getSize() {
        return this.size;
    }

    public void add(T o) {
        if (this.size < this.data.length) {
            data[size] = o;
            size++;
        } else {
            int nsize = size * 2;
            Object[] temp = new Object[nsize];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            this.data = temp;
            this.add(o);
        }
    }

    public T get(int index) {
        if (indexCheck(index)) {
            return data(index);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean remove(T o) {

        T temp = null;
        int index = -1;

        if (o.equals(null)) {
            return true;
        }
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                index = i;
                temp = data(i);
                break;
            }
        }

        if (index >= 0) {
            for (int i = index; i < data.length; i++) {
                data[i] = data(i + 1);
            }
            return true;
        }


        return false;
    }

    public T remove(int index) {

        T oldValue = null;

        if (indexCheck(index)) {
            oldValue = data(index);
            data[index] = null;
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data(i + 1);
            }
            size = size - 1;
        }


        return oldValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

        fill(null); // all the elements after size are already null
        this.size = 0;
    }

    public void fill(T elem) {
        for (int i = 0; i < this.size; i++) {
            data[i] = elem;
        }
    }

    public void reserve(int newSize) {


        if (newSize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        } else if (newSize <= data.length) {
            return;
        }


        Object[] temp = new Object[newSize];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = data(i);
        }

        data = temp;

    }

    public void resize(int newSize) {

        if (newSize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        if (newSize < this.getSize()) {
            for (int i = newSize + 1; i < this.getSize(); i++) {
                data[i] = null;
            }
        } else if (newSize > this.getSize() && newSize > data.length) {
            this.reserve(newSize);
        }

        size = newSize;
    }

    public void insert(T elem, int index) {

        reserve(data.length +1);

        for (int i = getSize()-1;i >= index; i-- ){
            data[i+1] = data(i);
        }

        data[index] = elem;


    }

    public void trimToFit() {

        int nsize = getSize();

        if (nsize == data.length) {
            return;
        }

        Object[] temp = new Object[nsize];

        for (int i = 0; i < size; i++) {
            temp[i] = data(i);
        }

        data = temp;
    }

    /*
    reserve - capacity-t módosítja
    resize - size-t módosítja
    copy konstruktor
    insert(T elem, int index)
    getCapacity() - milyen nagy az array alatta
    (concatenate() - összefűzni két vektort)?
    trimToFit()


    TODO: splice
    TODO: iterator alapú konstruktor - két pozició közti étékeket másol ki



    */


}
