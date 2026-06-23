package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        
        System.out.println("--- Menampilkan Berkas ---");
        File berkasLaporan = new File("laporan.txt");
        if (berkasLaporan.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkasLaporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }
        
        System.out.println("\n--- Membuat Folder arsip ---");
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat atau sudah ada.");
        }
        
        System.out.println("\n--- Buat lalu Hapus berkas ---");
        File berkasSementara = new File("sementara.txt");
        try {
            berkasSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + berkasSementara.exists());
            berkasSementara.delete();
            System.out.println("Sesudah dihapus, ada? " + berkasSementara.exists());
        } catch (IOException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        }
        
    }
}    
