package com.mjc.school.repository.implementation;

import com.mjc.school.repository.implementation.factories.AuthorFactory;
import com.mjc.school.repository.implementation.factories.NewsFactory;
import com.mjc.school.repository.implementation.model.Author;
import com.mjc.school.repository.implementation.model.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class Repository {
    private static Repository instance;
    private List<NewsModel> newsModelList;
    private List<Author> authorList;
    public  static Repository getInstance(){
        if(instance==null)instance = new Repository();
        return instance;
    }
    private Repository(){
        this.newsModelList = NewsFactory.getInstance().database();
        this.authorList= AuthorFactory.getInstance().database();
    }
    public List<NewsModel> getNewsList(){
        return newsModelList;
    }
    public List<Author> getAuthorList(){
        return authorList;
    }
    public List readAll(){return newsModelList;}
    public NewsModel updateNewsById(NewsModel newsModel){

        return newsModel;
    }
    public Boolean delete(Long id){
        return Repository.getInstance().getNewsList().remove(readBy(id));}
    public NewsModel create(NewsModel newsModel){
        return newsModel;
    }
    public NewsModel readBy(Long id){return Repository.getInstance().getNewsList().stream().
            filter(b->b.getId()==id)
            .toList().get(0);
    }
}
