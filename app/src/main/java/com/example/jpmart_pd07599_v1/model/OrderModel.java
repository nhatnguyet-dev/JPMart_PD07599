package com.example.jpmart_pd07599_v1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class OrderModel implements Parcelable {
    private int id;
    private String maHoaDon;
    private String maKhachHang;
    private String maNhanVien;
    private int tongTien;
    private String phuongThucThanhToan;
    private String moTa;
    private int status;
    private String createAt;
    public OrderModel(){}
    public OrderModel(int id, String maHoaDon, String maKhachHang, String maNhanVien, int tongTien,
                      String phuongThucThanhToan, String moTa, int status, String createAt ){
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.moTa = moTa;
        this.status = status;
        this.createAt = createAt;
    }
    protected OrderModel(Parcel in){
        id = in.readInt();
        maHoaDon = in.readString();
        maKhachHang = in.readString();
        maNhanVien = in.readString();
        tongTien = in.readInt();
        phuongThucThanhToan = in.readString();
        moTa = in.readString();
        status = in.readInt();
        createAt = in.readString();
    }
    public final Creator<OrderModel> CREATOR = new Creator<OrderModel>() {
        @Override
        public OrderModel createFromParcel(Parcel in) {
            return new OrderModel(in);
        }

        @Override
        public OrderModel[] newArray(int i) {
            return new OrderModel[i];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(maHoaDon);
        parcel.writeString(maKhachHang);
        parcel.writeString(maNhanVien);
        parcel.writeInt(tongTien);
        parcel.writeString(phuongThucThanhToan);
        parcel.writeString(moTa);
        parcel.writeInt(status);
        parcel.writeString(createAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Creator<OrderModel> getCREATOR() {
        return CREATOR;
    }
}
