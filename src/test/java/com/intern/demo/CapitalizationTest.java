package com.intern.demo;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

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

    }
}
