package com.nathanodong.nationaltrainhunterws;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractNTHIntegrationTest {
    private MockWebServer mockWebServer = new MockWebServer();
    private NTHFileResources nthFileResources = new NTHFileResources();

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockWebServer.start(9013);
        mockWebResponse("xml/definition.xml", 200);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    void mockWebResponse(String relativeFileName, int responseCode) {
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(responseCode)
                .setBody(nthFileResources.getFileWithUtil(relativeFileName));
        mockWebServer.enqueue(mockResponse);
    }
}
