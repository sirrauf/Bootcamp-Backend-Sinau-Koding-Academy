public class SwitchCase {
    public static void main(String[] args){
        int hari=3;
        switch(hari){
            case 1: System.out.println("Senin"); break;
            case 2: System.out.println("Selasa"); break;
            case 3: System.out.println("Rabu"); break;
            default: System.out.println("Hari tidak valid");

        }
        switch(hari){
            case 1 -> System.out.println("Senin");
            case 2 -> System.out.println("Selasa");
            case 3 -> {
                String namaHari="Rabu";
                System.out.println(namaHari);
            }
            default -> System.out.println("Hari tidak valid");
        }
    }
}
