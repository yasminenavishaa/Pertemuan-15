import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class ContohList {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        //l.add("Cireng");
        System.out.printf("Elemen 0 : %d total elemen : %d elemen terakhir : %s\n", 
                l.get(0), l.size(), l.get(l.size() - 1));
        l.add(4);
        l.remove(0);
        System.out.printf("Elemen 0 : %d total elemen : %d elemen terakhir : %s\n", 
                l.get(0), l.size(), l.get(l.size() - 1));

        List<String> names = new LinkedList<>();
        names.add("Noureen");
        names.add("Akhleema");
        names.add("Shannum");
        names.add("Uwais");
        names.add("Al-Qarni");
        
        System.out.printf("Elemen 0 : %s total elemen : %s elemen terakhir : %s\n",
                names.get(0), names.size(),names.get(names.size() - 1));
        names.set(0, "My Kid");
        System.out.printf("Elemen 0 : %s total elemen : %s elemen terakhir : %s\n", 
                names.get(0), names.size(), names.get(names.size() - 1));
                //names.add("Mei-mei");
                //System.out.printf("Elemen 0 : %s total elemen : %s elemen terakhir : %s\n",
                //names.getFirst(), names.size(),names.getLast());
        System.out.println("Names : " + names.toString());
    }
}