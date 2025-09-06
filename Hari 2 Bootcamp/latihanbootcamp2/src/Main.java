//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setNama("Ananda Rauf Maududi");
        person.setAlamat("Bogor");

        System.out.println("Nama:"+person.getNama());
        System.out.println("Alamat:"+person.getAlamat());
        System.out.println(person.sayHello("Ananda Rauf Maududi", "Bogor"));

        Person rhaina = new Person();
        rhaina.setNama("Rhaina");
        rhaina.setAlamat("Jepang");

        Person ola = new Person();
        ola.setNama("Ola");
        ola.setAlamat("China");

        Person sabrina = new Person();
        sabrina.setNama("Sabrina");
        sabrina.setAlamat("Jakarta");
        List<Person> listPerson = List.of(rhaina,ola,sabrina);
        List<Person> listPerson2 = new ArrayList<>();
        listPerson2.add(rhaina);
        listPerson2.add(ola);
        listPerson2.add(sabrina);

        listPerson.forEach(person ->){
            System.out.println("Nama:"+ person)
        }
    }
}