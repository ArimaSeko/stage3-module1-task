package com.mjc.school.controller;

import com.mjc.school.controller.Algorithms.CreateAl;
import com.mjc.school.controller.Algorithms.DeleteAl;
import com.mjc.school.controller.Algorithms.UpdateAl;
import com.mjc.school.repository.implementation.DataWriter;
import com.mjc.school.repository.implementation.Repository;
import com.mjc.school.repository.implementation.model.Author;
import com.mjc.school.repository.implementation.model.NewsModel;

import java.util.List;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    public void writeToBase(List<NewsModel> newsModels, List<Author> authors) {
        DataWriter.writeData("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\news.txt", newsModels);
        DataWriter.writeData("F:\\Projects\\stage3-module1-task\\module-repository\\src\\main\\resources\\author.txt", authors);
    }

    public void on() {
        System.out.println("list of news - 1");
        System.out.println("list of authors - 2");
        System.out.println("create news- 3");
        System.out.println("update news- 4");
        System.out.println("delete news - 5");
        System.out.println("exit - 0");
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        while (scanner.hasNextLine() && shouldContinue) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    for (NewsModel newsModel : Repository.getInstance().getNewsList())
                        System.out.println(newsModel.toString());
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
                case "5":
                    DeleteAl.getInstance().DeleteAlgorithm();
                    break;
                case "0":
                    writeToBase(Repository.getInstance().getNewsList(), Repository.getInstance().getAuthorList());
                    shouldContinue = false;
                    break;
            }
        }
        scanner.close();
    }

}
