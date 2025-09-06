public class ExcepHandling {
    public static void main(String[]args){
        try{
            var hasil = 10/0;
            System.out.println("Hasil:"+hasil);

        } catch(ArithmeticException e){
            System.out.println("Error:"+ e.getMessage());
        }
    }
}
