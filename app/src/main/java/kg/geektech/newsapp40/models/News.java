package kg.geektech.newsapp40.models;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private long creteAt;

    public News(String title, long creteAt) {
        this.title = title;
        this.creteAt = creteAt;
    }

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreteAt() {
        return creteAt;
    }

    public void setCreteAt(long creteAt) {
        this.creteAt = creteAt;
    }
}
