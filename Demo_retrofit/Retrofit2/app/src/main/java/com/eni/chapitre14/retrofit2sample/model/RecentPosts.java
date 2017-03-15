package com.eni.chapitre14.retrofit2sample.model;

import java.util.List;

public class RecentPosts {
    private String status;
    private int count;
    private int countTotal;
    private int pages;
    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    public int getCountTotal() {
        return countTotal;
    }

    public int getPages() {
        return pages;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
