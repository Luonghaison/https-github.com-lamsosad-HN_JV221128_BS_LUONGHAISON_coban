package ra.bussiness;

import ra.bussinessImp.Book;

import java.util.List;
import java.util.Scanner;

public interface IBook {
    void inputData();

    void inputData(Scanner scanner, List<Book> list);

    void displayData();
}
