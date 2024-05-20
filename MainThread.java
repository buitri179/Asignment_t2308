import java.util.Date;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm mới bài viết.");
            System.out.println("2. Hiển thị danh sách bài vừa nhập.");
            System.out.println("3. Tìm kiếm bài viết theo mã.");
            System.out.println("4. Xoá bài viết theo mã.");
            System.out.println("0. Thoát chương trình.");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng newline sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã bài viết: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tiêu đề bài viết: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập mô tả bài viết: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhập URL ảnh đại diện: ");
                    String imageUrl = scanner.nextLine();
                    System.out.print("Nhập nội dung chính: ");
                    String content = scanner.nextLine();
                    System.out.print("Nhập tên tác giả: ");
                    String author = scanner.nextLine();
                    Date date = new Date(); // Lấy ngày hiện tại

                    ArticleInfor newArticle = new ArticleInfor(id, title, description, imageUrl, content, author, date);
                    articleController.addArticle(newArticle);
                    System.out.println("Bài viết đã được thêm thành công!");
                    break;

                case 2:
                    System.out.println("Danh sách bài viết:");
                    articleController.displayArticles();
                    break;

                case 3:
                    System.out.print("Nhập mã bài viết cần tìm: ");
                    String searchId = scanner.nextLine();
                    ArticleInfor foundArticle = articleController.searchArticleById(searchId);
                    if (foundArticle != null) {
                        System.out.println("Bài viết tìm thấy: " + foundArticle);
                    } else {
                        System.out.println("Không tìm thấy bài viết với mã " + searchId);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã bài viết cần xoá: ");
                    String deleteId = scanner.nextLine();
                    ArticleInfor deleteArticle = articleController.searchArticleById(deleteId);
                    if (deleteArticle != null) {
                        System.out.print("Bạn có chắc chắn muốn xoá bài viết này không? (y/n): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("y")) {
                            articleController.removeArticleById(deleteId);
                            System.out.println("Bài viết đã được xoá.");
                        } else {
                            System.out.println("Huỷ bỏ xoá bài viết.");
                        }
                    } else {
                        System.out.println("Không tìm thấy bài viết với mã " + deleteId);
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}