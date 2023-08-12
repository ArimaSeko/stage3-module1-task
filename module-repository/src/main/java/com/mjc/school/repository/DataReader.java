package com.mjc.school.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static DataReader instance;
    public static DataReader getInstance(){
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    public List<String> handle(String dataPath) throws IOException {
        List<String> stringList = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataPath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            bufferedReader.close();
        String[] stringArray = stringBuilder.toString().split("\n");

        for (String str : stringArray) {
            stringList.add(str);
        }
            return stringList;
    }
}
