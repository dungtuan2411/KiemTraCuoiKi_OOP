package com.dunglt2004110051;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HangSanhSu extends HangHoa {
    // attributes
    private String nhaSanXuat;
    private Date ngayNhapKho;

    // constructor
    public HangSanhSu() {
    }

    public HangSanhSu(String maGD, String tenHang, String soLuongTonKho,
            String donGia, String nhaSanXuat,
            String ngayNhapKho) {
        super(maGD, tenHang, soLuongTonKho, donGia);
        this.setNhaSanXuat(nhaSanXuat);
        this.setNgayNhapKho(ngayNhapKho);
    }

    // getter setter
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = validate.validateString("\tNhap lai: ",
                "Nha san xuat khong duoc rong", nhaSanXuat);
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(String ngayNhapKho) {
        this.ngayNhapKho = validate.validateDate("\tNhap lai: ",
                "Sai dinh dang (dd/MM/yyyy)", ngayNhapKho);
    }

    // methods
    // mức độ bán buôn hàng sành sứ
    @Override
    protected String danhGiaMucDoBanBuon() {
        /**
         * Hàng sành sứ, nếu số lượng tồn kho >50 và thời gian lưu kho >10 ngày thì
         * đánh giá là bán chậm.
         */
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -10);

        Date tenDaysAgo = calendar.getTime();

        if (this.getSoLuongTonKho() > 50 && this.getNgayNhapKho().before(tenDaysAgo)) {
            return "Ban cham";
        }

        return "Khong danh gia!";
    }

    // nhập
    @Override
    public void nhap(List<HangHoa> lstHanghoa, Scanner scanner) {
        super.nhap(lstHanghoa, scanner);
        System.out.print("Nha san xuat: ");
        this.setNhaSanXuat(scanner.nextLine());

        System.out.print("Ngay nhap kho: ");
        this.setNgayNhapKho(scanner.nextLine());
    }

    // xuất
    @Override
    public String toString() {
        SimpleDateFormat ngayVietNam = new SimpleDateFormat("dd/MM/yyyy");

        String nsx = "n/a";
        String hsd = "n/a";
        String nhaCungCap = "n/a";
        String tgianBaoHanh = "n/a";
        String congSuat = "n/a";

        return super.toString() + String.format("%15s %15s %15s %15s %15s %20s %15s %15.1f",
                nsx, hsd, nhaCungCap, tgianBaoHanh, congSuat,
                this.getNhaSanXuat(), ngayVietNam.format(this.getNgayNhapKho()), this.tinhVAT());
    }

    // sửa
    public void setNhaSanXuatSua(Scanner scanner, String nhaSanXuat) {
        this.nhaSanXuat = validate.validateFixedString(scanner, "\tNhap lai: ",
                "Nha san xuat khong duoc rong", nhaSanXuat);
    }

    public void setNgayNhapKhoSua(Scanner scanner, String ngayNhapKho) {
        this.ngayNhapKho = validate.validateFixedDate(scanner, "\tNhap lai: ",
                "Sai dinh dang (dd/MM/yyyy)", ngayNhapKho);
    }

    @Override
    protected void sua(List<HangHoa> lstHanghoa, Scanner scanner) {
        super.sua(lstHanghoa, scanner);
        System.out.print("Sua nha san xuat: ");
        this.setNhaSanXuatSua(scanner, scanner.nextLine());

        System.out.print("Sua ngay nhap kho: ");
        this.setNgayNhapKhoSua(scanner, scanner.nextLine());
    }

    // tính VAT
    private double tinhVATHangSanhSu() {
        double vat = this.getDonGia() * 0.1;
        return vat;
    }

    @Override
    protected double tinhVAT() {
        // Biết rằng VAT của hàng điện máy và sành sứ là 10%
        return this.tinhVATHangSanhSu();
    }
}
