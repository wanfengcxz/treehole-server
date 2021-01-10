package com.treehole;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.treehole.util.AESUtil;

import javax.crypto.BadPaddingException;
import java.util.Base64;

@SpringBootTest
class TreeholeApplicationTests {

	@Test
	void testAESUtil() {
		try {
			System.out.println("test");
			String a = "12345";
			String s = AESUtil.encode(a);
			System.out.println(s);
			String s1 = AESUtil.decode(s);
			System.out.println(s1);
			String s2 = Base64.getEncoder().encodeToString(a.getBytes());
			System.out.println(s2);
		}
		catch (BadPaddingException e){
			e.printStackTrace();
		}

	}

	@Test
    void testAESUtil2(){

		try {
			String encrypt_code1_wrong = "JrcylrP8+Qb2YfkM/dVBEg==";
			String encrypt_code2_right = "JrcylrP7+Qb2YfkM/dVBEg==";

			System.out.println(AESUtil.decode(encrypt_code2_right));
			System.out.println(AESUtil.decode(encrypt_code1_wrong));
		}
	    catch (BadPaddingException e){
			e.printStackTrace();
		}
    }
}
