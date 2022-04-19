package com.dunglt2004110051;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HangThucPham extends HangHoa {
    // attributes
    private Date ngaySanXuat, ngayHetHan;
    private String nhaCungCap;

    // constructor
    public HangThucPham() {
    }

    public HangThucPham(String maGD, String tenHang, String soLuongTonKho,
            String donGia, String ngaySanXuat, String ngayHetHan, String nhaCungCap) {
        super(maGD, tenHang, soLuongTonKho, donGia);

        this.setNgaySanXuat(ngaySanXuat);

        Scanner scanner = new Scanner(System.in);
        this.setNgayHetHan(ngayHetHan, scanner);

        this.setNhaCungCap(nhaCungCap);
    }

    // getter setter
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = validate.validateDate("\tNhap lai: ",
                "Sai dinh dang (dd/MM/yyyy)!",
                ngaySanXuat);
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan, Scanner scanner) {
        Date hetHan = validate.validateDate("\tNhap lai: ",
                "Sai dinh dang (dd/MM/yyyy)!", ngayHetHan);
        while (hetHan.before(this.ngaySanXuat)) {
            System.out.println("Ngay het han phai la hoac sau ngay san xuat!");

            System.out.print("\tNhap lai: ");
            ngayHetHan = scanner.nextLine();

            hetHan = validate.validateDate("\tNhap lai: ",
                    "Sai dinh dang (dd/MM/yyyy)!", ngayHetHan);
        }
        this.ngayHetHan = hetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = validate.validateString("\tNhap lai: ",
                "Nha cung cap khong duoc rong", nhaCungCap);
    }

    // methods
    // nhập
    @Override
    public void nhap(List<HangHoa> lstHanghoa, Scanner scanner) {
        super.nhap(lstHanghoa, scanner);
        System.out.print("Ngay san xuat: ");
        this.setNgaySanXuat(scanner.nextLine());

        System.out.print("Ngay het han: ");
        this.setNgayHetHan(scanner.nextLine(), scanner);

        System.out.print("Nha cung cap: ");
        this.setNhaCungCap(scanner.nextLine());
    }

    // mức độ bán buôn
    // mức độ bán buôn hàng thực phẩm
    @Override
    protected String danhGiaMucDoBanBuon() {
        /**
         * Hàng thực phẩm, nếu vẫn còn tồn kho và bị hết hạn thì đánh giá là
         * khó bán.
         */
        if (this.getSoLuongTonKho() > 0 && this.getNgayHetHan().equals(this.getNgaySanXuat())) {
            return "Kho ban";
        }
        return "Khong danh gia";
    }

    // sửa
    @Override
    public void sua(List<HangHoa> lstHanghoa, Scanner scanner) {
        super.sua(lstHanghoa, scanner);
        System.out.print("Sua ngay san xuat: ");
        this.setNgaySanXuat(scanner.nextLine());

        System.out.print("Sua ngay het han: ");
        this.setNgayHetHan(scanner.nextLine(), scanner);

        System.out.print("Sua nha cung cap: ");
        this.setNhaCungCap(scanner.nextLine());
    }

    // xuất
    @Override
    public String toString() {
        SimpleDateFormat ngayVietNam = new SimpleDateFormat("dd/MM/yyyy");

        String tgianBaoHanh = "n/a";
        String congSuat = "n/a";
        String nhaSX = "n/a";
        String ngayNhapKho = "n/a";
        return super.toString() + String.format("%15s %15s %15s %15s %15s %20s %15s",
                ngayVietNam.format(getNgaySanXuat()), ngayVietNam.format(this.getNgayHetHan()),
                this.getNhaCungCap(), tgianBaoHanh,
                congSuat, nhaSX, ngayNhapKho);
    }
}
