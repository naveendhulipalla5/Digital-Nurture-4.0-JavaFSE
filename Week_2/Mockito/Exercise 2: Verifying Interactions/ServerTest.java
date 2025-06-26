package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ServerTest {

	@Test
    public void testVerifyInteraction() {
       
        ExternalAPI mockApi = mock(ExternalAPI.class);

        
        Server server = new Server(mockApi);

        
        server.fetchData();

        
        verify(mockApi).getData();
    }
}
