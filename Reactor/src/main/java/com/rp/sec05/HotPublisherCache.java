package com.rp.sec05;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublisherCache {
    public static void main(String[] args) {
        Flux<String> movie =Flux.fromStream(()->movie())
                .delayElements(Duration.ofSeconds(1))
                        .cache(2);

        Util.sleep(10);
        movie.subscribe(Util.subscriber( "basant"));

        Util.sleep(10);
        System.out.println("Mike is joining");
        movie.subscribe(Util.subscriber( "manas"));

        Util.sleep(60);
    }

    public static Stream<String> movie() {
        System.out.println("Go for the movie streamin req");
        return Stream.of("Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8"
        );

    }
}
