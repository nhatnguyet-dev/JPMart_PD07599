package com.example.jpmart_pd07599_v1.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DanhMucModel implements Parcelable {

    private int id;
    private String maDanhMuc;
    private String tenDanhMuc;
    private String moTa;
    private Boolean isDeleted;
    private String createAt;

    public DanhMucModel() {}

    // Constructor dùng khi chỉ cần 3 trường
    public DanhMucModel(int id, String maDanhMuc, String tenDanhMuc){
        this.id = id;
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    // Constructor đầy đủ (gợi ý nên thêm để tiện sử dụng)
    public DanhMucModel(int id, String maDanhMuc, String tenDanhMuc, String moTa, Boolean isDeleted, String createAt){
        this.id = id;
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.moTa = moTa;
        this.isDeleted = isDeleted;
        this.createAt = createAt;
    }

    // Constructor khi đọc từ Parcel
    protected DanhMucModel(Parcel in){
        id = in.readInt();
        maDanhMuc = in.readString();
        tenDanhMuc = in.readString();
        moTa = in.readString();

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
        return tenDanhMuc;
    }

    // Getter – Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(String maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public Boolean getIsDeleted() { return isDeleted; }
    public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

    public String getCreateAt() { return createAt; }
    public void setCreateAt(String createAt) { this.createAt = createAt; }

    // Parcelable bắt buộc
    public static final Creator<DanhMucModel> CREATOR = new Creator<DanhMucModel>() {
        @Override
        public DanhMucModel createFromParcel(Parcel in) {
            return new DanhMucModel(in);
        }

        @Override
        public DanhMucModel[] newArray(int size) {
            return new DanhMucModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // Ghi dữ liệu vào Parcel
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(maDanhMuc);
        parcel.writeString(tenDanhMuc);
        parcel.writeString(moTa);

        // Boolean: ghi ra 0(null), 1(true), 2(false)
        parcel.writeByte((byte) (isDeleted == null ? 0 : isDeleted ? 1 : 2));

        parcel.writeString(createAt);
    }
}
