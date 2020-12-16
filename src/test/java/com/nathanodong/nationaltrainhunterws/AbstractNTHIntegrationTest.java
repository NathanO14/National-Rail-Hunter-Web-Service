package com.nathanodong.nationaltrainhunterws;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2015_05_14.ldbsv_ref.LDBSVRefServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldbsv.LDBSVServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldbsv.Ldbsv;
import org.apache.cxf.endpoint.Client;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractNTHIntegrationTest {
    @MockBean
    protected LDBSVServiceSoap ldbsvServiceSoap;

    @MockBean
    protected LDBSVRefServiceSoap ldbsvRefServiceSoap;

    @MockBean
    private Ldbsv ldbsv;

    @Autowired
    protected AccessToken accessToken;

    @MockBean
    private Client client;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
