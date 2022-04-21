package com.dunglt2004110051;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValidateImplementation implements ValidateInterface, Serializable {
    // transient khắc phục lỗi java.io.NotSerializableException: java.util.Scanner
    private transient Scanner scanner;

    public ValidateImplementation() {
        scanner = new Scanner(System.in);
    }

    // Kiểm tra chuỗi
    private boolean checkSpecial(String testCase) {
        if (testCase.matches("[\\w\\d\\s]+")) {
            return true;
        }
        return false;
    }

    public String validateString(String message, String errorMessage, String input) {
        boolean valid = false;
        int timesValidate = 0;
        String result = null;

        // Không được rỗng và không chứa ký tự đặc biệt VD: ,@#$%^&
        while (valid == false) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            result = input;

            if (result.trim().isEmpty()) {
                System.out.println(errorMessage);
                timesValidate++;
            } else {
                if (!checkSpecial(result)) {
                    System.out.println("Khong duoc chua ky tu dac biet !");
                    timesValidate++;
                } else {
                    valid = true;
                }
            }
        }

        return result;
    }

    // kiểm tra số nguyên
    public int validateInteger(String message, String errorMessage, String input, String property) {
        boolean valid = false;
        int timesValidate = 0;
        int num = 0;

        while (!valid) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                num = Integer.parseInt(input);
                /**
                 * có 2 trường hợp xảy ra nếu số người dùng nhập hợp lệ:
                 * 1. số lượng tồn và thời gian bảo hành cho phép >= 0
                 * 2. công suất chỉ cho phép > 0
                 */

                if (property.trim().equalsIgnoreCase("so luong ton kho") ||
                        property.trim().equalsIgnoreCase("thoi gian bao hanh")) {
                    if (num >= 0) {
                        valid = true;
                        continue;
                    } else {
                        System.out.println(property + " khong duoc la so am !");
                        timesValidate++;
                    }
                } else if (property.trim().equalsIgnoreCase("cong suat")) {
                    if (num > 0) {
                        valid = true;
                        continue;
                    } else {
                        System.out.println(property + " phai > 0 !");
                        timesValidate++;
                    }
                } else {
                    System.out.println(property + " khong hop le !");
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                timesValidate++;
            }
        }
        return num;
    }

    // kiểm tra số thực
    public double validateDouble(String message, String errorMessage, String input, String property) {
        boolean valid = false;
        int timesValidate = 0;
        double num = 0;

        while (!valid) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                num = Double.parseDouble(input);
                if (num > 0) {
                    valid = true;
                } else {
                    System.out.println(property + " khong duoc la so am !");
                    timesValidate++;
                }

            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                timesValidate++;
            }
        }
        return num;
    }

    // kiểm tra ngày
    public Date validateDate(String message, String errorMsg, String input) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        boolean valid = false;
        int timesValidate = 0;

        Date date = null;

        while (valid == false) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                date = format.parse(input);
                valid = true;
            } catch (ParseException e) {
                // Nếu ngày nhập vào sai định dạng "dd/MM/yyyy"
                System.out.println(errorMsg);
                timesValidate++;
            }
        }
        return date;
    }

    // Kiểm tra chuỗi khi sửa
    @Override
    public String validateFixedString(Scanner scanner, String message, String errorMessage, String input) {
        boolean valid = false;
        int timesValidate = 0;
        String result = null;

        // Không được rỗng và không chứa ký tự đặc biệt VD: ,@#$%^&
        while (valid == false) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            result = input;

            if (result.trim().isEmpty()) {
                System.out.println(errorMessage);
                timesValidate++;
            } else {
                if (!checkSpecial(result)) {
                    System.out.println("Khong duoc chua ky tu dac biet !");
                    timesValidate++;
                } else {
                    valid = true;
                }
            }
        }

        return result;
    }

    // kiểm tra số nguyên khi sửa
    @Override
    public int validateFixedInteger(Scanner scanner, String message, String errorMessage, String input,
            String property) {
        boolean valid = false;
        int timesValidate = 0;
        int num = 0;

        while (!valid) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                num = Integer.parseInt(input);
                if (property.trim().equalsIgnoreCase("so luong ton kho") ||
                        property.trim().equalsIgnoreCase("thoi gian bao hanh")) {
                    if (num >= 0) {
                        valid = true;
                        continue;
                    } else {
                        System.out.println(property + " khong duoc la so am !");
                        timesValidate++;
                    }
                } else if (property.trim().equalsIgnoreCase("cong suat")) {
                    if (num > 0) {
                        valid = true;
                        continue;
                    } else {
                        System.out.println(property + " phai > 0 !");
                        timesValidate++;
                    }
                } else {
                    System.out.println(property + " khong hop le !");
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                timesValidate++;
            }
        }
        return num;
    }

    // kiểm tra số thực khi sửa
    @Override
    public double validateFixedDouble(Scanner scanner, String message, String errorMessage, String input,
            String property) {
        boolean valid = false;
        int timesValidate = 0;
        double num = 0;

        while (!valid) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                num = Double.parseDouble(input);
                if (num > 0) {
                    valid = true;
                } else {
                    System.out.println(property + " khong duoc la so am !");
                    timesValidate++;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
                timesValidate++;
            }
        }
        return num;
    }

    // kiểm tra ngày khi sửa
    @Override
    public Date validateFixedDate(Scanner scanner, String message, String errorMsg, String input) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        boolean valid = false;
        int timesValidate = 0;

        Date date = null;

        while (valid == false) {
            if (timesValidate > 0) {
                System.out.print(message);
                input = scanner.nextLine();
            }
            try {
                date = format.parse(input);
                valid = true;
            } catch (ParseException e) {
                // Nếu ngày nhập vào sai định dạng "dd/MM/yyyy"
                System.out.println(errorMsg);
                timesValidate++;
            }
        }
        return date;
    }

}
