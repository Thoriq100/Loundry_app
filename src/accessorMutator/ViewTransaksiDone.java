/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessorMutator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Toriq
 */
public class ViewTransaksiDone {
        private final StringProperty nama ;
    private final StringProperty totalhrg;
    private final StringProperty berat;
    private final StringProperty paket;
    private final StringProperty penanganan;
            public ViewTransaksiDone(String nama,String totalhrg,String berat,String paket,String penanganan){
                this.nama = new SimpleStringProperty(nama);
                this.totalhrg = new SimpleStringProperty(totalhrg);
                this.berat = new SimpleStringProperty(berat);
                this.paket = new SimpleStringProperty(paket);
                this.penanganan = new SimpleStringProperty(penanganan); 
            }
     public String getNama(){
         return nama.get();
     }
     public void setNama(String Nama){
         nama.set(Nama);
     }
     
     public String getTotalhrg(){
         return totalhrg.get();
     }
     public void setTotalhrg(String Totalhrg){
         totalhrg.setValue(Totalhrg);
     }
     public String getBerat(){
         return berat.get();
     }
     public void setBerat(String Berat){
         berat.setValue(Berat);
     }
     public String getPaket(){
         return paket.get();
     }
     
     public void setPaket(String Paket){
         paket.setValue(Paket);
     }
     public String getPenanganan(){
         return penanganan.get();
     }
     
     public void setPenanganan(String Penanganan){
         penanganan.setValue(Penanganan);
     }
}
