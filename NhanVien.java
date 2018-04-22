/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

/**
 *
 * @author namph
 */
public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String Luong;
    private String TenPhong;
    private String SDT;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String Luong, String TenPhong, String SDT) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Luong = Luong;
        this.TenPhong = TenPhong;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getLuong() {
        return Luong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    
}
