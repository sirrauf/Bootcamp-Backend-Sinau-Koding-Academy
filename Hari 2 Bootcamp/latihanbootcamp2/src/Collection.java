import java.util.ArrayList;
import java.util.List;
public class Collection {
    public static void main(String[]args){
        List<String> listPeserta = new ArrayList<>();
        listPeserta.add("Rauf");
        listPeserta.add("Dea");
        listPeserta.add("Fatah");
        listPeserta.add("Dewi");
        System.out.println(listPeserta.getFirst());
        System.out.println(listPeserta.getLast());
        System.out.println(listPeserta.get(2));
        System.out.println("Total data:"+listPeserta.size());
    }
}
