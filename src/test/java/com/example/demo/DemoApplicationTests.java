package com.example.demo;

import com.example.demo.chain.ChainExecutor;
import com.example.demo.chain.ProcessorContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ChainExecutor chainExecutor;

	@Test
	void contextLoads() {

		ProcessorContext context = chainExecutor.processArrayList("TEST",new HashMap<>());
		System.out.println("执行结束");
		System.out.println(context);
	}

}
