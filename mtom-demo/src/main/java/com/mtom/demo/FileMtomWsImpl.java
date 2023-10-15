package com.mtom.demo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;
import java.nio.file.Files;

public class FileMtomWsImpl implements FileMtomWs{
    @Override
    public void uploadFile(DataHandler dataHandler) throws IOException {
        InputStream inputStream = dataHandler.getInputStream();
        OutputStream outputStream = Files.newOutputStream(new File("D:/Lifelong Learning/course-lab/uploaded/photo.jpg").toPath());

        byte[] bytes = new byte[100000];
        int byteRead = 0;

        while ((byteRead = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,byteRead);
        }
    }

    @Override
    public DataHandler downloadFile() {
        return new DataHandler(new FileDataSource("D:/Lifelong Learning/course-lab/uploaded/photo.jpg"));
    }
}
