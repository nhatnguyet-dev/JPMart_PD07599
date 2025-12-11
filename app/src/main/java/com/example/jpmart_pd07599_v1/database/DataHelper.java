package com.example.jpmart_pd07599_v1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jpmart_pd07599_v1.model.DanhMucModel;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DB_Name = "JPMart_DB";
    private static final int DB_Version = 2;
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

        sqLiteDatabase.execSQL(TaoBangDanhMuc);
        sqLiteDatabase.execSQL(TaoBangNhanVien);
        insertDefaultCategory(sqLiteDatabase);
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
}
