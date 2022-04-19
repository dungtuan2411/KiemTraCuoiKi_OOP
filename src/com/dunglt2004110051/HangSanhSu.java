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

        return super.toString() + String.format("%15s %15s %15s %15s %15s %20s %15s",
                nsx, hsd, nhaCungCap, tgianBaoHanh, congSuat,
                this.getNhaSanXuat(), ngayVietNam.format(this.getNgayNhapKho()));
    }

    // sửa
    @Override
    protected void sua(List<HangHoa> lstHanghoa, Scanner scanner) {
        super.sua(lstHanghoa, scanner);
        System.out.print("Sua nha san xuat: ");
        this.setNhaSanXuat(scanner.nextLine());

        System.out.print("Sua ngay nhap kho: ");
        this.setNgayNhapKho(scanner.nextLine());
    }
}
