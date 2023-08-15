package com.mjc.school.repository.implementation.model;

import com.mjc.school.repository.implementation.Repository;

import java.time.LocalDateTime;

public class NewsModel {
    private long id;
    private String tittle;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private long authorId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }


    public NewsModel() {
    }

    public NewsModel(long id, String tittle, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, long authorId) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorId=" + authorId;
    }

    public static class NewsBuilder{
        private NewsModel newsModel;
        public NewsBuilder(){
            newsModel = new NewsModel();}
        public void setId(long id){
            newsModel.setId(id);
        }
        public void setTittle(String tittle){
            newsModel.setTittle(tittle);}
        public void setContent(String content){
            newsModel.setContent(content);}
        public void setCreateDate(LocalDateTime createDate){
            newsModel.setCreateDate(createDate);}
        public void setLastUpdateDate(LocalDateTime lastUpdateDate){
            newsModel.setLastUpdateDate(lastUpdateDate);}
        public void setAuthorId(long authorId){
            newsModel.setAuthorId(authorId);}
    public NewsModel build(){
            if(newsModel.getId()==0) newsModel.setId(Repository.getInstance().getNewsList().size()+1);
            if(newsModel.getLastUpdateDate()==null) newsModel.setLastUpdateDate(LocalDateTime.now());
            if(newsModel.getCreateDate()==null) newsModel.setCreateDate(LocalDateTime.now());
            return newsModel;}
    }
}
