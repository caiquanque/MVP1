package com.example.thongdt.mvp1.View.NhanVien;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.thongdt.mvp1.Model.Local.NhanVien;
import com.example.thongdt.mvp1.R;
import com.example.thongdt.mvp1.util.ImagePool;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NhanVienActivity extends AppCompatActivity implements NhanVienAdapter.AdapterNhanVienListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_nhan_vien);
        ButterKnife.bind(this);
        //initView
        initView();
    }

    NhanVienAdapter nhanVienAdapter;
    @BindView(R.id.edt_ten)
    EditText edtThemTen;
    @BindView(R.id.edt_mat_khau)
    EditText edtThemMatKhau;
    @BindView(R.id.ibtn_hinh)
    ImageButton ibtnHinh;
    @BindView(R.id.btn)
    Button btnThem;
    @BindView(R.id.recyler_view)
    RecyclerView recycler_view;
    boolean isEdit = false;
    NhanVien nhanVienEdit;

    //initView
    public void initView() {
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(layoutManager);
        List<NhanVien> nhanViens = NhanVien.getAll();

        nhanVienAdapter = new NhanVienAdapter(nhanViens, this,this);
        recycler_view.setAdapter(nhanVienAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.btn)
    public void btnThem() {
        String ten = edtThemTen.getText().toString().trim();
        String matKhau = edtThemMatKhau.getText().toString().trim();
        if (isEdit) {
            nhanVienEdit.setNhanVienTen(ten);
            nhanVienEdit.setNhanVienMatKhau(matKhau);
            nhanVienEdit.save();
            nhanVienAdapter.resetNhanView(NhanVien.getAll());
            isEdit = false;
            Toast.makeText(this, "Cap nhat thanh cong !", Toast.LENGTH_SHORT).show();

        } else {
            String imagePath = ImagePool.getImage();

            if (TextUtils.isEmpty(ten)) {
                edtThemTen.requestFocus();
                Toast.makeText(this, "Nhap ten", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(matKhau)) {
                edtThemMatKhau.requestFocus();
                Toast.makeText(this, "Nhap mat khau", Toast.LENGTH_SHORT).show();
                return;
            }


            NhanVien nhanVien1 = new NhanVien(ten, matKhau, imagePath);
            nhanVien1.save();
            // or update a NV
            if (nhanVienAdapter != null) {
                nhanVienAdapter.addNhanVien(nhanVien1);
                nhanVienAdapter.notifyDataSetChanged();
            }
        }

        edtThemTen.setText(null);
        edtThemMatKhau.setText(null);
        edtThemTen.requestFocus();
    }

    public void startPickImageFromGa() {
        //pick photo from gallery
        Intent intent = new Intent();
    }

    @Override
    public void del(NhanVien nvToDelete) {
        //  NhanVien.delete(NhanVien.class, nhanViens.get(position).getNhanVienID());
        if (nvToDelete.getId() != null) {
            nvToDelete.delete();
            nhanVienAdapter.deleteNV(nvToDelete);
            nhanVienAdapter.notifyDataSetChanged();

        }
        Toast.makeText(this, "Xoa thanh cong !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void edit(NhanVien nvToUpdate) {
        if(nvToUpdate.getId() == null) return;
        nhanVienEdit = nvToUpdate;
        if(!isEdit){
            edtThemTen.setText(nvToUpdate.getNhanVienTen());
            edtThemMatKhau.setText(nvToUpdate.getNhanVienMatKhau());
            isEdit = true;
        }

    }
}
