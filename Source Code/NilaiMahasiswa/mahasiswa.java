public class mahasiswa {
    String nim;
    String nama;
    String noTelp;
    
    public mahasiswa(){
        
    }
    
    public mahasiswa(String nim, String nama, String noTelp) {
        this.nim = nim;
        this.nama = nama;
        this.noTelp = noTelp;
    }

    public String toString() {
        return "Mahasiswa{" + "nim = " + nim + ",nama = " + nama + ", noTelp = " + noTelp + '}';
    }

}