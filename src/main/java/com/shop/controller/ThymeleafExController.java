package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf") // 클라이언트의 요청에 대해서 어떤 컨트롤러가 처리할지 매핑하는 어노테이션이다.
// url에 "/thymeleaf" 경로로 오는 요청을 ThymeleafExController가 처리하도록 한다.
public class ThymeleafExController {
	@GetMapping(value = "/ex01")
	public String thymeleafExample01(Model model){
		model.addAttribute("data", "타임리프 예제 입니다."); // model 객체를 이용해 뷰에 전달한 데이터를 key, value 구조로 넣어준다.
		return "thymeleafEx/thymeleafEx01"; // templates 폴더를 기준으로 뷰의 위치와 이름(thymeleafEx01.html)을 반환한다.
	}

	@GetMapping(value = "/ex02")
	public String thymeleafExample02(Model model){
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상품 상세 설명");
		itemDto.setItemNm("테스트 상품1");
		itemDto.setPrice(10000);
		itemDto.setRegTime(LocalDateTime.now());

		model.addAttribute("itemDto", itemDto);
		return "thymeleafEx/thymeleafEx02";
	}

	@GetMapping(value = "/ex03")
	public String thymeleafExample03(Model model){

		List<ItemDto> itemDtoList = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품 상세 설명"+i);
			itemDto.setItemNm("테스트 상품"+i);
			itemDto.setPrice(10000*i);
			itemDto.setRegTime(LocalDateTime.now());

			itemDtoList.add(itemDto);
		}

		model.addAttribute("itemDtoList", itemDtoList);
		return "thymeleafEx/thymeleafEx03";
	}
	@GetMapping(value = "/ex04")
	public String thymeleafExample04(Model model){

		List<ItemDto> itemDtoList = new ArrayList<>();

		for (int i = 1; i <= 10 ; i++) {

			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품 상세 설명"+i);
			itemDto.setItemNm("테스트 상품"+i);
			itemDto.setPrice(10000*i);
			itemDto.setRegTime(LocalDateTime.now());

			itemDtoList.add(itemDto);
		}

		model.addAttribute("itemDtoList", itemDtoList);
		return "thymeleafEx/thymeleafEx04";
	}


}
