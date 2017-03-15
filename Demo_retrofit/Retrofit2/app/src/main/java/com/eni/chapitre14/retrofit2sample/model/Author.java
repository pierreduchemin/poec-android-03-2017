package com.eni.chapitre14.retrofit2sample.model;

public class Author {
    private int id;
    private String name;
    private String nickname;

    @Override
    public String toString() {
        return name;
    }
}
