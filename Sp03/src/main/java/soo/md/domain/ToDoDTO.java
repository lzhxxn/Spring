package soo.md.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ToDoDTO {
	private String subject;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") //           년/월/일로 정의 한 것.
	private Date cdate; //클라이언트한테 받는 데이터! util 
}
