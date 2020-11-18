package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.BwafricanmarketApplication;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BwafricanmarketApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarketServiceImplTest {
    @MockBean
    HelperFunctions helperFunctions;

    @Autowired
    private MarketService marketService;

    @org.junit.Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void findAll() {
    }

    @org.junit.Test
    public void findMarketById() {
    }

    @org.junit.Test
    public void findMarketByLocation() {
    }

    @org.junit.Test
    public void testFindMarketByLocation() {
    }
}