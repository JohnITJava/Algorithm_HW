package Lesson2;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    public Array(int size){
        isSorted = false;
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args){
        isSorted = false;
        this.size = args.length;
        this.arr = args;
    }

    public int length(){
        return size;
    }

    public int get(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int value, int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value){
        if (size >= arr.length){
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Deletes the last value in array
     */
    boolean delete(){
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index){ //by index
        if (index == size - 1) {size--;} else {
        System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        size--;
        }
        return true;
    }

    boolean deleteAll(int value){
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.arraycopy(arr, i + 1, arr, i, size - 1 - i);
                size--;
            }
        }

        return true;
    }

    void deleteAll(){ //clearAll /*Thank's for Dmitry:)
        size = 0;
    } // возможно еще один из способов, как-то установить null или записать в массив null - но это уже совем другая история

    /*
    * Search
    */

    public int find(int value){
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    /*
    * Sort
    * */
    private void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble(){
        int N = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                    N++;
            }
        }
        isSorted = true;
        System.out.println("Operations is: " + N);
    }

    public void sortBubbleUpd(){
        int N = 0;
        for (int i = 0; i < size; i++) {
            int f = 0;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(j, j + 1);
                    f = 1;
                }
                N++;
            }
            if (f == 0) {
                isSorted = true;
                System.out.println("Operations is: " + N);
                return;}
        }
        isSorted = true;
        System.out.println("Operations is: " + N);
    }

    public void sortSelect(){
        for (int flag = 0; flag < size; flag++) {
            int curMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[curMin]) curMin = rem;
            }
            swap(flag, curMin);
        }
        isSorted = true;
    }

    public void sortInsert(){
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    public boolean hasValue(int value) {
        if (!isSorted) throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) / 2; // (l+r) >> 1 - побитовый сдвиг
            if (value == arr[m]) {
                return true;
            } else if (value < arr[m]) {
                r = m;
            } else l = m + 1;
        }
        return false;
    }

}
