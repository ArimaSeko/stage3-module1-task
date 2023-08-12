package com.mjc.school.service;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.model.News;

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

    public News createNews(String tittle, String content, long authorId){
        News.NewsBuilder newsBuilder = new News.NewsBuilder();
        newsBuilder.setTittle(tittle);
        newsBuilder.setContent(content);
        newsBuilder.setAuthorId(authorId);
        return newsBuilder.build();
    }
    public boolean deleteNewsById(long id){
        return Repository.getInstance().getNewsList().remove(getNewsById(id));
    }
    public News updateNewsById(long id, String tittle, String content, long authorId){
        if(tittle!=null)getNewsById(id).setTittle(tittle);
        if(content!=null)getNewsById(id).setContent(content);
        if(authorId!=0)getNewsById(id).setAuthorId(authorId);
        getNewsById(id).setLastUpdateDate(LocalDateTime.now());
        return getNewsById(id);
    }
}
