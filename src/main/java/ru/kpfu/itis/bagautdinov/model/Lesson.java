package ru.kpfu.itis.bagautdinov.model;

public class Lesson {
    private int id;
    private String title;
    private String description;
    private String article;
    private String link;
    private String photoTitle;

    public Lesson(int id, String title, String description, String article, String link, String photoTitle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.article = article;
        this.link = link;
        this.photoTitle = photoTitle;
    }

    public Lesson(String title, String description, String article, String link, String photoTitle) {
        this.title = title;
        this.description = description;
        this.article = article;
        this.link = link;
        this.photoTitle = photoTitle;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
