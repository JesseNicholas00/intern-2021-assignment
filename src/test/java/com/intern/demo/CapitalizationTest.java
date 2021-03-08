package com.intern.demo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class CapitalizationTest {

    @InjectMocks
    private Capitalization capitalization;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void convertToMapTest() {

        ImportedBook importedBook1 = new ImportedBook("joHN dOE", "IMPORTED book 1", "Joestar");
        ImportedBook importedBook2 = new ImportedBook("","","");
        LocalBook localBook1 = new LocalBook("jaNE stARk", "loCal bOok 1", "gramEDia");
        LocalBook localBook2 = new LocalBook("Jane     Stark", "Local      Book   2", "qlue");

        List<Book> input = Arrays.asList(importedBook1, importedBook2, localBook1, localBook2);

        Map<String, List<String>> actualMap = Capitalization.convertToMap(input);
        Map<String, List<String>> expectMap = new HashMap<String, List<String>>(){{
            put("John Doe", Arrays.asList("Imported Book 1"));
            put("Jane Stark", Arrays.asList("Local Book 1"));
            put("Jane     Stark", Arrays.asList("Local      Book   2"));
            put("", Arrays.asList(""));
        }};

        System.out.println(actualMap);
        System.out.println(expectMap);
        assertEquals(expectMap, actualMap);
    }
}
