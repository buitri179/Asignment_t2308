import java.util.ArrayList;

public class ArticleController {
    private ArrayList<ArticleInfor> articles;

    public ArticleController() {
        articles = new ArrayList<>();
    }

    public void addArticle(ArticleInfor article) {
        articles.add(article);
    }

    public void displayArticles() {
        if (articles.isEmpty()) {
            System.out.println("Không có bài viết nào trong danh sách.");
        } else {
            for (ArticleInfor article : articles) {
                System.out.println(article);
            }
        }
    }

    public ArticleInfor searchArticleById(String id) {
        for (ArticleInfor article : articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    public boolean removeArticleById(String id) {
        ArticleInfor article = searchArticleById(id);
        if (article != null) {
            articles.remove(article);
            return true;
        }
        return false;
    }
}