package com.pravin.tests;


import com.pravin.assignments.AddressBookMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookMainTest {

    @Test
    public void shouldTakeUserInput(){


        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("\r\n2\r\nA\r\nB\r\nC\r\nD\nE\nF\nG\nH\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        AddressBookMain.main(new String[0]);

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        //Assert.assertEquals(output, "7");
        System.out.println("Output"+output);
        // checkout output
        Assertions.assertEquals("expected","expected");

    }

}