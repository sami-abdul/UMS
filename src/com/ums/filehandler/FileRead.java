package com.ums.filehandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

    FileReader fr;
    BufferedReader br;

    public FileRead(String path) throws IOException {
        this.fr = new FileReader(path);
        this.br = new BufferedReader(fr);
    }

    public ArrayList<String> openFile() throws IOException {

        ArrayList<String> text = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null)
            text.add(line);
        br.close();
        return text;
    }
}
