package tugas;

// Nama: Rasyid
// NPM: 2410010032

public class MainTugas {
    public static void main(String[] args) {
        //Array
        String[] kategori = {"Elektronik", "Makanan", "Pakaian", "Alat Tulis"};
        System.out.println("== Daftar Kategori ==");
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();
        
        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Mouse Wireless", 75000, 20));
        gudang.tambahBarang(new Barang("Keyboard Mekanik", 350000, 10));
        gudang.tambahBarang(new Barang("Indomie Goreng", 3500, 100));
        gudang.tambahBarang(new Barang("Kaos Polos", 45000, 30));
        gudang.tambahBarang(new Barang("Pulpen Standar", 2500, 200));

        gudang.tampilkanSemua();
        System.out.println("Total nilai persediaan: Rp" + gudang.totalNilai());
        gudang.simpanKeBerkas();

        System.out.println();
        
        //membuktikan data benar-benar tersimpan
        Gudang gudangLain = new Gudang("barang.txt");
        gudangLain.muatDariBerkas();
        gudangLain.tampilkanSemua();
        System.out.println("Jumlah barang: " + gudangLain.jumlahBarang());
        System.out.println("Total nilai persediaan (setelah dimuat ulang): Rp" + gudangLain.totalNilai());
    }
}