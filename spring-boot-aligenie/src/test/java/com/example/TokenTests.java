package com.example;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenTests {

    @Resource
    private JwtTokenStore jwtTokenStore;

    @Test
    public void test1() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODkyODI1NzYsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiYWxsIl0sImp0aSI6IjM5MmU4NmJlLTlhMzgtNGQyMy04YmUyLTYwYzRlYjI1MTUzMSIsImNsaWVudF9pZCI6ImNsaWVudCIsInNjb3BlIjpbImFsbCJdfQ.8a381BaCDpRDlsHhIuVEI_JB5WiHF2ZhsK6J9TsGd_4";
        OAuth2AccessToken oAuth2AccessToken = jwtTokenStore.readAccessToken(token);
        System.out.println(JSON.toJSONString(oAuth2AccessToken.getAdditionalInformation()));
        System.out.println(oAuth2AccessToken.getScope());
    }
}
