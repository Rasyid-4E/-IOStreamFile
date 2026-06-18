package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        //cek keberadaan & ukuran data.txt
        System.out.println("=== Soal 1 ===");
        File catatan = new File("catatan.txt");
        if (catatan.exists()) {
            System.out.println("Berkas catatan.txt ada, ukuran: " + catatan.length() + " byte");
        } else {
            System.out.println("Berkas data.txt tidak ditemukan.");
        }
        System.out.println();

        //Membuat folder baru bernama arsip
        System.out.println("=== Soal 2 ===");
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat (mungkin sudah ada sebelumnya).");
        }
        System.out.println();

        //Buat berkas sementara.txt lalu hapus kembali
        System.out.println("=== Soal 3 ===");
        File sementara = new File("sementara.txt");
        try {
            sementara.createNewFile();
            System.out.println("Sebelum dihapus, berkas ada? " + sementara.exists());
            sementara.delete();
            System.out.println("Sesudah dihapus, berkas ada? " + sementara.exists());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}