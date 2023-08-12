package com.mjc.school.controller.Algorithms;

import com.mjc.school.service.Service;

import java.util.Scanner;

public class UpdateAl {
    private UpdateAl(){}
    private  static UpdateAl instance;
    public static UpdateAl getInstance(){
        if(instance==null)instance= new UpdateAl();
        return instance;
    }
    private Scanner scanner = new Scanner(System.in);
    public  void updateAlgorithm(){
        System.out.println("Write news id: ");
        long id = scanner.nextLong();
        System.out.println("Write new news tittle: ");
        String tittle = scanner.nextLine();
        System.out.println("Write new news content: ");
        String content = scanner.nextLine();
        System.out.println("Write new author id: ");
        long authorId = scanner.nextLong();
        Service.getInstance().updateNewsById(id, tittle,content,authorId);
        System.out.println("News updated:id="+id+"\nTittle: "+ tittle+"\nContent: "+content+"\nAuthorId" + authorId);
    }
}
