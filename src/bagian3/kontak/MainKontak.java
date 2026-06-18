package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        System.out.println();

        //Objek baru yang kosong,memuat dari berkas
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
        System.out.println();

        //cariKontak
        System.out.println("=== Uji cariKontak ===");
        bukuLain.cariKontak("Budi");
        bukuLain.cariKontak("Dewi");
        System.out.println();

        //hapusKontak
        System.out.println("=== Uji hapusKontak ===");
        bukuLain.hapusKontak("Budi");
        bukuLain.tampilkanSemua();
    }
}