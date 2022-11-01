/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectutsfix;
import java.util.Scanner;
/**
 *
 * @author Najma Choirun Nisa
 */
public class ProjectUTSFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    float[] TotalDRel2, TotalDRel3, TotalDRel4;
    float DRel2=0;
    float DRel3=0;
    float DRel4=0;
    float Ramalan2=0;
    float Ramalan3=0;
    float Ramalan4=0;
    boolean ulang = true;
    while (ulang){
    //input periode poin 1
        System.out.println("Masukkan periode:");        
    int InputUser = scan.nextInt();
   
   
    //declare array sejumlah input (poin 2)
    int[] Sold = new int [InputUser];
    TotalDRel2 = new float [Sold.length-2];         
    TotalDRel3 = new float [Sold.length-3];  
    TotalDRel4 = new float [Sold.length-4];      
        //looping pertama, untuk input data (poin 3)
        for (int i = 0; i < InputUser; i++) {
        System.out.println("Masukkan data bulan ke - " + (i + 1));
    Sold [i]=scan.nextInt();
        }
        
        //looping kedua, untuk display hasil input data (poin 4)
        System.out.println("");
        for (int i = 0; i < InputUser; i++) {
            System.out.println("Data penjualan bulan ke - " + (i+1) + ": " + Sold[i]);                    
        }
        
        //poiin 5 orde 2
        System.out.println("");        
        System.out.println("Penghitungan orde 2");
        
        for (int i = 0; i < Sold.length; i++) {
            if (i >= 2) {
                Ramalan2 = (Sold[(i-2)] + Sold[(i-1)]) / 2;
                DRel2 = (Math.abs(Sold[(i)] - Ramalan2) * 100 / Sold[i]);
                TotalDRel2[i-2] += DRel2;
                System.out.println("Data Bulan Ke - " + (i+1) + " | Unit Terjual : " + Sold[(i)] + 
                        " | Hasil Peramalan : " + Ramalan2 + " | Hasil Relative Deviation : " + DRel2 + "%");
            }
        }
        for (int i = 0; i < Sold.length + 1; i++) {
            if (i>=(Sold.length)) {
                Ramalan2 = (Sold[(i-2)] + Sold[(i-1)]) / 2;
                System.out.println("Data Bulan ke - " + (i+1) + " | Hasil Peramalan : " + Ramalan2);                
            }
        }
        float sumDrel2 = 0;
        for (int i = 0; i < (Sold.length-2); i++) {
           sumDrel2 += TotalDRel2[i];
        }
        float avg2 = sumDrel2/(Sold.length-2);
        System.out.println("Total Relative Deviation untuk Orde 2 adalah : " + avg2 + "%");
        
        //orde 3
        System.out.println("");        
        System.out.println("Penghitungan orde 3");
        
        for (int i = 0; i < Sold.length; i++) {
            if (i >= 3) {
                Ramalan3 = (Sold[(i-3)] + Sold[(i-2)] + Sold[(i-1)]) / 3;
                DRel3 = (Math.abs(Sold[(i)] - Ramalan3) * 100 / Sold[i]);
                TotalDRel3[i-3] += DRel3;
                System.out.println("Data Bulan Ke - " + (i+1) + " | Unit Terjual : " + Sold[(i)] + 
                        " | Hasil Peramalan : " + Ramalan3 + " | Hasil Relative Deviation : " + DRel3 + "%");
            }
            
        }
        for (int i = 0; i < Sold.length + 1; i++) {
            if (i>=(Sold.length)) {
                Ramalan3 = (Sold[(i-3)] + Sold[(i-2)] + Sold[(i-1)]) / 3;
                System.out.println("Data Bulan ke - " + (i+1) + " | Hasil Peramalan : " + Ramalan3);                
            }
        }
         float sumDrel3 = 0;
        for (int i = 0; i < (Sold.length-3); i++) {
           sumDrel3 += TotalDRel3[i];
        }
        float avg3 = sumDrel3/(Sold.length-3);
        System.out.println("Total Relative Deviation untuk Orde 3 adalah : " + avg3 + "%");
        
        //orde 4
        System.out.println("");        
        System.out.println("Penghitungan orde 4");
        for (int i = 0; i < Sold.length; i++) {
            if (i >= 4) {
                Ramalan4 = (Sold[(i-4)] + Sold[(i-3)] + Sold[(i-2)] + Sold[(i-1)]) / 4;
                DRel4 = (Math.abs(Sold[(i)] - Ramalan4) * 100 / Sold[i]);
                TotalDRel4[i-4] += DRel4; 
                System.out.println("Data Bulan Ke - " + (i+1) + " | Unit Terjual : " + Sold[(i)] + 
                        " | Hasil Peramalan : " + Ramalan4 + " | Hasil Relative Deviation : " + DRel4 + "%");
            }
           
        }
         for (int i = 0; i < Sold.length + 1; i++) {
            if (i>=(Sold.length)) {
                Ramalan4 = (Sold[(i-4)] + Sold[(i-3)] + Sold[(i-2)] + Sold[(i-1)]) / 4;
                System.out.println("Data Bulan ke - " + (i+1) + " | Hasil Peramalan : " + Ramalan4);                
            }
        }
         float sumDrel4 = 0;
        for (int i = 0; i < (Sold.length-4); i++) {
           sumDrel4 += TotalDRel4[i];
        }
        float avg4 = sumDrel4/(Sold.length-4);
        System.out.println("Total Relative Deviation untuk Orde 4 adalah : " + avg4 + "%");
        
        //kesimpulan poin 7

        //declare var
        int orde = 0;
        float ComDRel = 0;
        int hasilRamal = 0;
        //perbandingan 3 avg ordo
        if (avg2 < avg3 && avg2 < avg4) {
        ComDRel += avg2;
        }else{
        if (avg3<avg4){
        ComDRel += avg3;
        }else{
        ComDRel += avg4;
        }
        }
        //menentukan orde yang di printout
        if (ComDRel == avg2) {
        orde = 2;   
        }else{
        if (ComDRel == avg3) {
        orde = 3;
        }else{
        orde = 4;
        }
        }
        //menentukan data ramalan yang di printout
        if (orde == 2) {
        hasilRamal += Ramalan2;
        }else{
        if (orde == 3){
        hasilRamal += Ramalan3;
        }else{    
        hasilRamal += Ramalan4;
        }
        }
        System.out.println("");        
        System.out.println("Karena Nilai Relative Deviation yang terkecil adalah yang "
                + "orde " + orde + " Bulan - Yaitu " + ComDRel + "%. Maka yang dipilih adalah data peramalan dengan orde " + orde + " bulan."
                + "\nDengan demikian pada bulan ke " + (Sold.length+1) + " dengan jumlah unit yang terjual diperkirakan sejumlah " + hasilRamal + " unit.");   
    

    //looping program
        System.out.println("");
        System.out.println("Apakah anda ingin menjalankan program kembali?");
        System.out.println("1.Tidak \n2.Ya");
        System.out.println("Masukkan angka saja");
        int endProg = scan.nextInt();
        if (endProg == 1){
            System.out.println("Terima kasih telah menggunakan program kami");            
            ulang = false;
        }
    }
    /*
    1. Ilham Takbir Al Azhiim (092)
    2. Lailaturahma Maulidah (096)
    3. Satrio Agna Gemintang (098)
    4. Najma Choirun Nisa (107)
    */
    }       
}

    
