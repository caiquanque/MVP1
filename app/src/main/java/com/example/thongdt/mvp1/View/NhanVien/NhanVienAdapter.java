package com.example.thongdt.mvp1.View.NhanVien;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.thongdt.mvp1.Model.Local.NhanVien;
import com.example.thongdt.mvp1.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> implements PopupMenu.OnMenuItemClickListener/*, NhanVienActivity.AdapterNhanVienListener*/ {
    public void deleteNV(NhanVien nvToDelete) {
        if (nhanViens != null) {
            nhanViens.remove(nvToDelete);
        }
    }

    public interface AdapterNhanVienListener {
        void del(NhanVien Nv);
        void edit(NhanVien vn);
    }

    List<NhanVien> nhanViens;
    Context context;
    private AdapterNhanVienListener listener;

    public NhanVienAdapter(List<NhanVien> nhanViens, Context context, AdapterNhanVienListener listener) {
        this.nhanViens = nhanViens;
        this.context = context;
        this.listener = listener;
    }

    public void addNhanVien(NhanVien newNV) {
        if (nhanViens == null) {
            nhanViens = new ArrayList<>();
        }
        nhanViens.add(newNV);
    }

    public void resetNhanView(List<NhanVien> newNhanviens) {
        this.nhanViens = newNhanviens;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvID.setText(String.valueOf(nhanViens.get(position)));
        holder.tvTen.setText(nhanViens.get(position).getNhanVienTen());
        holder.tvMatKhau.setText(nhanViens.get(position).getNhanVienMatKhau());
        //Picasso
        Picasso.with(context).load(nhanViens.get(position).getNhanVienHinh()).into(holder.imgHinh);
    }


    @Override
    public int getItemCount() {
        return nhanViens.size();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_id)
        TextView tvID;
        @BindView(R.id.iv_hinh)
        ImageView imgHinh;
        @BindView(R.id.tv_ten)
        TextView tvTen;
        @BindView(R.id.tv_mat_khau)
        TextView tvMatKhau;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btn_menu)
        void showPopupMenu(View v) {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_xoa:
                            if (listener != null) {
                                listener.del(nhanViens.get(getAdapterPosition()));
                            }
                            break;
                        case R.id.menu_sua:
                            if (listener != null) {
                                listener.edit(nhanViens.get(getAdapterPosition()));
                            }
                            break;
                    }
                    return true;
                }
            });
            popupMenu.show();
        }
    }
}