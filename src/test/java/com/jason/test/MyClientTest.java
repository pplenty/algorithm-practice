//package com.jason.test;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(MyClient.class)
//public class MyClientTest {
//
//    @Test(expected = RuntimeException.class)
//    public void testPublicAPI() throws Exception {
//        MyClient classUnderTest = PowerMockito.spy(new MyClient());
//
//        // Change to this
//
//        PowerMockito.doReturn(20).when(classUnderTest, "privateApi", anyString(), anyInt());
//
//        classUnderTest.publicApi();
//    }1
//}