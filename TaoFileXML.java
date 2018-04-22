/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author namph
 */
public class TaoFileXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            NhanVien nv1 = new NhanVien("NV01", "Van Anh", "1000", "Hanh Chinh", "09883434");
            NhanVien nv2 = new NhanVien("NV02", "Lan Anh", "1200", "Nhan Su", "09883567");
            
            Element CongTy = doc.createElement("congty");
            themNhanVien(doc, CongTy, nv1);
            themNhanVien(doc, CongTy, nv2);
            
            doc.appendChild(CongTy);
            
            TransformerFactory tff = TransformerFactory.newInstance();
            try {
                Transformer tf = tff.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("src/XML/congty.xml");
                tf.transform(source, result);
                System.out.println("Ghi file thanh cong!!!");
                
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(TaoFileXML.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(TaoFileXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TaoFileXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static private void themNhanVien(Document doc, Element CongTy, NhanVien nv) {
        Element NhanVien = doc.createElement("nhanvien");
            
            Element TenNV = doc.createElement("hoten");
            TenNV.setTextContent(nv.getTenNV());
            Element Luong = doc.createElement("luong");
            Luong.setTextContent(nv.getLuong());
            Element PhongBan = doc.createElement("phongban");
            Element TenPhong = doc.createElement("tenphong");
            TenPhong.setTextContent(nv.getTenPhong());
            Element DienThoai = doc.createElement("dienthoai");
            DienThoai.setTextContent(nv.getSDT());
            
            PhongBan.appendChild(TenPhong);
            PhongBan.appendChild(DienThoai);
            
            NhanVien.setAttribute("manv", nv.getMaNV());
            NhanVien.appendChild(TenNV);
            NhanVien.appendChild(Luong);
            NhanVien.appendChild(PhongBan);
            
            CongTy.appendChild(NhanVien);
    }
}
