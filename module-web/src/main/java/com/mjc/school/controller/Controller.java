package com.mjc.school.controller;

import com.mjc.school.controller.Algorithms.CreateAl;
import com.mjc.school.controller.Algorithms.UpdateAl;
import com.mjc.school.repository.*;
import com.mjc.school.repository.model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    public void writeToBase(List<News> news, List<Author> authors) {
        DataWriter.writeData("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\news.txt", news);
        DataWriter.writeData("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\author.txt", authors);
    }

    public void on(String i) {
        System.out.println("list of news - 1");
        System.out.println("list of authors - 2");
        System.out.println("create news- 3");
        System.out.println("update news- 4");
        System.out.println("delete news - 5");
        System.out.println("exit - 6");
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while (scanner.hasNextLine() && shouldContinue) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    for (News news : Repository.getInstance().getNewsList())
                        System.out.println(news.toString());
                    break;
                case "2":
                    for (Author author : Repository.getInstance().getAuthorList())
                        System.out.println(author.toString());
                    break;
                case "3":
                    CreateAl.getInstance().createAlgorithm();
                    break;
                case "4":
                    UpdateAl.getInstance().updateAlgorithm();
                    break;
                case "6":
                    writeToBase(Repository.getInstance().getNewsList(), Repository.getInstance().getAuthorList());
                    shouldContinue = false;
                    break;
            }
        }
        scanner.close();
    }

}
