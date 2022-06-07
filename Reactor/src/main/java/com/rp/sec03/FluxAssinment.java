//package com.rp.sec03;
//
//import com.rp.util.Util;
//import reactor.core.publisher.Flux;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.concurrent.Flow;
//
//public class FluxAssinment {
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        FileReader fl = new FileReader("");
//        BufferedReader br = new BufferedReader(fl);
//   Flux.generate()
//        Flux.generate(synchronousSink -> {
//            try {
//                String line =br.readLine();
//                synchronousSink.next(line);
//                if(line==null)
//                    synchronousSink.complete();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }).subscribe(Util.subscriber());
//    }
//}
