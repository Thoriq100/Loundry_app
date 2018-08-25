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
public class Transaksi {
    private final StringProperty id_transaksi;
    private final StringProperty id_admn;
    private final StringProperty id_cust;
    private final StringProperty id_pkt;
    private final StringProperty total_harga;
    private final StringProperty Berat_baju;
    private final StringProperty tgl_transaksi;
            
    public Transaksi(String id_transaksi,String id_admn,String id_cust,String id_pkt,String total_harga,String Berat_baju,String tgl_transaksi){
        this.id_transaksi = new SimpleStringProperty(id_transaksi);
        this.id_admn = new SimpleStringProperty(id_admn);
        this.id_cust = new SimpleStringProperty(id_cust);
        this.id_pkt = new SimpleStringProperty(id_pkt);
        this.total_harga = new SimpleStringProperty(total_harga);
        this.Berat_baju = new SimpleStringProperty(Berat_baju);
        this.tgl_transaksi = new SimpleStringProperty(tgl_transaksi);
    }
    public String getId_transaksi(){
        return id_transaksi.get();
    }
    public void setId_transaksi(String Id_transaksi){
        id_transaksi.set(Id_transaksi);
    }
    public String getId_admn(){
        return id_admn.get();
    }
    public void setId_admn(String Id_admn){
        id_admn.set(Id_admn);
    }
    public String getId_cust(){
        return id_cust.get();
    }
    public void setId_cust(String Id_cust){
        id_cust.set(Id_cust);
    }
    public String getId_pkt(){
        return id_pkt.get();
    }
    public void setId_pkt(String Id_pkt){
        id_pkt.set(Id_pkt);
    }
    public String getTotal_harga(){
        return total_harga.get();
    }
    public void setTotal_harga(String Total_harga){
        total_harga.set(Total_harga);
    }
    public String getBerat_baju(){
        return Berat_baju.get();
    }
    public void setBerat_baju(String berat_baju){
        Berat_baju.set(berat_baju);
    }
    
    public String getTgl_transaksi(){
        return tgl_transaksi.get();
    }
    public void setTgl_transaksi(String Tgl_transaksi){
        tgl_transaksi.set(Tgl_transaksi);
    }
    
}
