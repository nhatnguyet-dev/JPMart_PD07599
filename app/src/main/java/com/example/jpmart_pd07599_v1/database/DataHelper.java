package com.example.jpmart_pd07599_v1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jpmart_pd07599_v1.model.CustomerModel;
import com.example.jpmart_pd07599_v1.model.DanhMucModel;
import com.example.jpmart_pd07599_v1.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "JPMart_DB";
    private static final int DB_Version = 4;
    public DataHelper(Context context){
        super(context, DB_Name, null, DB_Version);
    }

    // Danh muc
    public static final String BangDanhMuc = "DanhMuc";
    public static final String CotMaDanhMuc = "maDanhMuc";
    public static final String CotTenDanhMuc = "tenDanhMuc";
    public static final String CotMoTa = "moTa";
    public static final String CotXoaMem = "isDeleted";
    public static final String CotNgayKhoiTao = "createAt";
    //    San Pham
    public static final String BangSanPham = "SanPham";
    public static final String CotMaSanPham = "maSanPham";
    public static final String CotTenSanPham = "tenSanPham";
    public static final String CotDonGia = "donGia";
    public static final String CotDonViTinh = "donViTinh";
    public static final String CotSoLuong = "soLuong";
    //    Khách hàng
    public static final String BangKhachHang = "KhachHang";
    public static final String CotMaKhachHang = "maKhachHang";
    public static final String CotTenKhachHang = "tenKhachHang";
    public static final String CotHangThanhVien = "hangThanhVien";
    //    Nhan vien
    public static final String BangNhanVien = "NhanVien";
    public static final String CotMaNhanVien = "maNhanVien";
    public static final String CotTenNhanVien = "tenNhanVien";
    public static final String CotMatKhauNhanVien = "password";
    public static final String CotGioiTinh = "gioTinh";
    public static final String CotNgaySinh = "ngaySinh";
    public static final String CotSoDienThoai = "soDienThoai";
    public static final String CotEmail = "email";
    public static final String CotDiaChi = "diaChi";
    public static final String CotChucVu = "chucVu";
    public static final String CotHoatDong = "isActive";
    //    Đơn hàng
    public static final String BangHoaDon = "HoaDon";
    public static final String CotMaHoaDon = "maHoaDon";
    public static final String CotTongTien = "tongTien";
    public static final String CotPhuongThucThanhToan = "phuongThucThanhToan";
    public static final String CotStatus = "status";
    //    Đơn hàng chi tiết
    public static final String BangHoaDonChiTiet = "HoaDonChiTiet";
    public static final String CotThanhTien = "thanhTien";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TaoBangDanhMuc = "CREATE TABLE IF NOT EXISTS " + BangDanhMuc +
            " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CotMaDanhMuc + " TEXT UNIQUE, " +
            CotTenDanhMuc + " TEXT NOT NULL, " +
            CotMoTa + " TEXT, " +
            CotXoaMem + " INTEGER DEFAULT 0, " +
            CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime'))" + ")";

        String TaoBangSanPham = "CREATE TABLE IF NOT EXISTS " + BangSanPham +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaDanhMuc + " TEXT NOT NULL, "+
                CotMaSanPham + " TEXT UNIQUE NOT NULL, " +
                CotTenSanPham + " TEXT NOT NULL, "+
                CotDonGia + " INTEGER NOT NULL, "+
                CotDonViTinh + " TEXT NOT NULL, " +
                CotSoLuong + " INTEGER NOT NULL, "+
                CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime')), " +
                CotXoaMem + " INTEGER DEFAULT 0, " +
                CotMoTa + " TEXT, " +
                // khóa ngoại
                " FOREIGN KEY (" + CotMaDanhMuc + ") REFERENCES " +
                BangDanhMuc + "(" + CotMaDanhMuc + ")" + ") ";

        String TaoBangKhachHang = "CREATE TABLE IF NOT EXISTS "+ BangKhachHang +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaKhachHang + " TEXT UNIQUE NOT NULL, " +
                CotTenKhachHang + " TEXT NOT NULL, " +
                CotSoDienThoai + " TEXT, " +
                CotEmail + " TEXT, " +
                CotDiaChi + " TEXT, "+
                CotHangThanhVien + " TEXT DEFAULT 'thanh vien'," +
                CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime'))," +
                CotHoatDong + " INTEGER DEFAULT 1, " +
                CotMoTa + " TEXT " + ")";

        String TaoBangNhanVien = "CREATE TABLE IF NOT EXISTS " + BangNhanVien +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaNhanVien + " TEXT UNIQUE NOT NULL, " +
                CotTenNhanVien + " TEXT NOT NULL, "+
                CotMatKhauNhanVien + " TEXT, " +
                CotGioiTinh + " INTEGER DEFAULT 0, "+
                CotNgaySinh + " DATETIME DEFAULT (datetime('now','localtime'))," +
                CotSoDienThoai + " TEXT, " +
                CotEmail + " TEXT, "+
                CotDiaChi + " TEXT, "+
                CotChucVu + " INTEGER DEFAULT 0, "+
                CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime')), " +
                CotHoatDong + " INTEGER DEFAULT 1, " +
                CotMoTa + " TEXT " + ") ";

        String TaoBangDonHang = "CREATE TABLE IF NOT EXISTS "+ BangHoaDon +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaHoaDon + " TEXT UNIQUE NOT NULL, " +
                CotMaKhachHang + " TEXT NOT NULL, " +
                CotMaNhanVien + " TEXT NOT NULL, " +
                CotTongTien + " INTEGER NOT NULL, " +
                CotPhuongThucThanhToan + " TEXT NOT NULL, " +
                CotMoTa + " TEXT, " +
                CotStatus + " INTEGER DEFAULT 1, " +
                CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime')), " +
                " FOREIGN KEY (" + CotMaKhachHang + ") REFERENCES " + BangKhachHang + "("
                + CotMaKhachHang + "), " +
                " FOREIGN KEY (" + CotMaNhanVien + ") REFERENCES " + BangNhanVien + "("
                + CotMaNhanVien + "))";

        String TaoBangDonHangChiTiet = "CREATE TABLE IF NOT EXISTS " + BangHoaDonChiTiet +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaHoaDon + " TEXT NOT NULL, " +
                CotMaSanPham + " TEXT NOT NULL, " +
                CotSoLuong + " INTEGER NOT NULL, " +
                CotDonGia + " INTEGER NOT NULL, " +
                CotThanhTien + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + CotMaHoaDon + ") REFERENCES " + BangHoaDon + "(" +
                CotMaHoaDon + "), " +
                " FOREIGN KEY (" + CotMaSanPham + ") REFERENCES " + BangSanPham + "(" +
                CotMaSanPham + "))";

        sqLiteDatabase.execSQL(TaoBangDanhMuc);
        sqLiteDatabase.execSQL(TaoBangSanPham);
        sqLiteDatabase.execSQL(TaoBangKhachHang);
        sqLiteDatabase.execSQL(TaoBangNhanVien);
        sqLiteDatabase.execSQL(TaoBangDonHangChiTiet);
        sqLiteDatabase.execSQL(TaoBangDonHang);
        insertDefaultCategory(sqLiteDatabase);
        insertDefaultProduct(sqLiteDatabase);
        insertDefaultCustomer(sqLiteDatabase);
        insertDefaultEmployee(sqLiteDatabase);
        insertDefaultOrder(sqLiteDatabase);
        insertDefaultOrderDetail(sqLiteDatabase);
    }

    private void insertDefaultCategory(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaDanhMuc, "DM001");
        values.put(CotTenDanhMuc, "Thực phẩm");
        values.put(CotMoTa, "Thực phẩm đóng gói, mì ăn liền, gia vị từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM002");
        values.put(CotTenDanhMuc, "Đồ uống");
        values.put(CotMoTa, "Nước ngọt, trà, cà phê, rượu sake Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM003");
        values.put(CotTenDanhMuc, "Mỹ phẩm");
        values.put(CotMoTa, "Sản phẩm chăm sóc da, trang điểm từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM004");
        values.put(CotTenDanhMuc, "Đồ gia dụng");
        values.put(CotMoTa, "Dụng cụ nhà bếp, đồ dùng sinh hoạt Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM005");
        values.put(CotTenDanhMuc, "Thời trang");
        values.put(CotMoTa, "Quần áo, phụ kiện thời trang từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM006");
        values.put(CotTenDanhMuc, "Điện tử");
        values.put(CotMoTa, "Thiết bị điện tử, công nghệ từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM007");
        values.put(CotTenDanhMuc, "Sức khỏe");
        values.put(CotMoTa, "Thực phẩm chức năng, thuốc không kê đơn từ Nhật");
        db.insert(BangDanhMuc, null, values);
    }
    private void insertDefaultProduct(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaDanhMuc, "DM001");
        values.put(CotMaSanPham, "SP001");
        values.put(CotTenSanPham, "Mì ramen Nhật Bản");
        values.put(CotDonGia, 25000);
        values.put(CotDonViTinh, "Gói");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM002");
        values.put(CotMaSanPham, "SP002");
        values.put(CotTenSanPham, "Trà xanh Matcha");
        values.put(CotDonGia, 150000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM001");
        values.put(CotMaSanPham, "SP003");
        values.put(CotTenSanPham, "Nước tương Kikkoman");
        values.put(CotDonGia, 45000);
        values.put(CotDonViTinh, "Chai");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM002");
        values.put(CotMaSanPham, "SP004");
        values.put(CotTenSanPham, "Rượu Sake Ozeki");
        values.put(CotDonGia, 350000);
        values.put(CotDonViTinh, "Chai");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM003");
        values.put(CotMaSanPham, "SP005");
        values.put(CotTenSanPham, "Mặt nạ Senka");
        values.put(CotDonGia, 85000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM003");
        values.put(CotMaSanPham, "SP006");
        values.put(CotTenSanPham, "Kem chống nắng Anessa");
        values.put(CotDonGia, 380000);
        values.put(CotDonViTinh, "Tuýp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM004");
        values.put(CotMaSanPham, "SP007");
        values.put(CotTenSanPham, "Dao nhà bếp Kai");
        values.put(CotDonGia, 250000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM004");
        values.put(CotMaSanPham, "SP008");
        values.put(CotTenSanPham, "Bát sứ Nhật");
        values.put(CotDonGia, 120000);
        values.put(CotDonViTinh, "Bộ");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM005");
        values.put(CotMaSanPham, "SP009");
        values.put(CotTenSanPham, "Áo thun Uniqlo");
        values.put(CotDonGia, 199000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM006");
        values.put(CotMaSanPham, "SP010");
        values.put(CotTenSanPham, "Tai nghe Sony WH-1000XM4");
        values.put(CotDonGia, 7500000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM007");
        values.put(CotMaSanPham, "SP011");
        values.put(CotTenSanPham, "Viên uống Collagen DHC");
        values.put(CotDonGia, 320000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaDanhMuc, "DM001");
        values.put(CotMaSanPham, "SP012");
        values.put(CotTenSanPham, "Kẹo Kit Kat Matcha");
        values.put(CotDonGia, 65000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
    }
    private void insertDefaultEmployee(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaNhanVien, "NV001");
        values.put(CotTenNhanVien, "Nguyễn Văn An");
        values.put(CotMatKhauNhanVien, "123456"); // Nên mã hóa password trong thực tế
        values.put(CotGioiTinh, 1); // 1: Nam, 0: Nữ
        values.put(CotNgaySinh, "1990-05-15");
        values.put(CotSoDienThoai, "0901234567");
        values.put(CotEmail, "an.nguyen@jmart.vn");
        values.put(CotDiaChi, "123 Trần Hưng Đạo, Đà Nẵng");
        values.put(CotChucVu, 1); // 1: Quản lý, 0: Nhân viên
        values.put(CotMoTa, "Quản lý cửa hàng");
        db.insert(BangNhanVien, null, values);
        values.clear();

        values.put(CotMaNhanVien, "NV002");
        values.put(CotTenNhanVien, "Trần Thị Bình");
        values.put(CotMatKhauNhanVien, "123456");
        values.put(CotGioiTinh, 0);
        values.put(CotNgaySinh, "1995-08-20");
        values.put(CotSoDienThoai, "0912345678");
        values.put(CotEmail, "binh.tran@jmart.vn");
        values.put(CotDiaChi, "456 Lê Lợi, Đà Nẵng");
        values.put(CotChucVu, 0);
        values.put(CotMoTa, "Nhân viên bán hàng");
        db.insert(BangNhanVien, null, values);
        values.clear();

        values.put(CotMaNhanVien, "NV003");
        values.put(CotTenNhanVien, "Lê Văn Cường");
        values.put(CotMatKhauNhanVien, "123456");
        values.put(CotGioiTinh, 1);
        values.put(CotNgaySinh, "1998-03-10");
        values.put(CotSoDienThoai, "0923456789");
        values.put(CotEmail, "cuong.le@jmart.vn");
        values.put(CotDiaChi, "789 Nguyễn Văn Linh, Đà Nẵng");
        values.put(CotChucVu, 0);
        values.put(CotMoTa, "Nhân viên bán hàng");
        db.insert(BangNhanVien, null, values);
        values.clear();

        values.put(CotMaNhanVien, "NV004");
        values.put(CotTenNhanVien, "Phạm Thị Dung");
        values.put(CotMatKhauNhanVien, "123456");
        values.put(CotGioiTinh, 0);
        values.put(CotNgaySinh, "1997-11-25");
        values.put(CotSoDienThoai, "0934567890");
        values.put(CotEmail, "dung.pham@jmart.vn");
        values.put(CotDiaChi, "321 Hải Phòng, Đà Nẵng");
        values.put(CotChucVu, 0);
        values.put(CotMoTa, "Nhân viên thu ngân");
        db.insert(BangNhanVien, null, values);
        values.clear();

        values.put(CotMaNhanVien, "NV005");
        values.put(CotTenNhanVien, "Hoàng Minh Tuấn");
        values.put(CotMatKhauNhanVien, "123456");
        values.put(CotGioiTinh, 1);
        values.put(CotNgaySinh, "1993-07-18");
        values.put(CotSoDienThoai, "0945678901");
        values.put(CotEmail, "tuan.hoang@jmart.vn");
        values.put(CotDiaChi, "654 Phan Châu Trinh, Đà Nẵng");
        values.put(CotChucVu, 0);
        values.put(CotMoTa, "Nhân viên kho");
        db.insert(BangNhanVien, null, values);
    }
    private void insertDefaultCustomer(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaKhachHang, "KH001");
        values.put(CotTenKhachHang, "Võ Thị Mai");
        values.put(CotSoDienThoai, "0987654321");
        values.put(CotEmail, "mai.vo@gmail.com");
        values.put(CotDiaChi, "100 Ngô Quyền, Đà Nẵng");
        values.put(CotHangThanhVien, "VIP");
        values.put(CotMoTa, "Khách hàng thân thiết");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH002");
        values.put(CotTenKhachHang, "Đặng Văn Hùng");
        values.put(CotSoDienThoai, "0976543210");
        values.put(CotEmail, "hung.dang@gmail.com");
        values.put(CotDiaChi, "200 Lý Thái Tổ, Đà Nẵng");
        values.put(CotHangThanhVien, "thanh vien");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH003");
        values.put(CotTenKhachHang, "Bùi Thị Lan");
        values.put(CotSoDienThoai, "0965432109");
        values.put(CotEmail, "lan.bui@gmail.com");
        values.put(CotDiaChi, "300 Điện Biên Phủ, Đà Nẵng");
        values.put(CotHangThanhVien, "thanh vien");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH004");
        values.put(CotTenKhachHang, "Trương Minh Khoa");
        values.put(CotSoDienThoai, "0954321098");
        values.put(CotEmail, "khoa.truong@gmail.com");
        values.put(CotDiaChi, "400 Hoàng Diệu, Đà Nẵng");
        values.put(CotHangThanhVien, "VIP");
        values.put(CotMoTa, "Khách hàng VIP");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH005");
        values.put(CotTenKhachHang, "Phan Thị Hương");
        values.put(CotSoDienThoai, "0943210987");
        values.put(CotEmail, "huong.phan@gmail.com");
        values.put(CotDiaChi, "500 Núi Thành, Đà Nẵng");
        values.put(CotHangThanhVien, "thanh vien");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH006");
        values.put(CotTenKhachHang, "Ngô Văn Tâm");
        values.put(CotSoDienThoai, "0932109876");
        values.put(CotEmail, "tam.ngo@gmail.com");
        values.put(CotDiaChi, "600 Ông Ích Khiêm, Đà Nẵng");
        values.put(CotHangThanhVien, "thanh vien");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH007");
        values.put(CotTenKhachHang, "Lý Thị Nhung");
        values.put(CotSoDienThoai, "0921098765");
        values.put(CotEmail, "nhung.ly@gmail.com");
        values.put(CotDiaChi, "700 Hùng Vương, Đà Nẵng");
        values.put(CotHangThanhVien, "thanh vien");
        db.insert(BangKhachHang, null, values);
        values.clear();

        values.put(CotMaKhachHang, "KH008");
        values.put(CotTenKhachHang, "Vũ Minh Đức");
        values.put(CotSoDienThoai, "0910987654");
        values.put(CotEmail, "duc.vu@gmail.com");
        values.put(CotDiaChi, "800 Trần Phú, Đà Nẵng");
        values.put(CotHangThanhVien, "VIP");
        values.put(CotMoTa, "Khách hàng thường xuyên");
        db.insert(BangKhachHang, null, values);
    }
    private void insertDefaultOrder(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaHoaDon, "HD001");
        values.put(CotMaKhachHang, "KH001");
        values.put(CotMaNhanVien, "NV002");
        values.put(CotTongTien, 575000); // 25000*2 + 150000 + 380000 - sẽ tính từ chi tiết
        values.put(CotPhuongThucThanhToan, "Tiền mặt");
        values.put(CotMoTa, "Mua hàng tại cửa hàng");
        values.put(CotStatus, 1); // 1: Hoàn thành
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD002");
        values.put(CotMaKhachHang, "KH002");
        values.put(CotMaNhanVien, "NV003");
        values.put(CotTongTien, 7750000); // Tai nghe Sony + Kem chống nắng
        values.put(CotPhuongThucThanhToan, "Chuyển khoản");
        values.put(CotMoTa, "Đặt hàng online");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD003");
        values.put(CotMaKhachHang, "KH003");
        values.put(CotMaNhanVien, "NV002");
        values.put(CotTongTien, 640000); // Viên uống Collagen + Mặt nạ + Kẹo
        values.put(CotPhuongThucThanhToan, "Thẻ");
        values.put(CotMoTa, "Thanh toán bằng thẻ");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD004");
        values.put(CotMaKhachHang, "KH004");
        values.put(CotMaNhanVien, "NV004");
        values.put(CotTongTien, 820000); // Rượu Sake + Dao + Bát sứ
        values.put(CotPhuongThucThanhToan, "Tiền mặt");
        values.put(CotMoTa, "Mua quà tặng");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD005");
        values.put(CotMaKhachHang, "KH005");
        values.put(CotMaNhanVien, "NV002");
        values.put(CotTongTien, 199000); // Áo thun Uniqlo
        values.put(CotPhuongThucThanhToan, "Chuyển khoản");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD006");
        values.put(CotMaKhachHang, "KH006");
        values.put(CotMaNhanVien, "NV003");
        values.put(CotTongTien, 300000); // Trà Matcha*2
        values.put(CotPhuongThucThanhToan, "Tiền mặt");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD007");
        values.put(CotMaKhachHang, "KH007");
        values.put(CotMaNhanVien, "NV002");
        values.put(CotTongTien, 475000); // Mặt nạ + Nước tương + Mì ramen*3
        values.put(CotPhuongThucThanhToan, "Chuyển khoản");
        values.put(CotMoTa, "Đang giao hàng");
        values.put(CotStatus, 0); // 0: Đang xử lý
        db.insert(BangHoaDon, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD008");
        values.put(CotMaKhachHang, "KH008");
        values.put(CotMaNhanVien, "NV004");
        values.put(CotTongTien, 7880000); // Tai nghe + Kem chống nắng
        values.put(CotPhuongThucThanhToan, "Thẻ");
        values.put(CotMoTa, "Khách hàng VIP");
        values.put(CotStatus, 1);
        db.insert(BangHoaDon, null, values);
    }
    private void insertDefaultOrderDetail(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaHoaDon, "HD001");
        values.put(CotMaSanPham, "SP001"); // Mì ramen
        values.put(CotSoLuong, 2);
        values.put(CotDonGia, 25000);
        values.put(CotThanhTien, 50000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD001");
        values.put(CotMaSanPham, "SP002"); // Trà Matcha
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 150000);
        values.put(CotThanhTien, 150000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD001");
        values.put(CotMaSanPham, "SP006"); // Kem chống nắng
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 380000);
        values.put(CotThanhTien, 380000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD002");
        values.put(CotMaSanPham, "SP010"); // Tai nghe Sony
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 7500000);
        values.put(CotThanhTien, 7500000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD002");
        values.put(CotMaSanPham, "SP006"); // Kem chống nắng
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 380000);
        values.put(CotThanhTien, 380000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD003");
        values.put(CotMaSanPham, "SP011"); // Viên uống Collagen
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 320000);
        values.put(CotThanhTien, 320000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD003");
        values.put(CotMaSanPham, "SP005"); // Mặt nạ Senka
        values.put(CotSoLuong, 2);
        values.put(CotDonGia, 85000);
        values.put(CotThanhTien, 170000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD003");
        values.put(CotMaSanPham, "SP012"); // Kẹo Kit Kat
        values.put(CotSoLuong, 3);
        values.put(CotDonGia, 65000);
        values.put(CotThanhTien, 195000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD004");
        values.put(CotMaSanPham, "SP004"); // Rượu Sake
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 350000);
        values.put(CotThanhTien, 350000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD004");
        values.put(CotMaSanPham, "SP007"); // Dao nhà bếp
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 250000);
        values.put(CotThanhTien, 250000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD004");
        values.put(CotMaSanPham, "SP008"); // Bát sứ
        values.put(CotSoLuong, 2);
        values.put(CotDonGia, 120000);
        values.put(CotThanhTien, 240000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD005");
        values.put(CotMaSanPham, "SP009"); // Áo thun Uniqlo
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 199000);
        values.put(CotThanhTien, 199000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD006");
        values.put(CotMaSanPham, "SP002"); // Trà Matcha
        values.put(CotSoLuong, 2);
        values.put(CotDonGia, 150000);
        values.put(CotThanhTien, 300000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD007");
        values.put(CotMaSanPham, "SP005"); // Mặt nạ
        values.put(CotSoLuong, 2);
        values.put(CotDonGia, 85000);
        values.put(CotThanhTien, 170000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD007");
        values.put(CotMaSanPham, "SP003"); // Nước tương
        values.put(CotSoLuong, 3);
        values.put(CotDonGia, 45000);
        values.put(CotThanhTien, 135000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD007");
        values.put(CotMaSanPham, "SP001"); // Mì ramen
        values.put(CotSoLuong, 4);
        values.put(CotDonGia, 25000);
        values.put(CotThanhTien, 100000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD008");
        values.put(CotMaSanPham, "SP010"); // Tai nghe Sony
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 7500000);
        values.put(CotThanhTien, 7500000);
        db.insert(BangHoaDonChiTiet, null, values);
        values.clear();

        values.put(CotMaHoaDon, "HD008");
        values.put(CotMaSanPham, "SP006"); // Kem chống nắng
        values.put(CotSoLuong, 1);
        values.put(CotDonGia, 380000);
        values.put(CotThanhTien, 380000);
        db.insert(BangHoaDonChiTiet, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BangDanhMuc);
        onCreate(sqLiteDatabase);
    }

    public List<DanhMucModel> getAllDanhMuc(){
        List<DanhMucModel> danhSachDanhMuc = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BangDanhMuc + " WHERE isDeleted = 0", null);

        if (cursor.moveToFirst()){
            do {
                DanhMucModel danhMuc = new DanhMucModel(
                        cursor.getInt(0), // id
                        cursor.getString(1), // maDanhMuc
                        cursor.getString(2), // tenDanhMuc
                        cursor.getString(3), // moTa
                        cursor.getInt(5) == 1, //isDeleted
                        cursor.getString(4) // createAt
                );
                danhSachDanhMuc.add(danhMuc);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return danhSachDanhMuc;
    }
    public boolean createDanhMuc(DanhMucModel danhmuc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CotMaDanhMuc, danhmuc.getMaDanhMuc());
        values.put(CotTenDanhMuc, danhmuc.getTenDanhMuc());
        values.put(CotMoTa, danhmuc.getMoTa());

        long result = db.insert(BangDanhMuc, null, values );
        db.close();
        return result > 0;
    }
    public boolean deleteDanhMuc(int maDanhMuc){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(BangDanhMuc, "id = ?",new String[]{String.valueOf(maDanhMuc)});

        db.close();
        return result > 0;
    }
    public boolean updateDanhMuc(DanhMucModel danhMuc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CotTenDanhMuc, danhMuc.getTenDanhMuc());
        values.put(CotMoTa, danhMuc.getMoTa());

        int result = db.update(BangDanhMuc, values, "id = ?", new String[]{String.valueOf(danhMuc.getId())});
        db.close();
        return result > 0;
    }

    public List<ProductModel> getAllProduct(){
        List<ProductModel> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BangSanPham + " WHERE isDeleted = 0", null);

        if (cursor.moveToFirst()){
            do {
                 ProductModel product = new ProductModel(
                        cursor.getInt(0), // id
                        cursor.getString(1), // maSanPham
                        cursor.getString(2), // tenSanPham
                        cursor.getInt(3), // donGia
                        cursor.getString(4), //donViTinh
                        cursor.getInt(5), // soLuon
                        cursor.getInt(6) == 1,
                        cursor.getString(7)
                );
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return productList;
    }

    public List<CustomerModel> getAllCustomer(){
        List<CustomerModel> customerList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + BangKhachHang + " WHERE isActive = 1", null);

        if(cursor.moveToFirst()){
            do{
                CustomerModel customer = new CustomerModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8) ==  1,
                        cursor.getString(9)
                );
                customerList.add(customer);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customerList;
    }

}
