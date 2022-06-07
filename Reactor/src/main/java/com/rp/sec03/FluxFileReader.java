//package com.rp.sec03;
//
//import com.rp.util.Util;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.SynchronousSink;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Objects;
//import java.util.concurrent.Callable;
//import java.util.function.BiFunction;
//import java.util.function.Consumer;
//
//public class FluxFileReader {
//
//    public Callable<BufferedReader> readFile(Path path)
//    {
//        return ()-> Files.newBufferedReader(path);
//    }
//
//    public BiFunction<BufferedReader, SynchronousSink<String>,BufferedReader> read(){
//        ((br,synchronousSink) -> {
//            try {
//                String line= br.readLine();
//                if(Objects.isNull(line)){
//                    synchronousSink.complete();
//                }
//                else {
//                    synchronousSink.next(line);
//                }
//            } catch (IOException e) {
//                 synchronousSink.error(e);
//            }
//   return  br;
//        });
//    }
//
//    public Consumer<BufferedReader> closeBr() throws IOException {
//     return bufferedReader-> {
//         try {
//             bufferedReader.close();
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     };
//    }
//
//public Flux<String> redLine(Path path) throws IOException {
//    return Flux.generate(readFile(path),
//            read(),
//            closeBr());
//
//}
//}
