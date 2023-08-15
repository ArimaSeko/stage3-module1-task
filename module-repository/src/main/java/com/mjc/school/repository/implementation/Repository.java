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
    public NewsModel updateNewsById(long id, String tittle, String content, long authorId){
        NewsModel newsModelToUpdate = null;
        try {
            newsModelToUpdate = readBy(id);
        }catch (ArrayIndexOutOfBoundsException e) {System.out.println(e + "\n didn't find news with that id");}
        if(tittle!=null) newsModelToUpdate.setTittle(tittle);
        if(content!=null) newsModelToUpdate.setContent(content);
        if(authorId!=0) newsModelToUpdate.setAuthorId(authorId);
        newsModelToUpdate.setLastUpdateDate(LocalDateTime.now());
        return newsModelToUpdate;
    }
    public boolean delete(long id){
        return Repository.getInstance().getNewsList().remove(readBy(id));}
    public NewsModel create(String tittle, String content, long authorId){
        NewsModel.NewsBuilder newsBuilder = new NewsModel.NewsBuilder();
        newsBuilder.setTittle(tittle);
        newsBuilder.setContent(content);
        newsBuilder.setAuthorId(authorId);
        Repository.getInstance().getNewsList().add(newsBuilder.build());
        return newsBuilder.build();
    }
    public NewsModel readBy(long id){return Repository.getInstance().getNewsList().stream().
            filter(b->b.getId()==id)
            .toList().get(0);
    }
}
