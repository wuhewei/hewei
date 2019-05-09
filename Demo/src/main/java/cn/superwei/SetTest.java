package cn.superwei;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hewei
 * @date 2019/5/8
 */
public class SetTest {

    private static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            System.out.println("hashCode...");
            return this.age;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("equals...");
            return true;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("hewei", 22));
        set.add(new Person("hewei", 22));
        set.add(new Person("hewei", 22));

        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }
    }
}
