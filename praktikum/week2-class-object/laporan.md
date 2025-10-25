# Laporan Praktikum Minggu 2 
Topik: Class dan Object (Produk Pertanian)

## Identitas
- Nama  : Radika Rismawati Tri Prasaja
- NIM   : 240202905
- Kelas : 3IKRB

---

## Tujuan
1. Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
2. Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
3. Mahasiswa mampu mengimplementasikan class Produk pertanian dengan atribut dan method yang sesuai.
4. Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di  console.
5. Mahasiswa mampu menyusun laporan praktikum dengan bukti kode, hasil eksekusi, dan analisis sederhana.

---

## Dasar Teori
Class adalah blueprint atau cetak biru dari sebuah objek. Objek merupakan instansiasi dari class yang berisi atribut (data) dan method (perilaku). Dalam OOP, enkapsulasi dilakukan dengan menyembunyikan data menggunakan access modifier (public, private, protected) serta menyediakan akses melalui getter dan setter.

Dalam konteks Agri-POS, produk pertanian seperti benih, pupuk, dan alat pertanian dapat direpresentasikan sebagai objek yang memiliki atribut nama, harga, dan stok. Dengan menggunakan class, setiap produk dapat dibuat, dikelola, dan dimanipulasi secara lebih terstruktur.

---

## Langkah Praktikum
1. Membuat Class Produk
   a. Buat file Produk.java pada package model.
   b. Tambahkan atribut: kode, nama, harga, dan stok.
   c. Gunakan enkapsulasi dengan menjadikan atribut   bersifat private dan membuat getter serta setter untuk masing-masing atribut.

2. Membuat Class CreditBy
   a. Buat file CreditBy.java pada package util.
   b. Isi class dengan method statis untuk menampilkan identitas mahasiswa di akhir output: credit by: <NIM> - <Nama>.

3. Membuat Objek Produk dan Menampilkan Credit
   a. Buat file MainProduk.java.
   b. Instansiasi minimal tiga objek produk, misalnya "Benih Padi", "Pupuk Urea", dan satu produk alat pertanian.
   c Tampilkan informasi produk melalui method getter.
   d. Panggil CreditBy.print("<NIM>", "<Nama>") di akhir main untuk menampilkan identitas.

4. Commit dan Push
   a. Commit dengan pesan: week2-class-object.

---

## Kode Program

1. Produk.java 
```
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}
```
2. CreditBy.java
```
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```
3. MainProduk.java
```
package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        p1.tambahStok(1000);
        p2.kurangiStok(25);
        p3.kurangiStok(10);

        System.out.println("\n===Update Stok===");
        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        // Tampilkan identitas mahasiswa
        CreditBy.print("<240202905>", "<Radika Rismawati Tri Prasaja>");
    }
}
```
---

## Hasil Eksekusi
1. ![Screenshot hasil](./screenshots/Hasil_Main_Produk.png)
---

## Analisis
1. Jelaskan bagaimana kode berjalan!
   **Jawab:** Program ini dibuat untuk menerapkan konsep dasar Object-Oriented Programming (OOP) yaitu class dan object dengan studi kasus produk pertanian. Program terdiri dari tiga file utama, yaitu Produk.java, CreditBy.java, dan MainProduk.java. Class Produk berfungsi sebagai blueprint atau cetak biru untuk membuat objek produk pertanian yang memiliki empat atribut: kode, nama, harga, dan stok. Atribut-atribut tersebut dibuat bersifat private agar tidak bisa diakses langsung dari luar class, sebagai bentuk penerapan enkapsulasi. Untuk mengakses dan memodifikasi nilai-nilai tersebut, disediakan method getter dan setter. Selain itu, class ini juga memiliki dua method tambahan, yaitu tambahStok() untuk menambah jumlah stok produk dan kurangiStok() untuk mengurangi stok dengan validasi agar tidak bisa berkurang melebihi stok yang tersedia.

    Class kedua, CreditBy.java, berisi method static print() yang berfungsi menampilkan identitas mahasiswa (NIM dan Nama) pada akhir hasil eksekusi. Sementara itu, class MainProduk.java berperan sebagai class utama yang berisi method main(). Di dalamnya dibuat tiga objek produk yaitu p1, p2, dan p3, masing-masing mewakili jenis produk pertanian seperti benih, pupuk, dan alat pertanian. Program pertama-tama menampilkan data setiap produk menggunakan method getter, lalu memperbarui stok dengan memanggil method tambahStok() dan kurangiStok(). Setelah pembaruan dilakukan, hasil perubahan stok ditampilkan kembali di konsol untuk menunjukkan hasil operasi. Terakhir, program menampilkan identitas pembuat kode melalui pemanggilan CreditBy.print(). Hasil output menunjukkan data produk sebelum dan sesudah pembaruan stok, sehingga mahasiswa dapat memahami bagaimana objek bekerja dalam penyimpanan dan manipulasi data produk.

2. Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya?
   **Jawab:** Pada praktikum minggu ke-2, program sudah menerapkan konsep Object-Oriented Programming (OOP) secara nyata dengan menggunakan beberapa class seperti Produk, CreditBy, dan MainProduk. Kelas Produk menyimpan atribut kode, nama, harga, dan stok secara private, lalu diakses melalui getter-setter untuk menjaga enkapsulasi. Objek-objek dibuat melalui konstruktor, dan terdapat method untuk menambah atau mengurangi stok. Kelas CreditBy menampilkan identitas mahasiswa, sedangkan MainProduk menjadi pusat eksekusi dengan membuat dan menampilkan data beberapa produk.

    Dibanding minggu pertama, pendekatan minggu ke-2 jauh lebih terstruktur dan berorientasi objek. Minggu 1 masih berfokus pada pengenalan tiga paradigma pemrograman — prosedural, OOP sederhana, dan fungsional — dengan contoh program singkat seperti “Hello World” tanpa class atau interaksi antarobjek. Minggu 2 sudah menggunakan multi-class, konstruktor, enkapsulasi, dan interaksi antarobjek dalam konteks sistem nyata (AgriPOS).

    Secara keseluruhan, minggu pertama menekankan konsep dasar dan perbedaan paradigma, sedangkan minggu kedua menekankan penerapan penuh prinsip OOP dalam program yang modular dan terorganisir.

3. Kendala yang dihadapi dan cara mengatasinya
    **Jawab:** Selama proses pembuatan program, terdapat beberapa kendala yang dihadapi. Salah satu kendala awal adalah kesalahan penulisan nama package dan lokasi file, sehingga program tidak dapat dijalankan karena sistem tidak menemukan class yang dimaksud. Masalah ini diselesaikan dengan memastikan setiap file Java diletakkan pada folder sesuai dengan deklarasi package di baris pertama, misalnya package com.upb.agripos.model; untuk class Produk.java. Kendala berikutnya adalah munculnya error “cannot find symbol” karena class CreditBy belum di-import ke file utama. Solusinya adalah menambahkan baris import com.upb.agripos.util.CreditBy; di awal kode.

    Selain itu, sempat terjadi kesalahan logika pada method kurangiStok() di mana stok bisa berkurang menjadi nilai negatif jika validasi belum ditambahkan. Untuk mengatasinya, ditambahkan kondisi if (this.stok >= jumlah) agar pengurangan hanya dilakukan bila stok mencukupi. Kendala minor lainnya adalah tampilan output yang kurang rapi dan membingungkan. Hal ini diperbaiki dengan menambahkan baris kosong (System.out.println();) dan teks penanda seperti “===Update Stok===” agar hasil eksekusi lebih mudah dibaca. Setelah semua perbaikan dilakukan, program dapat berjalan dengan baik dan menampilkan hasil sesuai dengan tujuan praktikum.

## Kesimpulan
Berdasarkan hasil praktikum minggu ke-2 dengan topik Class dan Object (Produk Pertanian), dapat disimpulkan bahwa konsep class dan object merupakan dasar utama dalam pemrograman berorientasi objek (OOP). Melalui class Produk, mahasiswa dapat memahami bagaimana mendefinisikan atribut dan method untuk merepresentasikan suatu entitas dunia nyata, dalam hal ini produk pertanian. Penerapan enkapsulasi melalui penggunaan access modifier private serta getter dan setter membantu menjaga keamanan data dan membatasi akses langsung dari luar class.

Selain itu, dengan membuat beberapa objek pada class MainProduk, mahasiswa dapat melihat bagaimana proses instansiasi bekerja dan bagaimana setiap objek memiliki data masing-masing. Adanya method tambahStok() dan kurangiStok() juga menunjukkan cara mengubah nilai atribut suatu objek secara dinamis menggunakan method. Program ini berhasil dijalankan dengan menampilkan data produk sebelum dan sesudah perubahan stok serta identitas pembuat program. Dengan demikian, praktikum ini memberikan pemahaman yang baik mengenai penerapan class, object, enkapsulasi, serta interaksi antar class dalam satu program Java yang terstruktur.
---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
**Jawaban:** Atribut sebaiknya dibuat private agar tidak bisa diakses atau diubah secara langsung dari luar class. Tujuannya adalah untuk melindungi data (data hiding) supaya nilai di dalam objek tetap konsisten dan tidak dimanipulasi sembarangan. Dengan cara ini, perubahan terhadap data hanya bisa dilakukan melalui method yang telah disediakan (getter dan setter), sehingga logika program tetap terkontrol dan aman.

2. Apa fungsi getter dan setter dalam enkapsulasi?
**Jawaban:** Getter dan setter berfungsi sebagai jembatan antara atribut private dan dunia luar class.
Getter digunakan untuk mengambil nilai dari atribut. Setter digunakan untuk mengubah nilai atribut dengan cara yang terkontrol (misalnya bisa ditambah validasi sebelum nilainya diubah).
Keduanya memastikan bahwa akses terhadap data tetap melalui mekanisme yang aman tanpa harus membuka atribut secara langsung.

3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
**Jawaban:** Class Produk menjadi pondasi dalam sistem POS (Point of Sale) karena sudah memiliki struktur data dan perilaku dasar produk. Dengan class ini, pengembang bisa dengan mudah menambahkan fitur lain seperti:
   a. perhitungan total harga transaksi,
   b. pengelolaan stok otomatis saat pembelian atau pengembalian,
   c. integrasi dengan database untuk menyimpan data produk,
   d. serta pembuatan laporan penjualan.

Struktur class Produk yang terenkapsulasi dan modular menjadikannya mudah diperluas (extendable) dan mudah diintegrasikan dengan fitur lain tanpa perlu mengubah kode dasarnya.
