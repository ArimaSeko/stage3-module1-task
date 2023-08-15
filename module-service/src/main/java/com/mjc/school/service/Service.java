package com.mjc.school.service;

import com.mjc.school.repository.implementation.Repository;
import com.mjc.school.repository.implementation.model.NewsModel;

import java.time.LocalDateTime;

public class Service {
    private static Service instance;
    private Service(){}
    public static Service getInstance(){
        if(instance == null)instance = new Service();
        return instance;
    }
    public NewsModel getNewsById(long id){
        return Repository.getInstance().getNewsList().stream().
                filter(b->b.getId()==id)
                .toList().get(0);
            }

    public void createNews(String tittle, String content, long authorId){
        NewsModel.NewsBuilder newsBuilder = new NewsModel.NewsBuilder();
        newsBuilder.setTittle(tittle);
        newsBuilder.setContent(content);
        newsBuilder.setAuthorId(authorId);
        Repository.getInstance().getNewsList().add(newsBuilder.build());
    }
    public boolean deleteNewsById(long id){
        return Repository.getInstance().getNewsList().remove(getNewsById(id));
    }
    public NewsModel updateNewsById(long id, String tittle, String content, long authorId){
        NewsModel newsModelToUpdate = null;
        try {
             newsModelToUpdate = getNewsById(id);
        }catch (ArrayIndexOutOfBoundsException e) {System.out.println(e + "\n didn't find news with that id");}
        if(tittle!=null) newsModelToUpdate.setTittle(tittle);
        if(content!=null) newsModelToUpdate.setContent(content);
        if(authorId!=0) newsModelToUpdate.setAuthorId(authorId);
        newsModelToUpdate.setLastUpdateDate(LocalDateTime.now());
        return getNewsById(id);
    }
}
