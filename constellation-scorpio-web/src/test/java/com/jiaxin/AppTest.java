package com.jiaxin;

import com.alibaba.fastjson.JSON;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 
     */
    static String jsonStr = "{\"appId\":\"welab-skyscanner-poseidon\",\"cluster\":\"default\",\"namespaceName\":\"application\",\"configurations\":{\"spring.datasource.hikari.max-lifetime\":\"1800000\",\"audit.batch.cron\":\"0 0/10 * * * ?\",\"redis.redisType\":\"cluster\"},\"releaseKey\":\"20200511161810-dbdbac837c6003eb\"}";
    public static void main(String[] args) {
        ApolloDTO apolloDTO = JSON.parseObject(jsonStr, ApolloDTO.class);
        System.out.println(apolloDTO);
    }
}
