import java.io.*;

public class example1 {
    public static void main(String[] args) throws IOException {
        Person myPerson = new Person("java", 111);
        serializePerson(myPerson);
        unSerializePerson("data.ser");
    }

    public static void serializePerson(Person cls) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("data.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(cls);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in data.ser");
    }

    public static void unSerializePerson(String filename) throws IOException {
        Person p = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}
