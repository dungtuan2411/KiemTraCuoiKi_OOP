package com.dunglt2004110051;

import java.util.Date;

public interface ValidateInterface {
    public String validateString(String message, String errorMessage, String input);

    public int validateInteger(String message, String errorMessage, String input, String property);

    public double validateDouble(String message, String errorMessage, String input, String property);

    public Date validateDate(String message, String errorMsg, String input);
}
