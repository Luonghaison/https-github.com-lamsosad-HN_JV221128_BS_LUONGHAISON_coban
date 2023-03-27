package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách\n" +
                    "7. Thoát");
            System.out.println("Nhập vào đây lựa chọn của bạn: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    createBook(bookList, input);
                    break;
                case 2:
                    displayListBook(bookList);
                    break;
                case 3:
                    sortinterest(bookList);
                    break;
                case 4:
                    deleteBook(bookList, input);
                    break;
                case 5:
                    searchByBookName(bookList, input);
                    break;
                case 6:
                    //trường hợp 6 em chưa biết mình sai logic chỗ nào,hết giờ làm bài nên em khóa lại ạ
//                    chanceBookStatus(bookList,input);
                    break;
                case 7:
                    System.out.println("Thoát khỏi chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bạn đã nhập sai !!!");
                    break;
            }
        }
    }

    public static void createBook(List<Book> list, Scanner scanner) {
        System.out.println("Nhập vào đây số lượng sách bạn muốn thêm mới: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhap sach thu: " + (i + 1));
            Book newBook = new Book();
            newBook.inputData(scanner, list);
            if (list.size() == 0) {
                newBook.setBookId(1);
            } else {
                newBook.setBookId(list.get(list.size() - 1).getBookId() + 1);
            }
            list.add(newBook);
        }
        System.out.println("Them mới sách thành công,danh sách mới của bạn là: ");
        displayListBook(list);
    }

    public static void displayListBook(List<Book> list) {
        for (Book book : list
        ) {
            book.displayData();
        }
    }

    public static void sortinterest(List<Book> list) {
        Collections.sort(list);
        displayListBook(list);
    }

    public static void deleteBook(List<Book> list, Scanner scanner) {
        System.out.println("Nhập Id sách mà bạn muốn xóa: ");
        int deleteId = scanner.nextInt();
        list.remove(deleteId);
        System.out.println("Danh sách sau khi xóa: ");
        displayListBook(list);
    }

    public static void searchByBookName(List<Book> list, Scanner scanner) {
        System.out.println("Nhập tên sách cần tìm kiếm: ");
        String searchName = scanner.nextLine();
        List<Book> listSearch = new ArrayList<>();
        for (Book book : list) {
            if (book.getBookName().contains(searchName)) {
                listSearch.add(book);
                System.out.println("Danh sach tim kiem la:");
                displayListBook(listSearch);
            }
        }
    }

//    public static void chanceBookStatus(List<Book> list, Scanner scanner) {
//        System.out.println("Nhập tên mã sách mà bạn muốn thay đổi:");
//        int chanceId = scanner.nextInt();
//        for (Book id : list) {
//            if (id.getBookId() == chanceId) {
//                id.isBookStatus() = !id.isBookStatus();
//            }
//        }
//        System.out.println("List sau khi thay đổi: ");
//        displayListBook(list);
//    }


}
