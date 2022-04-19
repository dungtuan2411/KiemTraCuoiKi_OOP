package com.dunglt2004110051;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public abstract class HangHoa implements Serializable {
    // attributes
    protected String maGD, tenHang;
    protected int soLuongTonKho;
    protected double donGia;
    // message
    protected ValidateInterface validate;

    private static final long serialVersionUID = 2896143615790145328L;

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
    protected abstract String danhGiaMucDoBanBuon(); // hợp đồng

    // nhập
    public void nhap(List<HangHoa> lstHanghoa, Scanner scanner) {
        boolean isDuplicated = true;
        String maGDScanner;
        String copy = null;
        do {
            System.out.print("Nhap ma hang: ");
            maGDScanner = scanner.nextLine();

            String maGD = validate.validateString("\tNhap lai: ",
                    "Ma giao dich khong duoc de trong !", maGDScanner);

            isDuplicated = lstHanghoa.stream().anyMatch(hh -> hh.getMaGD().equals(maGD));

            if (isDuplicated) {
                System.out.println("Ma GD bi trung! Nhap lai!");
                continue;
            }

            copy = maGD;

        } while (isDuplicated);

        // System.out.print("Nhap ma hang: ");
        // this.setMaGD(scanner.nextLine());
        this.setMaGD(copy);

        System.out.print("Nhap ten hang: ");
        this.setTenHang(scanner.nextLine());

        System.out.print("So luong ton kho: ");
        this.setSoLuongTonKho(scanner.nextLine());

        System.out.print("Don gia: ");
        this.setDonGia(scanner.nextLine());
    }

    // nhập
    protected void sua(List<HangHoa> lstHanghoa, Scanner scanner) {
        // không được sửa mã giao dịch
        System.out.print("Sua ten hang: ");
        this.setTenHang(scanner.nextLine());

        System.out.print("Sua so luong ton kho: ");
        this.setSoLuongTonKho(scanner.nextLine());

        System.out.print("Sua don gia: ");
        this.setDonGia(scanner.nextLine());
    }

    // xuất
    @Override
    public String toString() {
        return String.format("%-8s %15s %10d %20.1f", this.maGD, this.tenHang, this.soLuongTonKho, this.donGia);
    }
}
