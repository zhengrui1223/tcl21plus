package redis;

import redis.clients.jedis.Jedis;

public class JedisClientTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.19.10.44", 6379);
        //权限认证
        jedis.auth("123456");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
    }

}
