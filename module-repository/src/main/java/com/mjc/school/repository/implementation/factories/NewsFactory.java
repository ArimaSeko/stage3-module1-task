package com.mjc.school.repository.implementation.factories;

import com.mjc.school.repository.implementation.DataReader;
import com.mjc.school.repository.implementation.model.News;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsFactory {
    private NewsFactory() {
    }
    private static NewsFactory instance;
    public static NewsFactory getInstance(){
        if(instance==null)instance = new NewsFactory();
        return instance;
    }
    public List<News> database() {
        List<News> newsList = new ArrayList<>();
        List<String> strArray = new ArrayList<>();
        try {
            strArray.addAll(DataReader.getInstance().handle("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\news.txt"));
        } catch (IOException e) {
            System.out.println(e + "\nDidnt find news.txt");
        }
        for (int i = 0; i < strArray.size(); i++) {
            News.NewsBuilder newsBuilder = new News.NewsBuilder();
            newsBuilder.setId(Integer.parseInt(Validator.validate(strArray.get(i),"id=",", ")));//setting id without letters
            newsBuilder.setContent(Validator.validate(strArray.get(i),"content='","', ")); // setting content and other strings without id
            newsBuilder.setTittle(Validator.validate(strArray.get(i),"tittle='","', "));
            newsBuilder.setAuthorId(Integer.parseInt(Validator.validate(strArray.get(i),"authorId=","\n")));
            newsBuilder.setCreateDate(LocalDateTime.parse(Validator.validate(strArray.get(0),"createDate=",", ")));
            newsBuilder.setLastUpdateDate(LocalDateTime.parse(Validator.validate(strArray.get(0),"lastUpdateDate=",", ")));
            newsList.add(newsBuilder.build());
        }
        return newsList;
    }

}
