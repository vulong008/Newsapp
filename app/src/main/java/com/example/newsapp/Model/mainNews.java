package com.example.newsapp.Model;

import java.util.ArrayList;

public class mainNews {
    private String status, totalResult;
    private ArrayList<Models> articles;

    public mainNews(String status, String totalResult, ArrayList<Models> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<Models> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Models> articles) {
        this.articles = articles;
    }
}
