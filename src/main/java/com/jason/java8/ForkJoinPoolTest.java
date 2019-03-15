package com.jason.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
        ForkJoinTask<String> a = forkJoinPool.submit(() -> {
            String req = testRequest();
            return req;
        });


        Optional<String> option = Optional.ofNullable(null);
        System.out.println(option.isPresent());
        System.out.println(Optional.ofNullable(""));
        System.out.println(Optional.ofNullable("2"));
        System.out.println(Optional.ofNullable("2"));
        String result = a.get();
        System.out.println(result);
    }

    public static String testRequest() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Beautiful";

    }

}
