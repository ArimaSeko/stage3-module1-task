package com.mjc.school.service;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.model.News;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

public class Service {
    private static Service instance;
    private Service(){}
    public static Service getInstance(){
        if(instance == null)instance = new Service();
        return instance;
    }
    public News getNewsById(long id){
        return Repository.getInstance().getNewsList().stream().
                filter(b->b.getId()==id)
                .toList().get(0);
            }

    public void createNews(String tittle, String content, long authorId){
        News.NewsBuilder newsBuilder = new News.NewsBuilder();
        newsBuilder.setTittle(tittle);
        newsBuilder.setContent(content);
        newsBuilder.setAuthorId(authorId);
        Repository.getInstance().getNewsList().add(newsBuilder.build());
    }
    public boolean deleteNewsById(long id){
        return Repository.getInstance().getNewsList().remove(getNewsById(id));
    }
    public News updateNewsById(long id, String tittle, String content, long authorId){
        News newsToUpdate = null;
        try {
             newsToUpdate = getNewsById(id);
        }catch (ArrayIndexOutOfBoundsException e) {System.out.println(e + "\n didn't find news with that id");}
        if(tittle!=null)newsToUpdate.setTittle(tittle);
        if(content!=null)newsToUpdate.setContent(content);
        if(authorId!=0)newsToUpdate.setAuthorId(authorId);
        newsToUpdate.setLastUpdateDate(LocalDateTime.now());
        return getNewsById(id);
    }
}
