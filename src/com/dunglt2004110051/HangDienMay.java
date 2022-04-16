package com.dunglt2004110051;

import java.util.Scanner;

public class HangDienMay extends HangHoa {
    // attributes
    private int thoiGianBaoHanh, congSuat;

    // constructor
    public HangDienMay() {
    }

    public HangDienMay(String maGD, String tenHang, String soLuongTonKho,
            String donGia,
            String thoiGianBaoHanh,
            String congSuat) {
        super(maGD, tenHang, soLuongTonKho, donGia);
        this.setThoiGianBaoHanh(thoiGianBaoHanh);
        this.setCongSuat(congSuat);
    }

    // getter setter
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = validate.validateInteger("\tNhap lai: ",
                "Khong hop le! Thoi gian bao hanh la so nguyen!",
                thoiGianBaoHanh, "thoi gian bao hanh");
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = validate.validateInteger("\tNhap lai: ",
                "Khong hop le! Cong suat la so nguyen!",
                congSuat, "cong suat");
    }

    // methods
    // mức độ bán buôn hàng điện máy
    @Override
    protected void danhGiaMucDoBanBuon() {
    }

    // nhập
    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Thoi gian bao hanh: ");
        this.setThoiGianBaoHanh(scanner.nextLine());

        System.out.print("Cong suat: ");
        this.setCongSuat(scanner.nextLine());
    }

    // xuất
    @Override
    public String toString() {
        String nsx = "n/a";
        String hsd = "n/a";
        String nhaCungCap = "n/a";
        String nhaSX = "n/a";
        String ngayNhapKho = "n/a";
        return super.toString() + String.format("%15s %15s %15s %15s %15s %20s %15s",
                nsx, hsd, nhaCungCap,
                this.getThoiGianBaoHanh(), this.getCongSuat(),
                nhaSX, ngayNhapKho);
    }
}
