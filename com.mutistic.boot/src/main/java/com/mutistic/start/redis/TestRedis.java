package com.mutistic.start.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mutistic.start.runs.MainBySpringApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainBySpringApplication.class)
@ActiveProfiles(profiles = "dev")
public class TestRedis {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println("==================="+stringRedisTemplate.opsForValue().get("aaa"));
	}

//	@Test
//	public void testObj() throws Exception {
//		ValueOperations<String, User> operations = redisTemplate.opsForValue();
////		operations.set("com.neox", new User("asdfadsf"));
//		boolean exists = redisTemplate.hasKey("com.neox");
//		if (exists) {
//			System.out.println("===================exists is true");
//		} else {
//			System.out.println("===================exists is false");
//		}
//		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//	}
}
