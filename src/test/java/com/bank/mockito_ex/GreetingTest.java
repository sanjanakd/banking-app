package com.bank.mockito_ex;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by XKT676 on 5/20/2016.
 */
@RunWith(PowerMockRunner.class)     //to run the test with the PowerMockRunner, not the normal JUnit runner.
@PrepareForTest(HelloStatic.class)  // to prepare the class with the static methods before running the unit test

public class GreetingTest {

    @Test
    public void testGreeting() {
        String morning = "Morning";
        String expected = "Morning,Sanjana";
        String actual;

        PowerMock.mockStatic(HelloStatic.class);  //Use PowerMock to mock the static methods.
        EasyMock.expect(HelloStatic.getHello()).andReturn(morning); //Use EasyMock to change what the static method returns.
        PowerMock.replay(HelloStatic.class);

        System.out.println(actual = new Greeting().getGreeting("Sanjana"));
        
        // PowerMock.verify(HelloStatic.class);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testGetWish() {


        String expected1 = "Good Night,Sanjana";

        String actual1;
        {
            System.out.println(actual1 = new Greeting().getWish("Good Night", "Sanjana kadam"));
        }
        Assert.assertEquals(actual1, expected1);


    }
}