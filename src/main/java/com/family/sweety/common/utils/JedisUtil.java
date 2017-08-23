package com.family.sweety.common.utils;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by joseph on 2017/8/16.
 */
public final class JedisUtil {


    private static final String jedis_addr ="59.110.137.232";


    private static final int jedis_port = 6379;



    @Value("${spring.redis.host}")
    private static String host="59.110.137.232";

    @Value("${spring.redis.port}")
    private static int port=6379;

    @Value("${spring.redis.timeout}")
    private  static int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private static int maxIdle=1;

    @Value("${spring.redis.pool.max-wait}")
    private static long maxWaitMillis;

    @Value("${spring.redis.password}")
    private static String password="redis";



    private static final String auth = "root";

    private static final int maxConnCount = 10;

    private static final int minConnCount = 1;

    private static final int maxTimeWait = 100000;
    private static final int timeOut = 100000;

    private static final boolean isBorrow = true;


    private static JedisPool jedisPool = null;


    static {


        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();


        jedisPoolConfig.setMaxWaitMillis(maxTimeWait);


        jedisPoolConfig.setTestOnBorrow(isBorrow);

        try {
         jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        } catch (Exception e) {

e.printStackTrace();
        }

    }


    public synchronized static Jedis getJedis() {


        if (jedisPool != null) {

            Jedis resource = jedisPool.getResource();
            return resource;
        } else {


            return null;
        }

    }


    public static void releaseResource(final Jedis jedis) {

        if (null != jedis) {

            jedisPool.returnResource(jedis);
        }


    }
}
