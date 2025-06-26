package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

	@Mock
    ExternalApi mockApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchData() {
        when(mockApi.getData()).thenReturn("Mocked Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mocked Data", result);
    }
}
