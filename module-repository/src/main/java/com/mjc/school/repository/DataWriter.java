package com.mjc.school.repository;

import com.mjc.school.repository.factories.AuthorFactory;
import com.mjc.school.repository.factories.NewsFactory;
import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DataWriter {
    public static void writeData(String path, List list){
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
            for(Object object: list)bufferedWriter.write(object.toString()+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
