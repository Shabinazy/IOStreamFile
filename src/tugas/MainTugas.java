// Nama : Firda Noor Shabina
// NPM : 2410010275

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        
        System.out.println("--- KATEGORI BARANG TOKO ---");
        String[] kategori = {"Elektronik", "Sembako", "Pakaian", "Alat Tulis"};
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("Kategori ke" + (i + 1) + ": " + kategori[i]);
        }
        System.out.println();

        System.out.println("--- GUDANG PERTAMA ---");
        Gudang gudangUtama = new Gudang("barang.txt");
        gudangUtama.tambahBarang(new Barang("Laptop Asus", 8500000, 5));
        gudangUtama.tambahBarang(new Barang("Mouse Logi", 150000, 15));
        gudangUtama.tambahBarang(new Barang("Beras 5kg", 75000, 20));
        gudangUtama.tambahBarang(new Barang("Kemeja Polos", 120000, 10));
        gudangUtama.tambahBarang(new Barang("Buku Tulis", 5000, 50));
        
        System.out.println("Daftar Barang awal di Gudang Utama:");
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        System.out.println();

        System.out.println("--- GUDANG BARU ----");
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        
        System.out.println("Daftar Barang yang Berhasil Dimuat dari Berkas:");
        gudangBaru.tampilkanSemua();
        
        System.out.println("Total Nilai Persediaan di Gudang: Rp" + gudangBaru.totalNilai());
    }
}