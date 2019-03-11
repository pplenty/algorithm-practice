package com.jason.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    Runnable task = () -> {
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("TASK completed");
    };

    public static void main(String[] args) throws Exception {

//        CompletableFutureTest main = new CompletableFutureTest();
//        main.completableFuture();
//
//        Future<String> future = main.calculateAsync();
//
//        while (!future.isDone()) {
//            String result = future.get();
//            System.out.println(result);
//        }


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Beautiful";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);

    }

    public void completableFuture() throws Exception {

        CompletableFuture
                .runAsync(task)
                .thenCompose(aVoid -> CompletableFuture.runAsync(task))
                .thenAcceptAsync(aVoid -> System.out.println("all tasks completed!!"))
                .exceptionally(throwable -> {
                    System.out.println("exception occurred!!");
                    return null;
                });
        Thread.sleep(11 * 1000L);
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }
}
