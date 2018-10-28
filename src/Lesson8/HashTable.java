package Lesson8;

import Lesson4.Cat;

public class HashTable {
    private Cat[] hashArr;
    private int arrSize;
    private Cat nullItem;

    public HashTable(int arrSize){
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

    private int hashFunc(int key){
        return key % arrSize;
    }

    private int linearProbe(int hashVal){
        ++hashVal;
        hashVal %= arrSize;
        return hashVal;
    }

    private int quadProbe(int hashVal, int count){
        hashVal = count * count;
        hashVal %= arrSize;
        return hashVal;
    }

    private int doubleHash(int key){
        return 19 - (key % 19);
    }

    private int dHashProbe(int hashVal, int key){
        hashVal += doubleHash(key);
        hashVal %= arrSize;
        return hashVal;
    }

    public Cat find(int key){
        int step = 1;
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null){
            if (hashArr[hashVal].getAge() == key)
                return hashArr[hashVal];
            //step++;
            //hashVal = linearProbe(hashVal);
            //hashVal = quadProbe(hashVal, step);
            hashVal = dHashProbe(hashVal, key);
        }
        return null;
    }

    public void insert(Cat c){
        int step = 1;
        int key = c.getAge();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal] != nullItem){
            hashVal = dHashProbe(hashVal, key);
//            step++;
//            hashVal = quadProbe(hashVal, step);
            //hashVal = linearProbe(hashVal);
        }
        hashArr[hashVal] = c;
    }

    public Cat delete(int key){
        int step = 1;
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getAge() == key) {
                Cat temp = hashArr[hashVal];
                hashArr[hashVal] = nullItem;
                return temp;
            }
            //step++;
            hashVal = dHashProbe(hashVal, key);
           // hashVal = quadProbe(hashVal, step);
            //hashVal = linearProbe(hashVal);
        }
            return null;
    }



}
