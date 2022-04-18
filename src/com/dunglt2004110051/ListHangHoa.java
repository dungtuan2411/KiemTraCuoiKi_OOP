package com.dunglt2004110051;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListHangHoa {
    // attribute
    private List<HangHoa> listHangHoa;

    public List<HangHoa> getListHangHoa() {
        return listHangHoa;
    }

    // constructor
    public ListHangHoa() {
        listHangHoa = new ArrayList<>();
    }

    // thêm hàng hóa
    public void themHangHoa(Scanner scanner) {
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
                            hangHoa.nhap(listHangHoa, scanner);
                            this.listHangHoa.add(hangHoa);
                            break;
                        }
                        case 2: {
                            HangHoa hangHoa = new HangDienMay();
                            hangHoa.nhap(listHangHoa, scanner);
                            this.listHangHoa.add(hangHoa);
                            break;
                        }
                        case 3: {
                            HangHoa hangHoa = new HangSanhSu();
                            hangHoa.nhap(listHangHoa, scanner);
                            this.listHangHoa.add(hangHoa);
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

    // sắp xếp
    // theo mã
    public List<HangHoa> sapXep() {
        if (listHangHoa.isEmpty()) {
            System.out.println("Danh sach rong!");
            return null;
        }
        Collections.sort(this.listHangHoa, new SortByID());
        return this.listHangHoa;
    }

    // Tìm kiếm
    public HangHoa binarySearch(List<HangHoa> lstHanghoa, String maGD, int l, int r) {
        // base case
        if (l > r) {
            return null;
        }

        // tìm index ở giữa
        int mid = (l + r) / 2;

        // so sánh mid và maGD, trả về 1 số int
        /**
         * nếu result > 0 => mid ở sau maGD(phải) => tìm ở nửa trái
         * nếu result < 0 => mid ở trước maGD(trái) => tìm ở nửa phải
         * nếu result == 0 => tìm thấy
         */
        int result = listHangHoa.get(mid).getMaGD().compareToIgnoreCase(maGD);

        if (result == 0) {
            return listHangHoa.get(mid);
        } else if (result > 0) {
            // tìm ở nửa trái
            return binarySearch(lstHanghoa, maGD, l, mid - 1);
        } else {
            // tìm ở nửa phải
            return binarySearch(lstHanghoa, maGD, mid + 1, r);
        }
    }

    public void timKiemHangHoa(List<HangHoa> lstHanghoa, Scanner scanner) {
        if (listHangHoa.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.print("Nhap ma cua giao dich can tim: ");
        String maGD = scanner.nextLine();
        // sắp xếp hàng hóa theo mã
        lstHanghoa = this.sapXep();

        HangHoa foundProduct = binarySearch(lstHanghoa, maGD, 0, lstHanghoa.size() -
                1);

        if (foundProduct == null) {
            System.out.println("Khong tim thay!");
        } else {
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
            System.out.println(foundProduct);
        }
    }

    // xuất danh sách
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

    // Đọc và ghi file
    public void writeListToFile() {
        FileService.writeToFile(listHangHoa);
    }

    public void readListFromFile() {
        try {
            listHangHoa = FileService.readFromFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
