/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintReport;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JFrame;
import loundry_app.Koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Toriq
 */
public class PrintReport {
    Connection con = null;
    OraclePreparedStatement pst=null;
    OracleResultSet rs;  
    Statement stm =null; 
    JasperPrint jasperPrint;
    public void ShowReport() throws ClassNotFoundException{
        con = Koneksi.KoneksiBD();
         try{  
             String repot = "C:\\Users\\Toriq\\Documents\\NetBeansProjects\\Loundry_app\\src\\loundry_app\\ReportCustomer.jrxml";
             String jasper = "C:\\Users\\Toriq\\Documents\\NetBeansProjects\\Loundry_app\\src\\loundry_app\\ReportCustomer.jasper";
             InputStream inputx = null;   
             inputx = new FileInputStream(new File("C:\\Users\\Toriq\\Documents\\NetBeansProjects\\Loundry_app\\src\\loundry_app\\ReportCustomer.jrxml"));
             JasperDesign jasperDesign = JRXmlLoader.load(inputx);
             JRDesignQuery jrd = new JRDesignQuery();
             JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);            
             jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
             JasperViewer jv = new JasperViewer(jasperPrint);
           // jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           // jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception ex){
                
        }
    }
}
