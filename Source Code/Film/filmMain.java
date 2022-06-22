import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;

public class filmMain {
    public static void menu(){
        System.out.println("Pilih menu: ");
        System.out.println("1. Input Data Film");
        System.out.println("2. Hapus Data Film Teratas");
        System.out.println("3. Cek Data Film Teratas");
        System.out.println("4. Info Semua Film");
        System.out.println("5. Keluar");
        System.out.println("==============");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        
        
        Stack<film> films = new Stack<>();
        
        int pilih;
        
        do{
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Judul: ");
                    String judul = s.nextLine();
                    System.out.print("Tahun: ");
                    int tahun = sc.nextInt();
                    System.out.print("Director: ");
                    String direct = s.nextLine();
                    film f = new film();
                    films.push(f = new film(id, judul, tahun, direct));
                    System.out.println("");
                    break;
                    
                case 2:
                    films.pop();
                    System.out.println("");
                    break;
                    
                case 3:
                    if(films.empty()){
                        System.out.println("Stack kosong");
                    } else {
                        System.out.print("Film{" + "ID: " + films.peek().id + ", Judul: " +films.peek().judul +
                                ", Tahun: " + films.peek().tahun +", Director: " + films.peek().director +"}");
                    }
                    break;
                    
                case 4: 
                    if(films.empty()){
                        System.out.println("Stack kosong");
                    } else {
                         films.stream().forEach(b -> {
                            System.out.println("Film{" + "ID:" + b.id + ", Judul:" + b.judul
                            + ", Tahun:" + b.tahun + ", Director:" + b.director + '}');
                         });
                    }
                    break;
                    
                case 5:
                    System.exit(0);
            }
        }while(pilih >= 1 && pilih <= 5);
    }
}