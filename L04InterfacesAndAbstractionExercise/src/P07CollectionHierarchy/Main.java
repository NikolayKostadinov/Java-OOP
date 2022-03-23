package P07CollectionHierarchy;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Addable addableCollection = new AddCollection();
        addableCollection = createCollection(input, addableCollection);
        AddRemovable addRemovableCollection = new AddRemoveCollection();
        addRemovableCollection = createCollection(input, addRemovableCollection);
        MyList myCollection = new MyListImpl();
        myCollection = createCollection(input, myCollection);

        int count = Integer.parseInt(scan.nextLine());
        removeRecords(addRemovableCollection, count);
        removeRecords(myCollection, count);


    }

    private static void removeRecords(AddRemovable myCollection, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(myCollection.remove());
            System.out.print(" ");
        }
        System.out.println();
    }

    private static <T extends Addable> T createCollection(String[] input, T collection)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = collection.getClass();
        T result = (T) clazz.getConstructor().newInstance();

        for (String element : input) {
            System.out.print(collection.add(element));
            System.out.print(" ");
        }

        System.out.println();
        return collection;
    }


}
