package Collection;

import Collection.Helper.Person;
import Collection.Helper.PersonComparator;

import java.util.*;

public class CollectionPersonMain {
    public static void main(String[] args) {
        PersonComparator personComparator = new PersonComparator();
        Set<Person> set = new TreeSet<>();
        Set<Person> set2 = new TreeSet<>(personComparator);

        System.out.println("Sorted by age: ");
        set.add(new Person("Богдан", "Довбуш", 24));
        set.add(new Person("Саша", "Иванов", 36));
        set.add(new Person("Маша", "Петрова", 23));
        set.add(new Person("Даша", "Сидорова", 34));
        set.add(new Person("Вася", "Иванов", 25));
        set.forEach(System.out::println);

        System.out.println();

        System.out.println("Sorted by lastname: ");
        set2.add(new Person("Богдан", "Добвуш", 24));
        set2.add(new Person("Саша", "Иванов", 36));
        set2.add(new Person("Маша", "Петрова", 23));
        set2.add(new Person("Даша", "Сидорова", 34));
        set2.add(new Person("Вася", "Иванов", 25));
        set2.forEach(System.out::println);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");

        System.out.println("Show arrayList: ");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            listIterator.set(element + "+");
        }
        System.out.println("Show changed arrayList: ");
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("Show revers changed arrayList: ");
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
