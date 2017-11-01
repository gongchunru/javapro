package com.gcr.dopdf;

import com.gcr.dopdf.utils.PDFUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DopdfApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(PDFUtil.class.getResource("/font/simkai.ttf"));

	}

}
