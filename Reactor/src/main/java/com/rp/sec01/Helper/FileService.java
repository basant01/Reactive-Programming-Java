package com.rp.sec01.Helper;

import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService {

    private static Path path = Paths.get("src/main/resources");

    public static Mono<String> read(String fiileName){
        return Mono.fromSupplier(()->readFileMethod(fiileName));
    }

    public static Mono<Void> write(String fiileName,String content){
        return Mono.fromRunnable(()->writeFileMethod(fiileName,content));
    }

    public static Mono<Void> delete(String fiileName){
        return Mono.fromRunnable(()->deleteFileMethod(fiileName));
    }

    public static String readFileMethod(String fileName)
    {
        try {
            return Files.readString(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileMethod(String fileName,String content)
    {
        try {
            Files.writeString(path.resolve(fileName),content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFileMethod(String fileName)
    {
        try {
            Files.delete(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public static String readFile() {

        File file = new File("src/main/resources/MDM");
        BufferedReader br
                = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String st;

        while (true) {
            try {
                if (!((st = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        return st;
    }
}


