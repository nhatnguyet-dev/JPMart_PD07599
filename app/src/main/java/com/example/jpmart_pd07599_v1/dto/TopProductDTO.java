package com.example.jpmart_pd07599_v1.dto;

public class TopProductDTO {
    private String maSanPham;
    private String tenSanPham;
    private int tongSoLuong;
    private int tongDoanhThu;

    // constructor + getter
    public TopProductDTO(){}
    public TopProductDTO(String maSanPham, String tenSanPham, int tongSoLuong, int tongDoanhThu){
        this.maSanPham = maSanPham;
        this.tenSanPham =tenSanPham;
        this.tongSoLuong = tongSoLuong;
        this.tongDoanhThu = tongDoanhThu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public int getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(int tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
}
