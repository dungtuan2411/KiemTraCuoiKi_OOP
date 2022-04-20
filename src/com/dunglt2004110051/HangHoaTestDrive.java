package com.dunglt2004110051;

import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // hỏi người dùng xài list có sẵn hay list rỗng
        System.out.println("Ban muon dung danh sach co san hay tao danh sach moi?");
        System.out.println("1. Tao danh sach moi");
        System.out.println("2. Dung danh sach co san");
        System.out.print("Ban chon: ");
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

                if (choice <= 0 || choice > 2) {
                    System.out.println("Khong hop le! Chi nhap trong khoang [1 - 2] !");
                    timesValidate++;
                } else {
                    switch (choice) {
                        case 1: {
                            ListHangHoa danhSachHangHoa = new ListHangHoa();
                            menu(scanner, danhSachHangHoa);
                            break;
                        }
                        case 2: {
                            ListHangHoa danhSachHangHoa = new ListHangHoa();
                            danhSachHangHoa.readListFromFile();
                            menu(scanner, danhSachHangHoa);
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

    public static void menu(Scanner scanner, ListHangHoa danhSachHangHoa) {
        int choice;
        do {
            System.out.println("\n1. Them hang hoa");
            System.out.println("2. Xuat danh sach hang hoa");
            System.out.println("3. Sap xep danh sach");
            System.out.println("4. Luu danh sach vao file");
            System.out.println("5. Tim kiem");
            System.out.println("6. Xoa hang hoa");
            System.out.println("7. Sua hang hoa");
            System.out.println("8. Danh gia muc do ban buon");
            System.out.println("0. Ket thuc");
            System.out.print("Ban chon: ");

            String input = scanner.nextLine();

            boolean valid = false;
            int timesValidate = 0;

            while (!valid) {
                if (timesValidate > 0) {
                    System.out.print("\tNhap lai: ");
                    input = scanner.nextLine();
                }
                try {
                    choice = Integer.parseInt(input);

                    if (choice < 0 || choice > 9) {
                        System.out.println("Khong hop le! Chi nhap trong khoang [0 - 9] !");
                        timesValidate++;
                    } else {
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
                                    scanner.nextLine();
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
                                danhSachHangHoa.timKiemHangHoa(danhSachHangHoa.getListHangHoa(), scanner);
                                break;
                            }
                            case 6: {
                                danhSachHangHoa.xoaHangHoa(danhSachHangHoa.getListHangHoa(), scanner);
                                break;
                            }
                            case 7: {
                                danhSachHangHoa.suaHangHoa(scanner);
                                break;
                            }
                            case 8: {
                                danhSachHangHoa.danhGiaMucBan(scanner);
                                break;
                            }
                            case 0: {
                                System.out.println("Ket thuc!");
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
            choice = Integer.parseInt(input);
        } while (choice != 0);

    }
}
