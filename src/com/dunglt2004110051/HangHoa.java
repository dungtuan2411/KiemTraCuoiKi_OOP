package com.dunglt2004110051;

import java.util.Scanner;

public abstract class HangHoa {
    // attributes
    protected String maGD, tenHang;
    protected int soLuongTonKho;
    protected double donGia;
    // message
    protected ValidateInterface validate;

    // getter setter
    public String getMaGD() {
        return maGD;
    }

    private void setMaGD(String maGD) {
        this.maGD = validate.validateString("\t Nhap lai: ",
                "Ma giao dich khong duoc de trong !", maGD);
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = validate.validateString("\t Nhap lai: ", "Ten hang khong duoc de trong !", tenHang);
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(String soLuongTonKho) {
        this.soLuongTonKho = validate.validateInteger("\t Nhap lai: ",
                "Khong hop le! So luong ton kho la so nguyen!", soLuongTonKho, "so luong ton kho");
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = validate.validateDouble("\t Nhap lai: ",
                "Khong hop le! Don gia la so thuc (VD: 5.5)!", donGia, "Don gia");
    }

    // constructor
    public HangHoa() {
        validate = new ValidateImplementation();
    }

    public HangHoa(String maGD, String tenHang, String soLuongTonKho, String donGia) {
        validate = new ValidateImplementation();
        this.setMaGD(maGD);
        this.setTenHang(tenHang);
        this.setSoLuongTonKho(soLuongTonKho);
        this.setDonGia(donGia);
    }

    // methods
    protected abstract void danhGiaMucDoBanBuon(); // hợp đồng

    // nhập
    public void nhap(Scanner scanner) {
        System.out.print("Nhap ma hang: ");
        this.setMaGD(scanner.nextLine());

        System.out.print("Nhap ten hang: ");
        this.setTenHang(scanner.nextLine());

        System.out.print("So luong: ");
        this.setSoLuongTonKho(scanner.nextLine());

        System.out.print("Don gia: ");
        this.setDonGia(scanner.nextLine());
    }

    // xuất
    @Override
    public String toString() {
        return String.format("%-8s %20s %10d %20.1f", this.maGD, this.tenHang, this.soLuongTonKho, this.donGia);
    }
}
