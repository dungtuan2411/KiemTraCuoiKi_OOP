package com.dunglt2004110051;

import java.util.Date;
import java.util.Scanner;

public interface ValidateInterface {
    public String validateString(String message, String errorMessage, String input);

    public int validateInteger(String message, String errorMessage, String input, String property);

    public double validateDouble(String message, String errorMessage, String input, String property);

    public Date validateDate(String message, String errorMsg, String input);

    // sửa
    public String validateFixedString(Scanner scanner, String message, String errorMessage, String input);

    public int validateFixedInteger(Scanner scanner, String message, String errorMessage, String input,
            String property);

    public double validateFixedDouble(Scanner scanner, String message, String errorMessage, String input,
            String property);

    public Date validateFixedDate(Scanner scanner, String message, String errorMsg, String input);

}
