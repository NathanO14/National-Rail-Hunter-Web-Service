package com.nathanodong.nationaltrainhunterws;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractNTHIntegrationTest {
    private MockWebServer mockWebServer = new MockWebServer();
    private NTHFileResources nthFileResources = new NTHFileResources();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockWebServer.start(9013);
        mockWebResponse("xml/definition.xml", 200);
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    public void mockWebResponse(String relativeFileName, int responseCode) {
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(responseCode)
                .setBody(nthFileResources.getFileWithUtil(relativeFileName));
        mockWebServer.enqueue(mockResponse);
    }
}
