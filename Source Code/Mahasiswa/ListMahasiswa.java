import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class listMahasiswa {
    List<mahasiswa> mahasiswas = new ArrayList<>();
    
    public void tambah(mahasiswa... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, mahasiswa mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }
    
    public void asc(){
        this.mahasiswas.sort((mahasiswa d1, mahasiswa d2) -> d1.nim.compareTo(d2.nim));
    }
    
    public void desc(){
        this.mahasiswas.sort((mahasiswa d1, mahasiswa d2) -> d2.nim.compareTo(d1.nim));
    }

    
    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        listMahasiswa lm = new listMahasiswa();
        mahasiswa m = new mahasiswa("201234", "Noureen", "021xx1");
        mahasiswa m1 = new mahasiswa("201235", "Akhleena", "021xx2");
        mahasiswa m2 = new mahasiswa("201236", "Shannum", "021xx3");
            
        lm.tambah(m, m1, m2);
        lm.tampil();
        //lm.update(lm.linearSearch("201235"), new mahasiswa("201235",
        //        "Akhleena Lela", "021xx2"));
        mahasiswa key = new mahasiswa("201235", null, null);
        lm.update(Collections.binarySearch(lm.mahasiswas, key, new mhsComparator()),
                new mahasiswa("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();
        
        System.out.println("");
        System.out.println("Ascending: ");
        lm.asc();
        lm.tampil();
        
        System.out.println("");
        System.out.println("Descending: ");
        lm.desc();
        lm.tampil();
    }
}