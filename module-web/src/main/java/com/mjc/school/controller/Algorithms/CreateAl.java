package com.mjc.school.controller.Algorithms;

import com.mjc.school.repository.model.News;
import com.mjc.school.service.Service;

import java.util.Scanner;

public class CreateAl {
    private CreateAl(){}
    private  static CreateAl instance;
    public static CreateAl getInstance(){
        if(instance==null)instance= new CreateAl();
        return instance;
    }
    private Scanner scanner = new Scanner(System.in);
    public  void createAlgorithm(){
        System.out.println("Write news tittle: ");
        String tittle = scanner.nextLine();
        System.out.println("Write news content: ");
        String content = scanner.nextLine();
        System.out.println("Write author id: ");
        long authorId = Long.parseLong(scanner.nextLine());
        System.out.println("News created:\nTittle: "+ tittle+"\nContent: "+content+"\nAuthorId" + authorId);
        Service.getInstance().createNews(tittle,content,authorId);
    }

}
