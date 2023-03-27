package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.List;
import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPage;
    private float importPrice;
    private float exportPrice;

    private float interest;
    private boolean bookStatus;
    public Book(){

    };

    public Book(int bookId, String bookName, String title, int numberOfPage, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPage = numberOfPage;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {

    }

    @Override
    public void inputData(Scanner scanner, List<Book> list) {
        System.out.println("Nhap ten sach: ");
        this.bookName = scanner.nextLine();
        System.out.println("Nhap tieu de: ");
        this.title = scanner.nextLine();
        System.out.println("Nhap so trang: ");
        this.numberOfPage = scanner.nextInt();
        System.out.println("Nhap gia nhap sach: ");
        this.importPrice = scanner.nextInt();
        System.out.println("Nhap giá bán sách:");
        this.exportPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap trang thai sach: ");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
        this.interest = this.exportPrice-this.importPrice;
        System.out.println("Lợi nhuận bán sách: "+interest);


    }



    @Override
    public void displayData() {
        System.out.println("......................");
        System.out.printf("Mã sách: %d\n ",bookId);
        System.out.printf("Tên sách: %s\n ", bookName);
        System.out.printf("Giá bán sách: %.1f\n", exportPrice);
        System.out.printf("Trang thái sách: %s\n", bookStatus?"Còn sách":"Không còn sách để bán");
        System.out.println("..........................");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (o.interest-this.interest);
    }
}
