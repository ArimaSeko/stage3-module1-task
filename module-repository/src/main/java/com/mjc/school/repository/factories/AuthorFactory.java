package com.mjc.school.repository.factories;
import com.mjc.school.repository.DataReader;
import com.mjc.school.repository.model.Author;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorFactory {
    private AuthorFactory(){}
    private static AuthorFactory instance;
    public static AuthorFactory getInstance(){
        if(instance==null)instance = new AuthorFactory();
        return instance;
    }
    public List database() {
        List<Author> authorList = new ArrayList<>();
        List<String> strArray = new ArrayList<>();
        try {
            strArray.addAll(DataReader.getInstance().handle("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\author.txt"));
        } catch (IOException e) {
            System.out.println(e + "\nDidnt find news.txt");
        }
        for(int i=0;i<strArray.size();i++){
            Author.AuthorBuilder authorBuilder = new Author.AuthorBuilder();
            authorBuilder.setId(Integer.parseInt(Validator.validate(strArray.get(i),"id=",", ")));
            authorBuilder.setName(Validator.validate(strArray.get(i),"name='","'}"));
            authorList.add(authorBuilder.build());
        }
        return authorList;
    }
}
