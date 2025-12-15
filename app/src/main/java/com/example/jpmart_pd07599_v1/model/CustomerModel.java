package com.example.jpmart_pd07599_v1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CustomerModel implements Parcelable {
    private int id;
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String hangThanhVien;
    private String moTa;
    private Boolean isActive;
    private String createAt;
    public CustomerModel(){}
    public CustomerModel(int id, String maKhachHang, String tenKhachHang, String soDienThoai,
                         String email, String diaChi, String hangThanhVien, String moTa,
                         Boolean isActive, String createAt){
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.hangThanhVien = hangThanhVien;
        this.moTa = moTa;
        this.isActive = isActive;
        this.createAt = createAt;
    }
    protected CustomerModel(Parcel in){
        id = in.readInt();
        maKhachHang = in.readString();
        tenKhachHang =  in.readString();
        soDienThoai = in.readString();
        email = in.readString();
        diaChi = in.readString();
        hangThanhVien = in.readString();
        moTa = in.readString();
        byte tmpIsActive = in.readByte();
        isActive = tmpIsActive == 0 ? null : tmpIsActive == 1;
        createAt = in.readString();
    }
    @NonNull
    @Override
    public String toString(){return tenKhachHang;}
    public static final Creator<CustomerModel> CREATOR = new Creator<CustomerModel>() {
        @Override
        public CustomerModel createFromParcel(Parcel in) {
            return new CustomerModel(in);
        }

        @Override
        public CustomerModel[] newArray(int i) {
            return new CustomerModel[i];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(maKhachHang);
        parcel.writeString(tenKhachHang);
        parcel.writeString(soDienThoai);
        parcel.writeString(email);
        parcel.writeString(diaChi);
        parcel.writeString(hangThanhVien);
        parcel.writeString(moTa);

        parcel.writeByte((byte) (isActive == null ? 0 : isActive ? 0 : 1));
        parcel.writeString(createAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHangThanhVien() {
        return hangThanhVien;
    }

    public void setHangThanhVien(String hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
