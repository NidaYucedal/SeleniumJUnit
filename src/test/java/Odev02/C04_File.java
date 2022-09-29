package Odev02;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_File {

    //Verify that we have pom.xml file in our project => please try in 4 min s
    @Test
    public void verify() {
        String path="pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}