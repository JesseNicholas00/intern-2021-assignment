package com.intern.demo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

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

        ImportedBook importedBook1 = new ImportedBook("joHN dOE", "IMPORTED book 1", "joHN dOE");
        LocalBook localBook1 = new LocalBook("jaNE stARk", "loCal bOok 1", "gramEDia");

        List<Book> input = Arrays.asList(importedBook1, localBook1);

        Map<String, List<String>> actualMap = Capitalization.convertToMap(input);
        Map<String, List<String>> expectMap = new HashMap<>();
        expectMap.put("John Doe", Arrays.asList("Imported Book 1"));
        expectMap.put("Jane Stark", Arrays.asList("Local Book 1"));

        assertEquals(expectMap, actualMap);
    }
}
