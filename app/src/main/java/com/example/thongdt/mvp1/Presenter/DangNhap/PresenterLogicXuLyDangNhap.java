package com.example.thongdt.mvp1.Presenter.DangNhap;

import com.example.thongdt.mvp1.View.DangNhap.ViewXuLyDangNhap;

/**
 * Created by thong.dt on 30/01/2018.
 */

public class PresenterLogicXuLyDangNhap implements PresenterImpXuLyDangNhap {

    ViewXuLyDangNhap viewXuLyDangNhap;

    public PresenterLogicXuLyDangNhap(ViewXuLyDangNhap viewXuLyDangNhap) {
        this.viewXuLyDangNhap = viewXuLyDangNhap;
    }

    @Override
    public void KiemTraDangNhap(String tendangnhap, String matkhau) {
        // Goi -> Model lay dl
        if (tendangnhap.equals("ABC") && matkhau.equals("123")) {
            //tra ra view dang nhap thanh cong
            viewXuLyDangNhap.DangNhapThanhCong();
        } else {
            //tra ra view dang nhap that bai
            viewXuLyDangNhap.DangNhapThatBai();
        }
    }
}
