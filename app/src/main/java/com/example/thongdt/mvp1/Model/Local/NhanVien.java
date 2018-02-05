package com.example.thongdt.mvp1.Model.Local;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Table(name = DataBaseKeys.TABLE_NHAN_VIEN_NAME)
public class NhanVien extends Model implements Serializable {
    private static final String NHAN_VIEN_ID = "nhanVienID";
    private static final String NHAN_VIEN_TEN = "nhanVienTen";
    private static final String NHAN_VIEN_MAT_KHAU = "nhanVienMatKhau";
    private static final String NHAN_VIEN_Hinh = "nhanVienHinh";
//    Random random = new Random();

    @Column(name = NHAN_VIEN_ID)
    private int nhanVienID = 0;

    @Column(name = NHAN_VIEN_TEN)
    private String nhanVienTen = "";

    @Column(name = NHAN_VIEN_MAT_KHAU)
    private String nhanVienMatKhau = "";

    @Column(name = NHAN_VIEN_Hinh)
    private String nhanVienHinh = "";

    public NhanVien(String ten, String matKhau,String image) {
        super();
        this.nhanVienTen = ten;
        this.nhanVienMatKhau = matKhau;
        this.nhanVienHinh = image;
    }

    public NhanVien() {
        super();
    }

    public NhanVien(String s) {
        super();
     //   this.nhanVienID = getNhanVienID();
        this.nhanVienID = nhanVienID;

     //   this.nhanVienTen = getNhanVienTen();
        this.nhanVienTen = nhanVienTen;

    //    this.nhanVienHinh = getNhanVienHinh();
        this.nhanVienHinh = nhanVienHinh;
    }

    public void setNhanVienTen(String nhanVienTen) {
        this.nhanVienTen = nhanVienTen;
    }

    public void setNhanVienMatKhau(String nhanVienMatKhau) {
        this.nhanVienMatKhau = nhanVienMatKhau;
    }

    public String getNhanVienHinh() {
        return nhanVienHinh;
    }

    public void setNhanVienHinh(String nhanVienHinh) {
        this.nhanVienHinh = nhanVienHinh;
    }

    public static String getNHAN_VIEN_Hinh() {
        return NHAN_VIEN_Hinh;
    }

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public String getNhanVienTen() {
        return nhanVienTen;
    }

    public String getNhanVienMatKhau() {
        return nhanVienMatKhau;
    }

    public static List<NhanVien> getAll() {
        return new Select()
                .from(NhanVien.class)
                .orderBy(NHAN_VIEN_ID + " ASC")
                .execute();
    }
}






