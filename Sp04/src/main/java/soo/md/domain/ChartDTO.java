package soo.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChartDTO {
	private String item;
	private int number;
	
	@Override    // ChartDTO extends Object  ,   toString 나중에 확장성을 위해서 좋다. 
	public String toString() {
		return "GoogleChartDTO item: " + item + ", number: " + number;
	}
}
