package com.treehole;

import com.treehole.service.TreeholeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.treehole.util.AESUtil;

import javax.crypto.BadPaddingException;

@SpringBootTest
class TreeholeApplicationTests {

	@Autowired
	private TreeholeService treeholeService;

	@Test
	void testAESUtil() {
		try {
			System.out.println("test AESUtil");
			String a = "12345";
			System.out.println("要加密的字段为"+a);
			String s = AESUtil.encode(a);
			System.out.println("加密后："+s);
			String s1 = AESUtil.decode(s);
			System.out.println("解密后："+s1);
		}
		catch (BadPaddingException e){
			e.printStackTrace();
		}
	}

	@Test
    void testTreeholeService(){
		treeholeService.register("EASY2","12345678912","123456","123.png");
    }


}
