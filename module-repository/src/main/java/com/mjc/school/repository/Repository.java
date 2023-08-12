package com.mjc.school.repository;

import com.mjc.school.repository.factories.*;
import com.mjc.school.repository.model.*;
import java.util.List;

public class Repository {
    private static Repository instance;
    private List<News> newsList;
    private List<Author> authorList;
    public  static Repository getInstance(){
        if(instance==null)instance = new Repository();
        return instance;
    }
    private Repository(){
        this.newsList = NewsFactory.getInstance().database();
        this.authorList=AuthorFactory.getInstance().database();
    }
    public List<News> getNewsList(){
        return  newsList;
    }
    public List<Author> getAuthorList(){
        return authorList;
    }
}
