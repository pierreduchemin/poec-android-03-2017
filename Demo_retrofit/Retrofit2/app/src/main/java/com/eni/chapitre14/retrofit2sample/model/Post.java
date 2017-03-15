package com.eni.chapitre14.retrofit2sample.model;

import java.util.List;

public class Post {
    private int id;
    private String url;
    private String title;
    private String content;
    private String excerpt;
    private List<Tag> tags;
    private Author author;
    private String thumbnail;

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Author getAuthor() {
        return author;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
