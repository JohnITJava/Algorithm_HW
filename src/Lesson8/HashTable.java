package Lesson8;

import Lesson4.Cat;

public class HashTable {
    private Cat[] hashArr;
    private int arrSize;
    private Cat nullItem;

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArr = new Cat[arrSize];
        this.nullItem = new Cat(-1, "");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            sb.append((hashArr[i] != null) ? hashArr[i].getAge() : "*");
            if (i < arrSize - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    private int linearProbe(int hashVal) {
        ++hashVal;
        hashVal %= arrSize;
        return hashVal;
    }

    private int quadProbe(int hashVal, int count) {
        hashVal = count * count;
        hashVal %= arrSize;
        return hashVal;
    }

    private int doubleHash(int key) {
        return 19 - (key % 19);
    }

    private int dHashProbe(int hashVal, int key) {
        hashVal += doubleHash(key);
        hashVal %= arrSize;
        return hashVal;
    }

    public Cat find(int key) {
        int step = 1;
        int hashVal = hashFunc(key);
        Cat tempCur = hashArr[hashVal];
        while (tempCur != null) {
            if (tempCur.getAge() == key)
                return tempCur;
            tempCur = tempCur.getNext();
        }
        return null;
    }

    public void insert(Cat c) {
        int step = 1;
        int key = c.getAge();
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] != null && hashArr[hashVal] != nullItem) {
            Cat tempCur = hashArr[hashVal];
            while (tempCur.getNext() != null) {
                tempCur = tempCur.getNext();
            }
            tempCur.setNext(c);
            return;
        }
        hashArr[hashVal] = c;
    }

    public boolean delete(int key) {
        int step = 1;
        int hashVal = hashFunc(key);
        Cat tempCur = hashArr[hashVal];
        Cat prev = null;
        if (hashArr[hashVal].getNext() == null) {
            hashArr[hashVal] = nullItem;
            return true;
        } else {
            while (tempCur.getNext() != null) {
                if (tempCur.getAge() == key && prev == null) {
                    hashArr[hashVal] = tempCur.getNext();
                    return true;
                }
                if (tempCur.getNext().getAge() == key) {
                    tempCur.setNext(tempCur.getNext().getNext());
                    return true;
                }
                /*if (tempCur.getNext() == null && tempCur.getAge() == key){

                }*/
                prev = hashArr[hashVal];
                tempCur = tempCur.getNext();
            }
        }
        return false;
    }

}
