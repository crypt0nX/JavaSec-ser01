import java.io.IOException;

public class Person implements java.io.Serializable {
    public String name;
    public int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(this.name + "是" + this.age + "岁");

    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        String msg = (String) s.readObject();
        System.out.println(msg);
    }
}
