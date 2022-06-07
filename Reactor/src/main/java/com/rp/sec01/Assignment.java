package com.rp.sec01;

import com.rp.sec01.Helper.FileService;
import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

public class Assignment {

    public static void main(String[] args) {

        FileService.read("MDM").subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        FileService.write("MDM","HI Basant How are you").subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        FileService.delete("MDM").subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
