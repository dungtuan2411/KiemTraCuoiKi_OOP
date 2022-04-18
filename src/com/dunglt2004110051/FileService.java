package com.dunglt2004110051;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileService {
    // Ghi list vào file
    public static void writeToFile(List<HangHoa> listHangHoa) {
        try {
            FileOutputStream outFile = new FileOutputStream("data.dat");
            try {
                ObjectOutputStream objOut = new ObjectOutputStream(outFile);

                objOut.writeObject(listHangHoa);

                objOut.flush();
                objOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
            e.printStackTrace();
        }
    }

    // Đọc list từ file
    public static List<HangHoa> readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream inFile = new FileInputStream("data.dat");

        ObjectInputStream objIn = new ObjectInputStream(inFile);

        return (List<HangHoa>) objIn.readObject();
    }
}
