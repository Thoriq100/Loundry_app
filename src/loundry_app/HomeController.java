/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loundry_app;

import PrintReport.PrintReport;
import accessorMutator.paket_loundry;
import accessorMutator.ViewTransaksiDone;
import accessorMutator.Stok_barang;
import accessorMutator.UserSession;
import accessorMutator.Transaksi;
import accessorMutator.Customerdata;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.text.View;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Toriq
 */
public class HomeController implements Initializable {
    Connection con = null;
    OraclePreparedStatement pst=null;
    OracleResultSet rs;  
    Statement stm =null; 
  
    @FXML
    private ProgressIndicator cust_prog;
    @FXML
    private ProgressIndicator total_uangindicator;
    @FXML
    private JFXTextField nama_tf1;
    
    @FXML
    private AnchorPane transaksi_detailpane;
    
    @FXML
    private JFXTextField alamat_tf1;
    @FXML
    private JFXTextField Cari1;

    @FXML
    private JFXTextField notlp_tf1;
    @FXML
    private JFXTextField id_update1;
    @FXML
    private JFXTextField input_tf1;

    @FXML
    private JFXHamburger humberger;
    @FXML
    private VBox box;
     @FXML
    private AnchorPane view_pane;
     @FXML
    private AnchorPane home_pane; 
     @FXML
    private AnchorPane stock_pane;
     @FXML
    private AnchorPane paket_adminpane;

    @FXML
    private AnchorPane paket_managerpane;

    @FXML
    private AnchorPane transaksi_pane;
    @FXML
    private JFXButton stock_btn1;
    @FXML
    private JFXButton home_btn1;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label usersession;
    @FXML
    private ImageView exit_btn;
    @FXML
    private ImageView edit_btn1;
    @FXML
    private TableView<Customerdata> tableCustomer;

    @FXML
    private TableColumn<Customerdata, String> id;

    @FXML
    private TableColumn<Customerdata, String> nama;

    @FXML
    private TableColumn<Customerdata, String> alamat;

    @FXML
    private TableColumn<Customerdata, String> notelfon;
    
     @FXML
    private TableView<Stok_barang> tableStok;

    @FXML
    private TableColumn<Stok_barang, String> id_stok;

    @FXML
    private TableColumn<Stok_barang, String> nama_stok;

    @FXML
    private TableColumn<Stok_barang, String> jumlah_stok;

    @FXML
    private TableColumn<Stok_barang, String> satuan_stok;
    @FXML
    private TableView<paket_loundry> tablepaketM;

    @FXML
    private TableColumn<paket_loundry, String> id_paketM;

    @FXML
    private TableColumn<paket_loundry, String> nama_paketM;

    @FXML
    private TableColumn<paket_loundry, String> biaya_paketM;
     @FXML
    private TableView<paket_loundry> tablepaketA;

    @FXML
    private TableColumn<paket_loundry, String> id_paketA;

    @FXML
    private TableColumn<paket_loundry, String> nama_paketA;

    @FXML
    private TableColumn<paket_loundry, String> biaya_paketA;
     @FXML
    private TableView<Transaksi> tabletransaksi;

    @FXML
    private TableColumn<Transaksi, String> id_tran;

    @FXML
    private TableColumn<Transaksi, String> id_adm;

    @FXML
    private TableColumn<Transaksi, String> id_custom;

    @FXML
    private TableColumn<Transaksi, String> id_pak;

    @FXML
    private TableColumn<Transaksi, String> total_har;

    @FXML
    private TableColumn<Transaksi, String> brt_baju;

    @FXML
    private TableColumn<Transaksi, String> tgl_transaksi;
    @FXML
    private TableView<Transaksi> tabletransaksidetail;

    @FXML
    private TableColumn<Transaksi, String> transaksi_column;

    @FXML
    private TableColumn<Transaksi, String> admin_column;

    @FXML
    private TableColumn<Transaksi, String> customer_column;

    @FXML
    private TableColumn<Transaksi, String> paket_column;

    @FXML
    private TableColumn<Transaksi, String> harga_column;

    @FXML
    private TableColumn<Transaksi, String> berat_column;

    @FXML
    private TableColumn<Transaksi, String> tgl_column;
       @FXML
    private TableView<ViewTransaksiDone> tableview;

    @FXML
    private TableColumn<ViewTransaksiDone , String> nama_view;

    @FXML
    private TableColumn<ViewTransaksiDone , String> total_view;

    @FXML
    private TableColumn<ViewTransaksiDone , String> berat_view;

    @FXML
    private TableColumn<ViewTransaksiDone , String> paket_view;

    @FXML
    private TableColumn<ViewTransaksiDone , String> admin_view;


    @FXML
    private TextField nama_tf;
    @FXML
    private ImageView delete;

    @FXML
    private TextField alamat_tf;

    @FXML
    private TextField notlp_tf;
    @FXML
    private TextField input_tf;
    @FXML
    private JFXTextField id_update_stok;

    @FXML
    private JFXTextField input_perubahanstok;
    
    @FXML
    private JFXTextField namastok_tf;

    @FXML
    private JFXTextField jumlahstok_tf;

    @FXML
    private JFXTextField satuanstok_tf;
    @FXML
    private ImageView rfsh_btn;
    @FXML
    private ImageView tamabah_stokbtn;
    @FXML
    private JFXTextField id_updatepaket;
    @FXML
    private JFXTextField admin_tran;

    @FXML
    private JFXTextField customer_tran;

    @FXML
    private JFXTextField paket_tran;

    @FXML
    private JFXTextField totalharga_tran;

    @FXML
    private JFXTextField beratbaju_tran;
    
    @FXML
    private ImageView tmbh_btn;
   
    @FXML
    private ComboBox<String> comboisi;
    @FXML
    private ComboBox<String> comboisi_stok;
    @FXML
    private ComboBox<String> combotransaksi;

    @FXML
    private JFXTextField update_idtransaksi;

    @FXML
    private JFXTextField input_perubahantran;
   
    
    @FXML
    private TextField id_update;
    @FXML
    private JFXButton view_btn1;
    @FXML
    private JFXButton paket_btn;
    
    @FXML
    private JFXButton transaksi_btn;
    @FXML
    private Label total_cust;
    @FXML
    private TextField coba;
    @FXML
    private JFXTextField id_deletepaket;
      
    @FXML
    private TextField coba1;
    @FXML
    private VBox vboxaddstok;
    @FXML
    private JFXTextField namapaket_tf;

    @FXML
    private JFXTextField biayapaket_tf;
    @FXML
    private ComboBox<String> comboPaket;
    @FXML
    private JFXTextField inputpaket_tf;
    
    @FXML
    private JFXTextField harganya;
    @FXML
    private Button tmbh_btn11;
    @FXML
    private JFXTextField idtrandetail;

    @FXML
    private TextField Cari;
    @FXML
    private JFXTextField idstokdetail;

    @FXML
    private JFXTextField stokterpakai;
      @FXML
    private ComboBox<String> combopaket1;
     ObservableList<String> combodata = FXCollections.observableArrayList();
     ObservableList<String> combostok = FXCollections.observableArrayList();
     ObservableList<String> combopaket = FXCollections.observableArrayList();
     ObservableList<String> option = FXCollections.observableArrayList();
     ObservableList<String> combo_transaksi = FXCollections.observableArrayList();
     ObservableList<ViewTransaksiDone> view = FXCollections.observableArrayList();
    
    String kolom ;
    String kolom_stok;
    String kolom_paket;
    String nama_kolom;
    String nama_kolom_stok;
    String nama_kolom_paket;
    String harga = null;
    String kolom_transaksi;
    String nama_kolom_transaksi;
    FilteredList filter = new FilteredList(view,e ->true);

    private double x=0 ,y=0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        cust_prog.setProgress(-5.50f);
        total_uangindicator.setProgress(-5.50f);
        loadCombo();
        loadCombostok();
        loadComboPaket();
        loadComboTran();
        //tampil ke table customer
          id.setCellValueFactory(new PropertyValueFactory<Customerdata, String>("id"));
          
          alamat.setCellValueFactory(new PropertyValueFactory<Customerdata, String>("Nama"));
          notelfon.setCellValueFactory(new PropertyValueFactory<Customerdata, String>("Alamat"));
          nama.setCellValueFactory(new PropertyValueFactory<Customerdata, String>("Tlp"));
          //tampil ke table stok
          id_stok.setCellValueFactory(new PropertyValueFactory<Stok_barang, String>("id_stok"));
          nama_stok.setCellValueFactory(new PropertyValueFactory<Stok_barang, String>("nama_stok"));
          jumlah_stok.setCellValueFactory(new PropertyValueFactory<Stok_barang, String>("Jumlah"));
          satuan_stok.setCellValueFactory(new PropertyValueFactory<Stok_barang, String>("satuan_stok"));
          //tampil ke paket Manager
          id_paketM.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("id_paket"));
          nama_paketM.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("nama_paket"));
          biaya_paketM.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("biaya_paket"));
          //tampil ke paket Admin
          id_paketA.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("id_paket"));
          nama_paketA.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("nama_paket"));
          biaya_paketA.setCellValueFactory(new PropertyValueFactory<paket_loundry, String>("biaya_paket"));
          //tampil ke transaksi
          id_tran.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_transaksi"));
          id_adm.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_admn"));
          id_custom.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_cust"));
          id_pak.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_pkt"));
          total_har.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("Total_harga"));
          brt_baju.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("berat_baju"));
          tgl_transaksi.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("tgl_transaksi"));
          //tampil ke transaksi _detail
            transaksi_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_transaksi"));
          admin_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_admn"));
          customer_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_cust"));
          paket_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("id_pkt"));
          harga_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("Total_harga"));
          berat_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("berat_baju"));
          tgl_column.setCellValueFactory(new PropertyValueFactory<Transaksi, String>("tgl_transaksi"));
         //tampil View 
          nama_view.setCellValueFactory(new PropertyValueFactory<ViewTransaksiDone, String>("Nama"));
          total_view.setCellValueFactory(new PropertyValueFactory<ViewTransaksiDone, String>("Totalhrg"));
          berat_view.setCellValueFactory(new PropertyValueFactory<ViewTransaksiDone, String>("Berat"));
          paket_view.setCellValueFactory(new PropertyValueFactory<ViewTransaksiDone, String>("Paket"));
          admin_view.setCellValueFactory(new PropertyValueFactory<ViewTransaksiDone, String>("Penanganan"));
        try {
            total();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            total_uang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            getView();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getTransaksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getCustomer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getStok();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getPaket();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //text pop up button fungsi pane_customer
        Tooltip btnView = new Tooltip();
        btnView.setText("Melihat dan Menambah Customer");
        view_btn1.setTooltip(btnView);
        
        Tooltip tfid = new Tooltip();
        tfid.setText("isi sesuai dengan id Customer ");
        id_update1.setTooltip(tfid);
        
        Tooltip tfrubah = new Tooltip();
        tfrubah.setText("berguna untuk inputan data baru");
        input_tf1.setTooltip(tfrubah);
        
        Tooltip plhkolom = new Tooltip();
        plhkolom.setText("pilih kolom yang mau di edit");
        comboisi.setTooltip(plhkolom);
          //text pop up button fungsi slide menu
        Tooltip stokbtn = new Tooltip();
        stokbtn.setText("Lihat isi Stock");
        stock_btn1.setTooltip(stokbtn);
        
         Tooltip paketbtn = new Tooltip();
        paketbtn.setText("Daftar Paket Loundry");
        paket_btn.setTooltip(paketbtn);
        
         Tooltip transaksitbtn = new Tooltip();
        transaksitbtn.setText("Daftar Transaksi Loundry");
        transaksi_btn.setTooltip(transaksitbtn);
        //text pop up button fungsi pane_stok_tambah
       Tooltip tambahstok = new Tooltip();
      tambahstok.setText("Field Untuk Penamaan Stok");
      namastok_tf.setTooltip(tambahstok);
      
       Tooltip fieldjumlah = new Tooltip();
      fieldjumlah.setText("Sesuikan Berapa Jumlah Stok");
      jumlahstok_tf.setTooltip(fieldjumlah);
      
       Tooltip fieldsatuan = new Tooltip();
      fieldsatuan.setText("Nama Satuan Dari Stok yang akan di tambah");
      satuanstok_tf.setTooltip(fieldsatuan); 
      
     //text pop up button fungsi pane_stok_edit
       Tooltip comboboxalert = new Tooltip();
       comboboxalert.setText("Pilih Kolom mana yang akan di rubah");
       comboisi_stok.setTooltip(comboboxalert);
       
       Tooltip fieldidstok = new Tooltip();
       fieldidstok.setText("Pilih ID Stok mana yang akan di rubah");
       id_update_stok.setTooltip(fieldidstok);
      
       Tooltip fieldinputperubahan = new Tooltip();
       fieldinputperubahan.setText("Inputkan data yang baru ");
       input_perubahanstok.setTooltip(fieldinputperubahan);
      
        
        // SlidePane Menu
        String user = UserSession.getUsername();
        usersession.setText(user);
        drawer.setSidePane(box);
         HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition (humberger);
        burgerTask2.setRate(-1);
        
        humberger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)-> {
            burgerTask2.setRate(burgerTask2.getRate() *-1);
            burgerTask2.play();
            if(drawer.isShown()){
                drawer.close();
            }else{
                drawer.open();
            };
            
        });
    }  
    
      @FXML
    void drag(MouseEvent event) {
        Node node = (Node)  event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void press(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }
    
    @FXML
    void close(MouseEvent event) {
         
        System.exit(0);
    }
    @FXML
    void logout(MouseEvent event) throws IOException {
              AnchorPane root10 = FXMLLoader.load(getClass().getResource("Login.fxml"));
                 Scene home_scane9 = new Scene (root10);
                 Stage app_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                 app_stage.setScene(home_scane9);
                 app_stage.show();
    }
    @FXML
    void handlebutton(ActionEvent event){
        String user = UserSession.getUsername();
        if(event.getSource()== home_btn1){
           home_pane.setVisible(true);
           view_pane.setVisible(false);
           stock_pane.setVisible(false);
           rfsh_btn.setVisible(true);
           tmbh_btn.setVisible(false);
           paket_managerpane.setVisible(false);
           paket_adminpane.setVisible(false);
           transaksi_pane.setVisible(false);
           delete.setVisible(false);
           edit_btn1.setVisible(false);
           transaksi_detailpane.setVisible(false);

        }
        if(event.getSource()== view_btn1){
                
                view_pane.setVisible(true);
                rfsh_btn.setVisible(true);
                tmbh_btn.setVisible(true);
                home_pane.setVisible(false);
                stock_pane.setVisible(false);
                edit_btn1.setVisible(true);
                paket_managerpane.setVisible(false);
                paket_adminpane.setVisible(false);
                transaksi_pane.setVisible(false);
                delete.setVisible(true);
                 transaksi_detailpane.setVisible(false);
                
            }
        if(event.getSource()==stock_btn1){
            
             stock_pane.setVisible(true);
            view_pane.setVisible(false);
            home_pane.setVisible(false);
            rfsh_btn.setVisible(true);
            tmbh_btn.setVisible(false);
             edit_btn1.setVisible(false);
             transaksi_pane.setVisible(false);
             paket_managerpane.setVisible(false);
                paket_adminpane.setVisible(false);
                delete.setVisible(false);
                 transaksi_detailpane.setVisible(false);
        }
       if(event.getSource()==paket_btn){
             if(user.equals("admin")){
                paket_adminpane.setVisible(true);
                paket_managerpane.setVisible(false);
                stock_pane.setVisible(false);
                view_pane.setVisible(false);
                home_pane.setVisible(false);
                transaksi_pane.setVisible(false);
                delete.setVisible(false);
                 transaksi_detailpane.setVisible(false);
              }else if(user.equals("manager")){
                paket_managerpane.setVisible(true);
                paket_adminpane.setVisible(false);
                stock_pane.setVisible(false);
                view_pane.setVisible(false);
                home_pane.setVisible(false);
                transaksi_pane.setVisible(false);
                delete.setVisible(false);
                 transaksi_detailpane.setVisible(false);
                    }
       }
       if(event.getSource()==transaksi_btn){
           transaksi_pane.setVisible(true);
           paket_managerpane.setVisible(false);
                paket_adminpane.setVisible(false);
                stock_pane.setVisible(false);
                view_pane.setVisible(false);
                home_pane.setVisible(false);
                delete.setVisible(false);
                 transaksi_detailpane.setVisible(false);
       }
    }
   @FXML
    void handleEdit(ActionEvent event){
        if(event.getSource()== tmbh_btn11){
            comboisi.setVisible(false);
            id_update1.setVisible(false);
            input_tf.setVisible(false);
        }
    }
    //FITURE VIEW
     @FXML
    void tambahbtn(MouseEvent event) throws ClassNotFoundException {
           
                try {
            con = Koneksi.KoneksiBD();
            String sql = "insert into Customer (id_cust,nama_cust,alamat_cust,no_tlp) values (id_customer_sequence.nextval,?,?,?)";
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
          
          
            pst.setString(1, nama_tf1.getText());
            pst.setString(2, alamat_tf1.getText());
            pst.setString(3, notlp_tf1.getText());
            rs = (OracleResultSet) pst.executeQuery();
            if(rs.next()){
                  Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Saved data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
               nama_tf1.setText("");
               alamat_tf1.setText("");
               notlp_tf1.setText("");
            }else{
               Image img = new Image("/icon/tick3.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
         Notifications notif = Notifications.create().title("Error").text(" No Saved data").hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
            }
        } catch (SQLException ex) {
          //    JOptionPane.showMessageDialog(null,""+ex);
        }
    
           
    }
    @FXML
    void refesh(MouseEvent event) throws ClassNotFoundException, SQLException {
           getCustomer();
           getStok();
           total();
           total_uang();
           getPaket();
           getTransaksi();
           getView();
    }
    
    
     public ObservableList<Customerdata> getCustomer() throws ClassNotFoundException, SQLException{
        int y=1;
        ObservableList<Customerdata> cust = FXCollections.observableArrayList();
      
     try{
         con = Koneksi.KoneksiBD();
     
         String sql = "select * from Customer";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
      
         while (rs.next()){
             
            cust.addAll(new Customerdata(
            rs.getString("id_cust"),
             rs.getString("nama_cust"),
             rs.getString("alamat_cust"),
             rs.getString("no_tlp")
           
            ));

          }
           
        tableCustomer.setItems(cust);
       
       
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,""+e);
         }
        return cust;
    }
     @FXML
    void edit_btn(MouseEvent event) throws ClassNotFoundException, SQLException {
        tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "update Customer set "+nama_kolom+" =' "+input_tf1.getText()+"' where id_cust ='"+id_update1.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
       if(rs.next()){
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Update data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
         id_update1.setText("");
         input_tf1.setText("");   
       }else{
           Image imge = new Image("/icon/error.png");
                  ImageView ive = new ImageView();
                  ive.setImage(imge);
      
                  Notifications notif = Notifications.create().title("Error").text("gagal Update").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(ive);
         notif.show();
       }
       
        
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
           
        }
        }
     @FXML
    void combo_update(ActionEvent event) {
        kolom = comboisi.getValue();
        if(kolom == "Nama"){
        nama_kolom ="nama_cust";
        }
        else if(kolom =="Alamat"){
            nama_kolom = "alamat_cust";
        }else if(kolom == "No Telfon"){
             nama_kolom = "no_tlp";
        }
        System.out.print(nama_kolom);
    }

   void loadCombo(){
       combodata.removeAll(combodata);
       String nama = "Nama";
       String alamat = "Alamat";
       String notlp = "No Telfon";
       combodata.addAll(nama,alamat,notlp);
       comboisi.getItems().addAll(combodata);
   }
        @FXML
    void combo_updatetransaksi(ActionEvent event) {
        kolom_transaksi = combotransaksi.getValue();
        if(kolom_transaksi == "ID ADMIN"){
        nama_kolom_transaksi ="id_admin";
        }
        else if(kolom_transaksi =="ID CUST"){
            nama_kolom_transaksi = "id_cust";
        }else if(kolom_transaksi == "ID PAKET"){
             nama_kolom_transaksi = "id_paket";
        }else if(kolom_transaksi == "TOTAL HARGA"){
            nama_kolom_transaksi = "total_harga";
        }else if (kolom_transaksi == "Berat Baju"){
            nama_kolom_transaksi = "berat_baju";
        }
        System.out.print(nama_kolom_transaksi);
    }
      void loadComboTran(){
       combo_transaksi.removeAll(combo_transaksi);
       String idadmin = "ID ADMIN";
       String idcust = "ID CUST";
       String idpaket = "ID PAKET";
       String total = "TOTAL HARGA";
       String berat_baju = "Berat Baju";
       
     
       combo_transaksi.addAll(idadmin,idcust,idpaket,total,berat_baju);
       combotransaksi.getItems().addAll(combo_transaksi);
   }
   
   @FXML
    void delete_btn(MouseEvent event) throws ClassNotFoundException, SQLException {
                tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "delete customer  where id_cust ='"+id_update1.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
       if(rs.next()){
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Delete data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
         id_update1.setText("");
    }else{
           
       }
        }catch(SQLException ex){
        }

    }
    //FITURE HOME
   void total() throws ClassNotFoundException, SQLException{
        con = Koneksi.KoneksiBD();
     
        try{
        String sql = "Select count(*) jml from customer";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
        
         while (rs.next()){
             String ttl = rs.getString("jml");
                coba.setText(ttl);
             
          }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
   }
   void total_uang() throws ClassNotFoundException, SQLException{
        con = Koneksi.KoneksiBD();
     
        try{
        String sql = "Select sum (total_harga) from transaksi";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
        
         while (rs.next()){
             String ttl = rs.getString("sum(total_harga)");
                coba1.setText(ttl);
             
          }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
   }
   
   
    //FITURE STOK
      @FXML
    void tambah_stok(MouseEvent event) throws ClassNotFoundException {
         try {
            con = Koneksi.KoneksiBD();
            String sql = "insert into stok_barang (id_stok,nama_stok,jumlah_stok,satuan_stok) values (id_stokseq.nextval,?,?,?)";
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
          
          
            pst.setString(1, namastok_tf.getText());
            pst.setString(2, jumlahstok_tf.getText());
            pst.setString(3, satuanstok_tf.getText());
            rs = (OracleResultSet) pst.executeQuery();
            if(rs.next()){
                  Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Saved data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
               namastok_tf.setText("");
               jumlahstok_tf.setText("");
               satuanstok_tf.setText("");
            }else{
               Image img = new Image("/icon/tick3.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
         Notifications notif = Notifications.create().title("Error").text(" No Saved data").hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
            }
        } catch (SQLException ex) {
          //    JOptionPane.showMessageDialog(null,""+ex);
        }
    
           
    }
    
     @FXML
    void edit_stokbtn(MouseEvent event) throws ClassNotFoundException {
         tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "update stok_barang set "+nama_kolom_stok+" =' "+input_perubahanstok.getText()+"' where id_stok ='"+id_update_stok.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
       if(rs.next()){
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Update data Stok").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
         id_update_stok.setText("");
         input_perubahanstok.setText("");   
       }else{
           Image imge = new Image("/icon/error.png");
                  ImageView ive = new ImageView();
                  ive.setImage(imge);
      
                  Notifications notif = Notifications.create().title("Error").text("gagal Update").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(ive);
         notif.show();
       }
       
        
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
           
        }
    }
     @FXML
    void combostok_update(ActionEvent event) {
        kolom_stok = comboisi_stok.getValue();
        if(kolom_stok == "Nama Stok"){
        nama_kolom_stok ="nama_stok";
        }
        else if(kolom_stok =="Jumlah Stok"){
            nama_kolom_stok = "jumlah_stok";
        }else if(kolom_stok == "Satuan Stok"){
             nama_kolom_stok = "satuan_stok";
        }
        System.out.print(nama_kolom_stok);
    }
    void loadCombostok(){
        combostok.remove(combostok);
       
       String nama_stok = "Nama Stok";
       String jumlah_stok = "Jumlah Stok";
       String satuan_stok = "Satuan Stok";
       combostok.addAll(nama_stok,jumlah_stok,satuan_stok);
       comboisi_stok.getItems().addAll(combostok);
   }
    
    @FXML
    void delete_stok(MouseEvent event) throws ClassNotFoundException {
        tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "delete stok_barang  where id_stok ='"+id_update_stok.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
      
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Delete data Stok").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
        id_update_stok.setText("");

           
       
        }catch(SQLException ex){
        }

    }
    public ObservableList<Stok_barang> getStok() throws ClassNotFoundException, SQLException{
         ObservableList<Stok_barang> stok = FXCollections.observableArrayList();
        try{
         con = Koneksi.KoneksiBD();
         
         String sql = "select * from stok_barang";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
      
         while (rs.next()){
             
            stok.addAll(new Stok_barang(
            rs.getString("id_stok"),
             rs.getString("nama_stok"),
             rs.getString("jumlah_stok"),
             rs.getString("satuan_stok")
           
            ));

          }
         tableStok.setItems(stok);
     

        }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null,""+ex);
        }
         return stok;
    }
    public ObservableList<ViewTransaksiDone> getView() throws ClassNotFoundException, SQLException{
         
        try{
         con = Koneksi.KoneksiBD();
         
         String sql = "select * from coba";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
      
         while (rs.next()){
             
            view.addAll(new ViewTransaksiDone(
            rs.getString("nama_customer"),
             rs.getString("total_harga"),
             rs.getString("berat_baju") ,
            rs.getString("nama_paket") ,
                    rs.getString("nama_admin") 
            ));
          }
         tableview.setItems(view);
        }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null,""+ex);
        }
         return view;
    }
    //paket
    public ObservableList<paket_loundry> getPaket() throws ClassNotFoundException, SQLException{
         ObservableList<paket_loundry> paket = FXCollections.observableArrayList();
        try{
         con = Koneksi.KoneksiBD();
         
         String sql = "select * from paket_barang";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
      
         while (rs.next()){
             
            paket.addAll(new paket_loundry(
            rs.getString("id_paket"),
             rs.getString("nama_paket"),
             rs.getString("biaya_paket")
           
            ));

          }
         tablepaketM.setItems(paket);
         tablepaketA.setItems(paket);
        }catch(SQLException ex){
                 JOptionPane.showMessageDialog(null,""+ex);
        }
         return paket;
    }

    @FXML
    void tambah_paket(MouseEvent event) throws ClassNotFoundException {
        try {
            con = Koneksi.KoneksiBD();
            String sql = "insert into paket_barang (id_paket,nama_paket,biaya_paket) values (id_paketseq.nextval,?,?)";
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
          
          
            pst.setString(1, namapaket_tf.getText());
            pst.setString(2, biayapaket_tf.getText());
            rs = (OracleResultSet) pst.executeQuery();
            if(rs.next()){
                  Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Saved data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
               namapaket_tf.setText("");
               biayapaket_tf.setText("");
            }else{
               Image img = new Image("/icon/tick3.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
         Notifications notif = Notifications.create().title("Error").text(" No Saved data").hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,""+ex);
        }
    
    }
      @FXML
    void edit_paket(MouseEvent event) throws ClassNotFoundException {
         tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "update paket_barang set "+nama_kolom_paket+" =' "+inputpaket_tf.getText()+"' where id_paket ='"+id_updatepaket.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
       if(rs.next()){
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Update data Stok").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
         id_updatepaket.setText("");
         inputpaket_tf.setText("");   
       }else{
           Image imge = new Image("/icon/error.png");
                  ImageView ive = new ImageView();
                  ive.setImage(imge);
      
                  Notifications notif = Notifications.create().title("Error").text("gagal Update").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(ive);
         notif.show();
       }
       
        
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
           
        }
    }
        @FXML
    void combo_paketupdate(ActionEvent event) {
        kolom_paket= comboPaket.getValue();
        if(kolom_paket == "Nama Paket"){
        nama_kolom_paket ="nama_paket";
        }
        else if(kolom_paket =="Biaya Paket"){
            nama_kolom_paket = "biaya_paket";
        }
        System.out.print(nama_kolom_paket);
    }
      void loadComboPaket(){
        combopaket.remove(combopaket);
       
       String nama_paket = "Nama Paket";
       String biaya_paket = "Biaya Paket";
       combopaket.addAll(nama_paket,biaya_paket);
       comboPaket.getItems().addAll(combopaket);
   }
  
       @FXML
    void delete_paket(MouseEvent event) throws ClassNotFoundException {
        tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "delete paket_barang  where id_paket ='"+id_deletepaket.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
      
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Delete data Stok").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
        id_deletepaket.setText("");

           
       
        }catch(SQLException ex){
        }
    }
    public ObservableList<Transaksi> getTransaksi() throws ClassNotFoundException, SQLException{
        int y=1;
        ObservableList<Transaksi> transaksi = FXCollections.observableArrayList();
      
     try{
         con = Koneksi.KoneksiBD();
     
         String sql = "select * from Transaksi order by id_transaksi";
          pst = (OraclePreparedStatement) con.prepareStatement(sql);
         rs = (OracleResultSet) pst.executeQuery();
        
      
         while (rs.next()){
             
            transaksi.addAll(new Transaksi(
             rs.getString("id_transaksi"),
             rs.getString("id_admin"),
             rs.getString("id_cust"),
             rs.getString("id_paket"),
             rs.getString("total_harga"),
             rs.getString("berat_baju"),      
             rs.getString("tgl_transaksi")
           
            ));

          }
           
        tabletransaksi.setItems(transaksi);
        tabletransaksidetail.setItems(transaksi);
       
       
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,""+e);
         }
        return transaksi;
    }
    @FXML
    void transaksi_detail(MouseEvent event) {
               transaksi_detailpane.setVisible(true);
               transaksi_pane.setVisible(false);
    }

   
    @FXML
    void tambah_transaksi(MouseEvent event) throws ClassNotFoundException {
        
         try {
            con = Koneksi.KoneksiBD();
            String sql = "insert into transaksi (id_transaksi,id_admin,id_cust,id_paket,total_harga,berat_baju,tgl_transaksi) values (id_transeq.nextval,?,?,?,?,?,sysdate)";
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
           
          
            pst.setString(1, admin_tran.getText());
            pst.setString(2, customer_tran.getText());
            pst.setString(3, paket_tran.getText());
            pst.setString(4, totalharga_tran.getText());
            pst.setString(5, beratbaju_tran.getText());
            rs = (OracleResultSet) pst.executeQuery();
            
            if(rs.next()){
                
                
                  Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Saved data").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();

            }else{
               Image img = new Image("/icon/tick3.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
         Notifications notif = Notifications.create().title("Error").text(" No Saved data").hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,""+ex);
        }
    
    }
    
    @FXML
    void hitungTotal(KeyEvent event) throws ClassNotFoundException, SQLException {
        con = Koneksi.KoneksiBD();
          String conve = beratbaju_tran.getText();

     int berat =Integer.parseInt(conve);
               String.valueOf(berat);
        int jumlah;
        
     
        String sql = "select * from paket_barang where id_paket = '"+paket_tran.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        
        while (rs.next()){
            harga = rs.getString("biaya_paket");
            harganya.setText(harga);
            int jum1 = Integer.parseInt(harga);
            String.valueOf(harga);
            totalharga_tran.setText(String.valueOf(berat * jum1));
        }

       
        
    }
   
    @FXML
    void donedetail(ActionEvent event) throws ClassNotFoundException {
            try {
            con = Koneksi.KoneksiBD();
            String sql = "insert into transaksi_detail (id_transaksi_detail,id_transaksi,id_stok,stok_terpakai) values (id_tran_detailseq.nextval,?,?,?)";
            pst = (OraclePreparedStatement) con.prepareStatement(sql);
           
          
            pst.setString(1, idtrandetail.getText());
            pst.setString(2, idstokdetail.getText());
            pst.setString(3, stokterpakai.getText());
     
            rs = (OracleResultSet) pst.executeQuery();
            
            if(rs.next()){
                
                
                  Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Transaksi Berhasil").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
                transaksi_detailpane.setVisible(false);
               transaksi_pane.setVisible(true);
            }else{
               Image img = new Image("/icon/tick3.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
         Notifications notif = Notifications.create().title("Error").text(" No Saved data").hideAfter(Duration.seconds(5))
                .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.out.print("Cliked");
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,""+ex);
        }
    }
    
    @FXML
    void update_transaksi1(MouseEvent event) throws ClassNotFoundException {
        tableCustomer.setEditable(true);
     
        try{
        con = Koneksi.KoneksiBD();
        
        
        String sql = "update transaksi set "+nama_kolom_transaksi+" =' "+input_perubahantran.getText()+"' where id_paket ='"+update_idtransaksi.getText()+"'";
        pst = (OraclePreparedStatement) con.prepareStatement(sql);
        pst.execute();
        rs = (OracleResultSet) pst.executeQuery();
       if(rs.next()){
           Image img = new Image("/icon/tick2.png");
                  ImageView iv = new ImageView();
                  iv.setImage(img);
      
                  Notifications notif = Notifications.create().title("Success").text("Update data Stok").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(iv);
         notif.show();
         update_idtransaksi.setText("");
         input_perubahantran.setText("");   
       }else{
           Image imge = new Image("/icon/error.png");
                  ImageView ive = new ImageView();
                  ive.setImage(imge);
      
                  Notifications notif = Notifications.create().title("Error").text("gagal Update").hideAfter(Duration.seconds(5))
                 .position(Pos.BASELINE_RIGHT).onAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              
            }
        });
         notif.darkStyle();
         notif.graphic(ive);
         notif.show();
       }
       
        
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
           
        }

    }
     @FXML
    void printer(ActionEvent event) throws JRException, ClassNotFoundException, SQLException {
       PrintReport pr = new PrintReport();
       pr.ShowReport();
    }
      
      @FXML
    void Seacrh1(KeyEvent event) {
         Cari1.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super ViewTransaksiDone>) (ViewTransaksiDone std)->{
            if (newValue.isEmpty()|| newValue==null){
                return true;
            }else if(std.getNama().contains(newValue)){
                return true;
            }
            return false;
            } );
        });
        SortedList sorted = new SortedList(filter);
        sorted.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sorted);
    }

    
}
