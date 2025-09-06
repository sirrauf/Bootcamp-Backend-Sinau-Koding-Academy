import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionSet {
    public static void main(String[]args){
        Set<String> listPeserta = new HashSet<>();
        listPeserta.add("Rauf");
        listPeserta.add("Dea");
        listPeserta.add("Fatah");
        List<String> listPeserta2 = new ArrayList<>();
        listPeserta.add("Ola");
        listPeserta.add("Dea");
        listPeserta.add("Adis");
        listPeserta.forEach(System.out::println);
        System.out.println();
        listPeserta2.forEach(System.out::println);
    }
}
