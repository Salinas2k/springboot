package com.ingemur.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPostgresqlHibernateCrudApplicationTests {

	@Test
	void contextLoads() {
	}
	
	public static void main(String[] args) {
		long T = 125;
		long F = 0;
		long Slot = 14;
		long Port = 2;
		long psh = 8;
		long C = 0;
		for(int S=1; S<=2;S++) {
			for(int P=0;P<16;P++) {
				long ifIndex = (T << 25) + (F << 19) + (S << 13) + (P << psh) + C;
		System.out.println("INSERT INTO port (portid,slot,pon,description,olt) VALUES ("+ ifIndex + "," + S + "," + P + "," + "'LIBRE 0/" + S + "/" + P + "','192.168.23.10');");
	}
		}}

}
