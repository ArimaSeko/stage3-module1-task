package com.mjc.school.controller.Algorithms;

import com.mjc.school.service.Service;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DeleteAl {
    private DeleteAl(){}
    private static DeleteAl instance;
    public static DeleteAl getInstance(){
        if(instance==null)instance= new DeleteAl();
        return instance;
    }
    private Scanner scanner = new Scanner(System.in);
    public void DeleteAlgorithm(){
        System.out.println("Write the id of news you want to delete: ");
        long id = scanner.nextLong();
        System.out.println("Delete news with id "+id+" is :"+Service.getInstance().deleteNewsById(id));
    }
}
