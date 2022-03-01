package kg.geektech.newsapp40.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "news")
public class News implements Serializable {
    @PrimaryKey(autoGenerate = true)
     int id;
    @ColumnInfo(name = "title")
     String title;
    @ColumnInfo(name = "created_at")
     long creteAt;

    @ColumnInfo(name = "description")
    String description;

    public News(String title, long creteAt) {
        this.title = title;
        this.creteAt = creteAt;
    }

    public News(String title, long creteAt, String description) {
        this.title = title;
        this.creteAt = creteAt;
        this.description = description;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
