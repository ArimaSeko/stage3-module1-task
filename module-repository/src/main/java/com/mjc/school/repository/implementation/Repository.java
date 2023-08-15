package com.mjc.school.repository.implementation;

import com.mjc.school.repository.implementation.factories.*;
import com.mjc.school.repository.implementation.factories.AuthorFactory;
import com.mjc.school.repository.implementation.factories.NewsFactory;
import com.mjc.school.repository.implementation.model.Author;
import com.mjc.school.repository.implementation.model.News;
import com.mjc.school.repository.implementation.model.*;
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
        this.authorList= AuthorFactory.getInstance().database();
    }
    public List<News> getNewsList(){
        return  newsList;
    }
    public List<Author> getAuthorList(){
        return authorList;
    }
    public void readAll(){//for autoCode, watch real method in module-web Controller class
         }
    public void update(){}
    public void delete(){}
    public void create(){}
    public void readBy(){}
}
