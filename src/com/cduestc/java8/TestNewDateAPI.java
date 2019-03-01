package com.cduestc.java8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestNewDateAPI {
	@Test
	public void test5(){
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ldt);
		
		LocalDateTime ldt2 = ldt.withDayOfMonth(17);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 =ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println(ldt3);
		
//		自定义工作日
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			
			DayOfWeek dow = ldt4.getDayOfWeek();
			
			if(dow.equals(DayOfWeek.FRIDAY)){
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)){
				return ldt4.plusDays(2);
			}else {
				return ldt4.plusDays(1);
			}
			
		});
		System.out.println(ldt5);//计算下一个工作日；
	}
	@Test
	public void test6(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		
		LocalDateTime ldt = LocalDateTime.now();
		
		String strDate = ldt.format(dtf);
		System.out.println(strDate);
		
		DateTimeFormatter dtf2 =DateTimeFormatter.ofPattern("yyyy年MM月dd日 ");
		
		String strDate2 = dtf2.format(ldt);
		System.out.println(strDate2);
	}
	
	@Test
	public void test7(){
//		时区列表
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
		
		LocalDateTime ldt2 = LocalDateTime.now();
//		指定时区的时间
		ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Monaco"));
		System.out.println(zdt);
	}
}
