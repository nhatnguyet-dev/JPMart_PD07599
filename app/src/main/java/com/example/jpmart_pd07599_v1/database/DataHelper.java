package com.example.jpmart_pd07599_v1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jpmart_pd07599_v1.model.DanhMucModel;
import com.example.jpmart_pd07599_v1.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "JPMart_DB";
    private static final int DB_Version = 3;
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
//    San Pham
    public static final String BangSanPham = "SanPham";
    public static final String CotMaSanPham = "maSanPham";
    public static final String CotTenSanPham = "tenSanPham";
    public static final String CotDonGia = "donGia";
    public static final String CotDonViTinh = "donViTinh";
    public static final String CotSoLuong = "soLuong";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TaoBangDanhMuc = "CREATE TABLE IF NOT EXISTS " + BangDanhMuc +
            " ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
            CotMaDanhMuc + " TEXT UNIQUE, " +
            CotTenDanhMuc + " TEXT NOT NULL, " +
            CotMoTa + " TEXT, " +
            CotXoaMem + " INTEGER DEFAULT 0, " +
            CotNgayKhoiTao + " DATETIME DEFAULT (datetime('now','localtime'))" +
            ")";

        String TaoBangNhanVien = "CREATE TABLE IF NOT EXISTS " + BangNhanVien +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaNhanVien + " TEXT UNIQUE, " +
                CotTenNhanVien + " TEXT NOT NULL, "+
                CotMatKhauNhanVien + " TEXT, " +
                CotGioiTinh + " INTEGER DEFAULT 0, "+
                CotNgaySinh + " DATETIME DEFAULT (datetime('now','localtime'))," +
                CotSoDienThoai + " TEXT," +
                CotEmail + "TEXT, "+
                CotDiaChi + "TEXT, "+
                CotChucVu + "INTEGER DEFAULT 0, "+
                CotNgayKhoiTao + "DATETIME DEFAULT (datetime('now','localtime'))," +
                CotHoatDong + "INTEGER DEFAULT 1," +
                CotMoTa + "TEXT" + ") ";

        String TaoBangSanPham = "CREATE TABLE IF NOT EXISTS " + BangSanPham +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CotMaSanPham + " TEXT UNIQUE, " +
                CotTenSanPham + " TEXT NOT NULL, "+
                CotDonGia + " INTEGER NOT NULL, "+
                CotDonViTinh + " TEXT NOT NULL, " +
                CotSoLuong + " INTEGER NOT NULL, "+
                CotNgayKhoiTao + "DATETIME DEFAULT (datetime('now','localtime'))," +
                CotXoaMem + " INTEGER DEFAULT 0, " +
                CotMoTa + "TEXT" + ") ";

        sqLiteDatabase.execSQL(TaoBangSanPham);
        sqLiteDatabase.execSQL(TaoBangDanhMuc);
        sqLiteDatabase.execSQL(TaoBangNhanVien);
        insertDefaultCategory(sqLiteDatabase);
        insertDefaultProduct(sqLiteDatabase);
    }
    // Hàm chèn danh mục mặc định
    private void insertDefaultCategory(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        // Thêm danh mục mặc định 1: Thực phẩm
        values.put(CotMaDanhMuc, "DM001");
        values.put(CotTenDanhMuc, "Thực phẩm");
        values.put(CotMoTa, "Thực phẩm đóng gói, mì ăn liền, gia vị từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 2: Đồ uống
        values.put(CotMaDanhMuc, "DM002");
        values.put(CotTenDanhMuc, "Đồ uống");
        values.put(CotMoTa, "Nước ngọt, trà, cà phê, rượu sake Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 3: Mỹ phẩm
        values.put(CotMaDanhMuc, "DM003");
        values.put(CotTenDanhMuc, "Mỹ phẩm");
        values.put(CotMoTa, "Sản phẩm chăm sóc da, trang điểm từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 4: Đồ gia dụng
        values.put(CotMaDanhMuc, "DM004");
        values.put(CotTenDanhMuc, "Đồ gia dụng");
        values.put(CotMoTa, "Dụng cụ nhà bếp, đồ dùng sinh hoạt Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 5: Thời trang
        values.put(CotMaDanhMuc, "DM005");
        values.put(CotTenDanhMuc, "Thời trang");
        values.put(CotMoTa, "Quần áo, phụ kiện thời trang từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 6: Điện tử
        values.put(CotMaDanhMuc, "DM006");
        values.put(CotTenDanhMuc, "Điện tử");
        values.put(CotMoTa, "Thiết bị điện tử, công nghệ từ Nhật Bản");
        db.insert(BangDanhMuc, null, values);
        values.clear();

        // Thêm danh mục mặc định 7: Sức khỏe
        values.put(CotMaDanhMuc, "DM007");
        values.put(CotTenDanhMuc, "Sức khỏe");
        values.put(CotMoTa, "Thực phẩm chức năng, thuốc không kê đơn từ Nhật");
        db.insert(BangDanhMuc, null, values);
    }

//    Hàm chèn sản phẩm mặc định
    private void insertDefaultProduct(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(CotMaSanPham, "SP001");
        values.put(CotTenSanPham, "Mì ramen Nhật Bản");
        values.put(CotDonGia, 25000);
        values.put(CotDonViTinh, "Gói");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP002");
        values.put(CotTenSanPham, "Trà xanh Matcha");
        values.put(CotDonGia, 150000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP003");
        values.put(CotTenSanPham, "Nước tương Kikkoman");
        values.put(CotDonGia, 45000);
        values.put(CotDonViTinh, "Chai");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP004");
        values.put(CotTenSanPham, "Rượu Sake Ozeki");
        values.put(CotDonGia, 350000);
        values.put(CotDonViTinh, "Chai");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP005");
        values.put(CotTenSanPham, "Mặt nạ Senka");
        values.put(CotDonGia, 85000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP006");
        values.put(CotTenSanPham, "Kem chống nắng Anessa");
        values.put(CotDonGia, 380000);
        values.put(CotDonViTinh, "Tuýp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP007");
        values.put(CotTenSanPham, "Dao nhà bếp Kai");
        values.put(CotDonGia, 250000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP008");
        values.put(CotTenSanPham, "Bát sứ Nhật");
        values.put(CotDonGia, 120000);
        values.put(CotDonViTinh, "Bộ");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP009");
        values.put(CotTenSanPham, "Áo thun Uniqlo");
        values.put(CotDonGia, 199000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP010");
        values.put(CotTenSanPham, "Tai nghe Sony WH-1000XM4");
        values.put(CotDonGia, 7500000);
        values.put(CotDonViTinh, "Cái");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP011");
        values.put(CotTenSanPham, "Viên uống Collagen DHC");
        values.put(CotDonGia, 320000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
        values.clear();

        values.put(CotMaSanPham, "SP012");
        values.put(CotTenSanPham, "Kẹo Kit Kat Matcha");
        values.put(CotDonGia, 65000);
        values.put(CotDonViTinh, "Hộp");
        values.put(CotSoLuong, 50);
        db.insert(BangSanPham, null, values);
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
}
