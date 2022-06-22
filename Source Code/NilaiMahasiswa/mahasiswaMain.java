import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mahasiswaMain {
    List<mahasiswa> mhs = new ArrayList<>();
    List<mataKuliah> mk = new ArrayList<>();
    List<nilai> nl = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Scanner s = new Scanner(System.in);
    
    public static void menu(){
        System.out.println("Pilih menu: ");
        System.out.println("1. Input Nilai");
        System.out.println("2. Tampil Nilai");
        System.out.println("3. Cari Nilai Mahasiswa");
        System.out.println("4. Urut Data Nilai");
        System.out.println("5. Keluar");
        System.out.println("==============");
    }
    
    public static void main(String[] args) {
        mahasiswaMain main = new mahasiswaMain();
        main.semester();
        int pilih;
        do{
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    main.pilih1();
                    break;
                    
                case 2:
                    main.pilih2();
                    break;
                    
                case 3:
                    main.pilih3();
                    break;
                  
                case 4:
                    main.pilih4();
                    break;
                    
                case 5:
                    System.exit(0);
            }
        }while(pilih >= 1 && pilih <= 5);
    }
    
    public void semester(){
        mhs.add(new mahasiswa("20001", "Thalhah", "021xxx"));
        mhs.add(new mahasiswa("20002", "Zubair", "021xxx"));
        mhs.add(new mahasiswa("20003", "Abdur-Rahman", "021xxx"));

        mk.add(new mataKuliah("00001", "Internet of Things", "3"));
        mk.add(new mataKuliah("00002", "Algoritma dan Struktur Data", "2"));
        mk.add(new mataKuliah("00003", "Algoritma dan Pemrograman", "2"));
    }
    
    public void pilih1(){
        System.out.println("Masukkan Data ");
        System.out.print("Kode	: ");
        String kode = sc.next();
        System.out.print("Nilai : ");
        float nilai = sc.nextFloat();
        System.out.println("");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("***********************************************");
        System.out.printf("%-15s	%-15s	%-14s\n", "NIM", "Nama", "Telfon");
        for (mahasiswa mahasiswa : mhs) {
            System.out.printf("%-15s	%-15s	%-14s\n", mahasiswa.nim, mahasiswa.nama, mahasiswa.noTelp);

        }
        boolean ditemukan = true;
        String pilihmahasiswa;
        int konfirmasi2 = 0;
        do {
            System.out.print("Pilih Mahasiswa by NIM : ");
            pilihmahasiswa = sc.next();
            for (mahasiswa mahasiswa : mhs) {
                if (pilihmahasiswa.equals(mahasiswa.nim)) {
                    ditemukan = false;
                    konfirmasi2++;
                }
            }
            if (konfirmasi2 == 0) {
                System.out.println("Data Kode NIM Tidak Ditemukan");
            }
        } while (ditemukan);
        System.out.println("");
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("***********************************************");
        System.out.printf("%-15s	%-40s	%-40s\n", "Kode", "Mata Kuliah", "SKS");
        for (mataKuliah matakuliah : mk) {
            System.out.printf("%-15s	%-40s	%-40s\n", matakuliah.kodeMat,
                    matakuliah.namaMat, matakuliah.sks);
        }
        boolean ditemukan2 = true;
        String pilihmatakuliah;
        int konfirmasi = 0;
        do {
            System.out.print("Pilih Mata Kuliah by Kode : ");
            pilihmatakuliah = sc.next();
            for (mataKuliah mklh : mk) {
                if (pilihmatakuliah.equals(mklh.kodeMat)) {
                    ditemukan2 = false;
                    konfirmasi++;

                }
            }
            if (konfirmasi == 0) {
                System.out.println("Data Kode Matakuliah Tidak Ditemukan");
            }
        } while (ditemukan2);
        nl.add(new nilai(kode, nilai, pilihmatakuliah, pilihmahasiswa));
    }
    
    public void pilih2() {
        System.out.println("NIM\tNama Mahasiswa\tMata Kuliah\t\t\tSKS\tNilai");
        nl.forEach(nilaisatuan -> {
            System.out.print(nilaisatuan.nimMhs + "\t");
            for (mahasiswa mahasiswa : mhs) {
                if (mahasiswa.nim.equals(nilaisatuan.nimMhs)) {
                    System.out.print(mahasiswa.nama + "\t\t");
                }
            }
            for (mataKuliah matkul : mk) {
                if (matkul.kodeMat.equals(nilaisatuan.kodeMatkul)) {
                    System.out.print(matkul.namaMat + "\t\t" + matkul.sks + "\t");
                }
            }
            System.out.println(nilaisatuan.nilai);
        });
    }
    
    public void pilih3(){
        pilih2();
        System.out.print("Masukkan Data Mahasiswa[nim] : ");
        String cariNIM = sc.next();
        int konfirmasi3 = 0;
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("***********************************************");
        System.out.println("NIM\t\tNama\t\tMata Kuliah\t\t\tSKS\tNilai");
        for (nilai carinilai : nl) {
            if (carinilai.nimMhs.equals(cariNIM)) {
                System.out.print(carinilai.nimMhs + "\t");
                for (mahasiswa mahasiswa : mhs) {
                    if (mahasiswa.nim.equals(carinilai.nimMhs)) {
                        System.out.print(mahasiswa.nama + "\t");
                    }
                }
                for (mataKuliah matkul : mk) {
                    if (matkul.kodeMat.equals(carinilai.kodeMatkul)) {
                        System.out.print(matkul.namaMat + "\t" + matkul.sks + "\t");
                    }
                }
                System.out.println(carinilai.nilai);
                konfirmasi3++;
            }

        }
        if (konfirmasi3 == 0) {
            System.out.println("Data Dengan NIM " + cariNIM + " Tidak Ditemukan");
        }
    }

    public void pilih4(){
        for (int i = 0; i < nl.size() - 1; i++) {
            for (int j = 0; j < nl.size() - i - 1; j++) {
                if (nl.get(j).nilai > nl.get(j + 1).nilai) {
                    float swap = nl.get(j).nilai;
                    nl.get(j).nilai = nl.get(j + 1).nilai;
                    nl.get(j + 1).nilai = swap;
                }
            }
        }
        pilih2();
    }
    }