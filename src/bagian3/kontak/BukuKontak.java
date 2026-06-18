package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    //ArrayList
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    //Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    //Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }

    //cari kontak berdasarkan nama
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equals(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return;
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }

    //menghapus kontak berdasarkan nama, lalu simpan ulang ke berkas
    public void hapusKontak(String nama) {
        Kontak ditemukan = null;
        for (Kontak k : daftar) {
            if (k.getNama().equals(nama)) {
                ditemukan = k;
                break;
            }
        }
        if (ditemukan != null) {
            daftar.remove(ditemukan);
            simpanKeBerkas();
            System.out.println("Kontak " + nama + " berhasil dihapus.");
        } else {
            System.out.println("Kontak " + nama + " tidak ditemukan, tidak ada yang dihapus.");
        }
    }
}