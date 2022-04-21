package com.dunglt2004110051;

import java.util.Comparator;

public class SortByID implements Comparator<HangHoa> {

    @Override
    public int compare(HangHoa h1, HangHoa h2) {
        return h1.getMaGD().compareToIgnoreCase(h2.getMaGD());
    }

}