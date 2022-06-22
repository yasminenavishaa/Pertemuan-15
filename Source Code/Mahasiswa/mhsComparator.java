import java.util.Comparator;

public class mhsComparator implements Comparator<mahasiswa>  {
    public int compare(mahasiswa mhs1, mahasiswa mhs2) {
        if (mhs1.nim == mhs2.nim) {
            return 0;
        } else {

            return -1;
        }
    }

    public Comparator<mahasiswa> reversed() {
        return Comparator.super.reversed();
    }
}