package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Gudang masih kosong");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                Barang b = daftarBarang.get(i);
                System.out.println((i + 1) + ". " + b.info());
            }
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Sukses menyimpan data ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("gagal menyimpan berkas: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftarBarang.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]); 
                    int stok = Integer.parseInt(bagian[2]);      
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Sukses memuat data dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("gagal memuat berkas: " + e.getMessage());
        }
    }
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok(); 
        }
        return total;
    }
}