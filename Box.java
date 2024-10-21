package generic.animal;

public class Box<T> {
    private T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    /*
    Animal을 넣을경우,

    public class Box<Animal> {
    private Animal value;

    public Animal get() {
        return value;
    }

    public void set(Animal value) {
        this.value = value;
    }
     */
}
