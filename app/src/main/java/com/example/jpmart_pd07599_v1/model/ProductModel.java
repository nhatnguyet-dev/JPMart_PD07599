package com.example.jpmart_pd07599_v1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ProductModel implements Parcelable {
    private int id;
    private String maSanPham;
    private String tenSanPham;
    private int donGia;
    private int soLuong;
    private String donViTinh;
    private String moTa;
    private Boolean isDeleted;
    private String createAt;
    public ProductModel(){};
    public ProductModel(int id, String maSanPham, String tenSanPham, int donGia, String donViTinh,
                            int soLuong, Boolean isDeleted, String createAt){
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.isDeleted = isDeleted;
        this.createAt = createAt;
    }

    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected ProductModel(Parcel in) {
        id = in.readInt();
        maSanPham = in.readString();
        tenSanPham = in.readString();
        donGia = in.readInt();
        donViTinh = in.readString();
        soLuong = in.readInt();
        // isDeleted: đọc giá trị 0, 1, 2 → Boolean hoặc null
        byte deletedVal = in.readByte();
        if (deletedVal == 0) {
            isDeleted = null;
        } else if (deletedVal == 1) {
            isDeleted = true;
        } else {
            isDeleted = false;
        }

        createAt = in.readString();
    }

    // toString() dùng cho Spinner hoặc ListView
    @NonNull
    @Override
    public String toString() {
        return tenSanPham;
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(maSanPham);
        parcel.writeString(tenSanPham);
        parcel.writeInt(donGia);
        parcel.writeString(donViTinh);
        parcel.writeInt(soLuong);
        // Boolean: ghi ra 0(null), 1(true), 2(false)
        parcel.writeByte((byte) (isDeleted == null ? 0 : isDeleted ? 1 : 2));

        parcel.writeString(createAt);
    }
}
