package com.jason.test;

public class MyClient {

    public void publicApi() {
        System.out.println("In publicApi");
        int result = 0;
        try {
            result = privateApi("hello", 1);
        } catch (Exception e) {
//            Assert.assertEquals.fail();
        }
        System.out.println("result : "+result);
        if (result == 20) {
            throw new RuntimeException("boom");
        }
    }

    private int privateApi(String whatever, int num) throws Exception {
        System.out.println("In privateAPI");
        thirdPartyCall();
        int resp = 10;
        return resp;
    }

    private void thirdPartyCall() throws Exception{
        System.out.println("In thirdPartyCall");
        //Actual WS call which may be down while running the test cases
    }
}