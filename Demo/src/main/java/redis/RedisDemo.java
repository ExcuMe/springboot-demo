package redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisDemo {

    public static void main(String[] args) {
        //操作redis的客户端
        Jedis jedis = new Jedis("localhost",6379);

        //存取String类型
        jedis.set("key","value of key");
        System.out.println(jedis.ping() + "\n" + jedis.get("key"));

        //存取Hash
        Map<String,String> map = new HashMap<>();
        map.put("KMap1","VMap1");
        map.put("KMap2","VMap2");
        map.put("KMap3","VMap3");
        jedis.hmset("myHash",map);

        List<String> list = new ArrayList<String>();
        list.add("KMap1");
        list.add("KMap2");
        list.add("KMap3");

        for (String value : list ) {
            System.out.println(jedis.hget("myHash",value));
        }

        //存取List
        List<String> list1 = new ArrayList<>();
        list1.add("花花世界");
        list1.add("Illusory world");
        list1.add("Illusions are true");
        list1.add("Eternal");
        list1.add("Come on");
        
        for (String value : list1) {
            jedis.lpush("myList",value);
        }
        System.out.println(jedis.lrange("myList",0,5));

        //存取set
        List<String> list3 = new ArrayList<>();
        list3.add("存取Set");
        list3.add("试试same");
        list3.add("same");//从输出可以看出，不能重复存
        list3.add("same");
        list3.add("nice");
        for (String s : list3) {
            jedis.sadd("same", s);
        }
        System.out.println(jedis.smembers("same"));
        System.out.println("");


    }
}
