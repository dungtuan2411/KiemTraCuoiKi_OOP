package com.dunglt2004110051;

import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // hỏi người dùng xài list có sẵn hay list rỗng
        ListHangHoa danhSachHangHoa = new ListHangHoa();
        menu(scanner, danhSachHangHoa);
    }

    public static void menu(Scanner scanner, ListHangHoa danhSachHangHoa) {
        int choice;
        do {
            System.out.println("\n1. Them hang hoa");
            System.out.println("2. Xuat danh sach hang hoa");
            System.out.println("3. Sap xep danh sach");
            System.out.println("4. Ghi danh sach vao file");
            System.out.println("5. Doc danh sach tu file");
            System.out.println("6. Tim kiem");
            System.out.print("Ban chon: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    char confirm = 'y';
                    do {
                        if (Character.toUpperCase(confirm) == 'Y') {
                            danhSachHangHoa.themHangHoa(scanner);
                        } else {
                            System.out.println("Sai cu phap! Chon y hoac n");
                        }
                        System.out.print("Nhap them (Y/N)?: ");
                        confirm = scanner.next().charAt(0);
                    } while (Character.toUpperCase(confirm) != 'N');
                    break;
                }
                case 2: {
                    danhSachHangHoa.xuatDanhSach();
                    break;
                }
                case 3: {
                    danhSachHangHoa.sapXep();
                    break;
                }
                case 4: {
                    danhSachHangHoa.writeListToFile();
                    break;
                }
                case 5: {
                    danhSachHangHoa.readListFromFile();
                    break;
                }
                case 6: {
                    scanner.nextLine();
                    danhSachHangHoa.timKiemHangHoa(danhSachHangHoa.getListHangHoa(), scanner);
                    break;
                }
                default:
                    break;
            }

        } while (choice != 0);

    }
}
