package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.repository.factories.AuthorFactory;
import com.mjc.school.repository.factories.NewsFactory;
import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;
import com.mjc.school.repository.Repository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.on();
    }
}

