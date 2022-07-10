package com.mysql.shiori;

import com.mysql.shiori.mapper.SingleTableMapper;
import com.mysql.shiori.model.SingleTableDO;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

@SpringBootTest
class MysqlTestApplicationTests {
	@Autowired
	private SingleTableMapper singleTableMapper;

	@Test
	void contextLoads() {
		for (int i = 0; i < 10000; i++) {
			Random random = new Random();
try {
	SingleTableDO singleTableDO = SingleTableDO.builder()
			.key1(getRandomStr())
			.key2((random.nextInt(1000000)))
			.key3(getRandomStr())
			.key_part1(getRandomStr())
			.key_part2(DigestUtils.md5DigestAsHex(new byte[]{new Integer((int) (Math.random() * 10)).byteValue()}))
			.key_part3(getRandomStr())
			.build();

	singleTableMapper.insert(singleTableDO);
}catch (Exception e){

}

		}

	}

	public static void main(String[] args) {
		double v = Math.random() * 10;
		System.out.println(v);
		System.out.println(getRandomChar());
	}

	private static String getRandomStr(){
		int size = (int) (Math.random() * 10);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i <size ; i++) {
			stringBuilder.append(getRandomChar());
		}
		return stringBuilder.toString();
	}
	//随机生成汉字
	private static char getRandomChar() {
		String str = "";
		int hightPos; //
		int lowPos;

		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
			str = new String(b, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("错误");
		}

		return str.charAt(0);
	}


}
