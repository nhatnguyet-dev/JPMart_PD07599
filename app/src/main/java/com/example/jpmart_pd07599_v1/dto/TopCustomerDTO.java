package com.example.jpmart_pd07599_v1.dto;

public class TopCustomerDTO {
    private String maKhachHang;
    private String tenKhachHang;
    private int soDonHang;
    private int tongChiTieu;

    public TopCustomerDTO(String ma, String ten, int soDon, int tong) {
        this.maKhachHang = ma;
        this.tenKhachHang = ten;
        this.soDonHang = soDon;
        this.tongChiTieu = tong;
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

    public int getSoDonHang() {
        return soDonHang;
    }

    public void setSoDonHang(int soDonHang) {
        this.soDonHang = soDonHang;
    }

    public int getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(int tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
}
