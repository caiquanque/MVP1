package com.example.thongdt.mvp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thongdt.mvp1.Presenter.DangNhap.PresenterLogicXuLyDangNhap;
import com.example.thongdt.mvp1.View.DangNhap.ViewXuLyDangNhap;
import com.example.thongdt.mvp1.View.NhanVien.NhanVienActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewXuLyDangNhap {

    @BindView(R.id.edt_ten_dang_nhap)
    EditText edTenDangNhap;

    @BindView(R.id.edt_mat_khau)
    EditText edMatKhau;

    @BindView(R.id.btn_dong_y)
    Button btnDongY;

    PresenterLogicXuLyDangNhap logicXuLyDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logicXuLyDangNhap = new PresenterLogicXuLyDangNhap(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_dong_y)
    public void submit(View view) {
        String tendangnhap, matkhau;

        tendangnhap = edTenDangNhap.getText().toString();
        matkhau = edMatKhau.getText().toString();

        logicXuLyDangNhap.KiemTraDangNhap(tendangnhap, matkhau);
    }

    @Override
    public void DangNhapThanhCong() {
        Intent intent = new Intent(MainActivity.this, NhanVienActivity.class);
        startActivity(intent);
    }

    @Override
    public void DangNhapThatBai() {
        Toast.makeText(MainActivity.this, "Dang Nhap That Bai", Toast.LENGTH_SHORT).show();
    }



}
