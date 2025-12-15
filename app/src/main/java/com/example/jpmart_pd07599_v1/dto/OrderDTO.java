package com.example.jpmart_pd07599_v1.dto;

public class OrderDTO {
    private String maHoaDon;
    private String tenKhachHang;
    private String tenNhanVien;
    private int tongTien;

    public OrderDTO(String maHoaDon, String tenKhachHang,
                    String tenNhanVien, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.tenNhanVien = tenNhanVien;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() { return maHoaDon; }
    public String getTenKhachHang() { return tenKhachHang; }
    public String getTenNhanVien() { return tenNhanVien; }
    public int getTongTien() { return tongTien; }
}
