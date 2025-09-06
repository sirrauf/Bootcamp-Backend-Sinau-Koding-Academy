public class Person {
    private String nama;
    private String alamat;
    public String getNama(){return nama;}
    public void setNama(String nama){this.nama = nama;}
    public String getAlamat(){return alamat;}
    public void setAlamat(String alamat){this.alamat=alamat;}
    public String sayHello(String nama, String alamat){
        this.nama= nama;
        this.alamat= alamat;
        return "Hello"+this.nama+"-"+this.alamat;

    }
}
