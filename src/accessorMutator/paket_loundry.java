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
public class paket_loundry {
     private final StringProperty id_paket ;
    private final StringProperty nama_paket;
    private final StringProperty biaya_paket;
    public paket_loundry(String id_paket,String nama_paket,String biaya_paket){
        this.id_paket = new SimpleStringProperty(id_paket);
        this.nama_paket = new SimpleStringProperty(nama_paket);
        this.biaya_paket = new SimpleStringProperty(biaya_paket);
    }
    
    public String getId_paket (){
        return id_paket.get();
    }
    
    public void Set_idpaket(String Id_paket){
        id_paket.set(Id_paket);
    }
    
    public String getNama_paket(){
        return nama_paket.get();
    }
    public void setNama_paket(String Nama_paket){
        nama_paket.set(Nama_paket);
    }
    
    public String getBiaya_paket(){
        return biaya_paket.get();
    }
    
    public void setBiaya_paket(String Biaya_paket){
        biaya_paket.set(Biaya_paket);
    }
    
    
}
