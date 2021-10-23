package ru.kpfu.itis.bagautdinov.model;

public class Homework {
    private int id;
    private int userId;
    private String title;
    private String article;

    public Homework(int id, int userId, String title, String article) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.article = article;
    }

    public Homework(int userId, String title, String article) {
        this.userId = userId;
        this.title = title;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
