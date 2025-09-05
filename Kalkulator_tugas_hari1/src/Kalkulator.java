import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------\n");
        System.out.println("Tugas hari 1 Kalkulator");
        System.out.println("Developed by Ananda Rauf Maududi");
        System.out.println("-------------------------------------\n");

        boolean ulang = true;

        while (ulang) {
            int angka1 = 0;
            int angka2 = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Masukkan angka pertama: ");
                if (input.hasNextInt()) {
                    angka1 = input.nextInt();
                    if (angka1 >= -1000 && angka1 <= 1000) {
                        validInput = true;
                    } else {
                        System.out.println("Angka harus antara -1000 dan 1000");
                    }
                } else {
                    System.out.println("Input harus berupa angka");
                    input.next();
                }
            }

            validInput = false;
            while (!validInput) {
                System.out.print("Masukkan angka kedua: ");
                if (input.hasNextInt()) {
                    angka2 = input.nextInt();
                    if (angka2 >= -1000 && angka2 <= 1000) {
                        validInput = true;
                    } else {
                        System.out.println("Angka harus antara -1000 dan 1000");
                    }
                } else {
                    System.out.println("Input harus berupa angka");
                    input.next();
                }
            }

            System.out.println("Pilih operasi:");
            System.out.println("1. Tambah");
            System.out.println("2. Kurang");
            System.out.println("3. Kali");
            System.out.println("4. Bagi");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = 0;
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
            } else {
                System.out.println("Pilihan tidak valid");
                input.next();
                continue;
            }

            int hasil = 0;
            boolean bisaHitung = true;

            if (pilihan == 1) {
                hasil = angka1 + angka2;
                System.out.println("Hasil: " + hasil);
            } else if (pilihan == 2) {
                hasil = angka1 - angka2;
                System.out.println("Hasil: " + hasil);
            } else if (pilihan == 3) {
                hasil = angka1 * angka2;
                System.out.println("Hasil: " + hasil);
            } else if (pilihan == 4) {
                if (angka2 == 0) {
                    System.out.println("Tidak dapat membagi dengan angka 0");
                    bisaHitung = false;
                } else {
                    double hasilBagi = (double) angka1 / angka2;
                    System.out.println("Hasil: " + hasilBagi);
                }
            } else {
                System.out.println("Pilihan tidak valid");
                continue;
            }

            System.out.print("Apakah ingin menghitung lagi? (Ya/Tidak): ");
            String jawab = input.next();

            if (!jawab.equalsIgnoreCase("Ya")) {
                ulang = false;
            }
        }

        System.out.println("Terima kasih telah menggunakan kalkulator ini ^-^0!");
        input.close();
    }
}
