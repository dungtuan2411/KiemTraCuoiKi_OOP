package com.dunglt2004110051;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListHangHoa {
    private List<HangHoa> listHangHoa;

    public ListHangHoa() {
        listHangHoa = new ArrayList<>();
    }

    public void themHangHoa(Scanner scanner) {

        // test print
        // HangHoa hangHoa1 = new HangThucPham("tp01", "banh trung thu", "2", "80000",
        // "15/04/2022", "16/05/2022",
        // "kinh do");

        // HangHoa hangHoa2 = new HangDienMay("dm01", " may lanh", "3", "1969000", "36",
        // "16");

        // HangHoa hangHoa3 = new HangSanhSu("ss01", "gom minh long", "8", "65000.00",
        // "minh long", "10/02/2013");

        // listHangHoa.add(hangHoa1);
        // listHangHoa.add(hangHoa2);
        // listHangHoa.add(hangHoa3);

        System.out.println("Ban muon nhap loai hang hoa nao?");
        System.out.println("1. Hang thuc pham");
        System.out.println("2. Hang dien may");
        System.out.println("3. Hang sanh su");
        System.out.print("Ban chon: ");
        scanner.nextLine();
        String input = scanner.nextLine();

        boolean valid = false;
        int timesValidate = 0;
        int choice;

        while (!valid) {
            if (timesValidate > 0) {
                System.out.print("\tNhap lai: ");
                input = scanner.nextLine();
            }
            try {
                choice = Integer.parseInt(input);

                if (choice <= 0 || choice > 3) {
                    System.out.println("Khong hop le! Chi nhap trong khoang [1 - 3] !");
                    timesValidate++;
                } else {
                    switch (choice) {
                        case 1: {
                            HangHoa hangHoa = new HangThucPham();
                            hangHoa.nhap(scanner);
                            listHangHoa.add(hangHoa);
                            break;
                        }
                        case 2: {
                            HangHoa hangHoa = new HangDienMay();
                            hangHoa.nhap(scanner);
                            listHangHoa.add(hangHoa);
                            break;
                        }
                        case 3: {
                            HangHoa hangHoa = new HangSanhSu();
                            hangHoa.nhap(scanner);
                            listHangHoa.add(hangHoa);
                            break;
                        }
                        default:
                            break;
                    }
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Khong hop le! Vui long nhap so nguyen!");
                timesValidate++;
            }
        }

    }

    public void xuatDanhSach() {
        if (listHangHoa.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("\nDanh sách hàng hóa");
        System.out.printf("%-8s %15s %20s %13s %15s %15s %15s %20s %13s %15s %15s\n",
                "Ma hang", "Ten hang", "So luong ton", "Don gia",
                "Ngay san xuat", "Ngay het han", "Nha cung cap", "Thoi gian bao hanh",
                "Cong suat", "Nha san xuat", "Ngay nhap kho");
        String line = "========================================";
        line += "========================================";
        line += "========================================";
        line += "========================================";
        line += "=============";
        System.out.println(line);
        for (int i = 0; i < listHangHoa.size(); i++) {
            System.out.println(listHangHoa.get(i));
        }
    }
}
