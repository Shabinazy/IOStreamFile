
package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        
        System.out.println("--- tulis nama hari dan baca kembali ---");
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"}; 
        
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) { 
            for (String h : hari) { 
                penulis.println(h); 
            }
            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) { 
            System.out.println("Gagal menulis: " + e.getMessage()); 
        }
        
        System.out.println("Isi file hari.txt saat ini:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) { 
            String baris; 
            while ((baris = pembaca.readLine()) != null) { 
                System.out.println(baris); 
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage()); 
        }
        
 
        System.out.println("\n--- tambah 2 hari ---");
        try (PrintWriter penulisAppend = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulisAppend.println("Sabtu");
            penulisAppend.println("Minggu");
            System.out.println("2 nama hari baru berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
        
        System.out.println("Isi file hari.txt yang baru:");
        try (BufferedReader pembacaAppend = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembacaAppend.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        
        
        System.out.println("\n--- hitung baris ----");
        int jumlah = 0; //
        try (BufferedReader pembacaHitung = new BufferedReader(new FileReader("hari.txt"))) { 
            while (pembacaHitung.readLine() != null) { 
                jumlah++; 
            }
            System.out.println("Jumlah baris di dalam hari.txt: " + jumlah); 
        } catch (IOException e) { 
            System.out.println("Gagal membaca: " + e.getMessage()); 
        }
        
    }
}