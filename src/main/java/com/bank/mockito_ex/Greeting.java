package com.bank.mockito_ex;

/**
 * Created by XKT676 on 5/20/2016.
 */
public class Greeting {

    public String getGreeting(String name){
       // return System.out.println(HelloStatic.getHello(),name);
        return String.format("%s,%s",HelloStatic.getHello(),name);



    }
    public String getWish(String wish, String name){
       // wish="Good Day";
       return String.format("%s,%s",wish,name);
    }

}
