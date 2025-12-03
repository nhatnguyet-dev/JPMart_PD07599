package com.example.jpmart_pd07599_v1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class NhanVienModel implements Parcelable {
    private int id;
    private String maNhanVien;
    private String tenNhanVien;
    private String password;
    private int gioiTinh;
    private String ngaySinh;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private int chucVu;
    private String createAt;
    private Boolean isActive;
    private String note;

    public NhanVienModel() {
    }
    public NhanVienModel(int id, String maNhanVien, String tenNhanVien){
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    protected NhanVienModel(Parcel in) {
        id = in.readInt();
        maNhanVien = in.readString();
        tenNhanVien = in.readString();
        password = in.readString();
        gioiTinh = in.readInt();
        ngaySinh = in.readString();
        soDienThoai = in.readString();
        email = in.readString();
        diaChi = in.readString();
        chucVu = in.readInt();
        createAt = in.readString();
        byte tmpIsActive = in.readByte();
        isActive = tmpIsActive == 0 ? null : tmpIsActive == 1;
        note = in.readString();
    }

    @NonNull
    @Override
    public String toString(){
        return tenNhanVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static final Creator<NhanVienModel> CREATOR = new Creator<NhanVienModel>() {
        @Override
        public NhanVienModel createFromParcel(Parcel in) {
            return new NhanVienModel(in);
        }

        @Override
        public NhanVienModel[] newArray(int size) {
            return new NhanVienModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(maNhanVien);
        parcel.writeString(tenNhanVien);
        parcel.writeString(password);
        parcel.writeInt(gioiTinh);
        parcel.writeString(ngaySinh);
        parcel.writeString(soDienThoai);
        parcel.writeString(email);
        parcel.writeString(diaChi);
        parcel.writeInt(chucVu);
        parcel.writeString(createAt);
        parcel.writeByte((byte) (isActive == null ? 0 : isActive ? 1 : 2));
        parcel.writeString(note);
    }
}
