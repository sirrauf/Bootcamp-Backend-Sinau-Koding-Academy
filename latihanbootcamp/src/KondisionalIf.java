public class KondisionalIf {
    public static void main(String[] args){
        int skor=75;
        if(skor>=80){
            System.out.println("Lulus dengan baik");

        }
        else if(skor>=60){
            System.out.println("Lulus.");

        }
        else {
            System.out.println("Tidak Lulus");
        }
        System.out.println(skor>=80 ? "Lulus dengan baik" : skor>=60 ? "Lulus." : "Tidak Lulus.");

    }
}
