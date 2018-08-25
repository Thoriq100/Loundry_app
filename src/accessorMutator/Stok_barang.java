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
public class Stok_barang {
    private final StringProperty id_stok ;
    private final StringProperty nama_stok;
    private final StringProperty jumlah_stok;
    private final StringProperty satuan_stok;
    
    public Stok_barang(String id_stok,String nama_stok,String jumlah_stok,String satuan_stok){
        this.id_stok =new SimpleStringProperty(id_stok); 
        this.nama_stok = new SimpleStringProperty(nama_stok); 
        this.jumlah_stok = new SimpleStringProperty(jumlah_stok);
        this.satuan_stok = new SimpleStringProperty(satuan_stok); 
    }
    
    public String getId_stok (){
        return id_stok.get();
    }
    
    public void setId_stok(String Id_stok){
        id_stok.set(Id_stok);
    }
    
    public String getNama_stok(){
        return nama_stok.get();
    }
    
    public void setNama_stok(String Nama_stok){
        nama_stok.set(Nama_stok);
    }
    
    public String getJumlah(){
        return jumlah_stok.get();
    }
    public void setJumlah_stok(String Jumlah_stok){
        jumlah_stok.set(Jumlah_stok);
    }
    
    public String getSatuan_stok (){
        return satuan_stok.get();
    }
    
    public void setSatuan_stok (String Satuan_stok){
        satuan_stok.set(Satuan_stok);
    }
}
