package bagian3.kontak;

    public class Kontak {
        // Atribut: data yang dimiliki setiap Kontak
        private String nama;
        private String nomor;
        // Constructor: dipanggil saat objek dibuat
        public Kontak(String nama, String nomor) {
        this.nama = nama;
        this.nomor = nomor;
        }
        // Getter: cara membaca atribut dari luar class
        public String getNama() {
        return nama;
        }
        public String getNomor() {
        return nomor;
        }
        // Mengubah objek menjadi satu baris teks untuk disimpan ke berkas
        public String keBaris() {
        return nama + ";" + nomor;
        }
        // Mengembalikan keterangan Kontak dalam bentuk teks
        public String info() {
        return nama + " - " + nomor;
        }
       }