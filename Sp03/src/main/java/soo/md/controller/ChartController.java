package soo.md.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import soo.md.domain.ChartDTO;

@Controller
@RequestMapping("chart")
public class ChartController {
	private Random r = new Random();
	
	@RequestMapping("chart.do")
	public String showView() {
		return "chart/chart";
	}
	
	@PostMapping(value="chartData", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}) 
	public @ResponseBody List<ChartDTO> getChartData(){
		List<ChartDTO> list = new ArrayList<ChartDTO>();
		String items[] = {"초봄", "봄", "여름", "가을", "겨울", "늦겨울"};   // 항목추가해주고싶으면 여기서하면된다.
		
		for(int i=0; i<items.length; i++) {
			int number = r.nextInt(50); 
			ChartDTO dto = new ChartDTO(items[i], number);
			list.add(dto);
		}
		
		return list;
	}
}
