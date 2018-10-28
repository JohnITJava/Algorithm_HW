package Lesson4;

public class Cat {
    protected int age;
    protected String name;

    public Cat getNext() {
        return next;
    }

    public void setNext(Cat next) {
        this.next = next;
    }

    private Cat next;

    public Cat() {
    }

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        if (age != cat.age) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public String toString() {
        return String.format("A: %d, N: %s", age, name);
    }
}
