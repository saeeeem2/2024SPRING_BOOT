package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.PageVO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardDTO bdto) {
		log.info(">>>>>bdto >> >>>",bdto);
		Long bno=bsv.register(bdto);
		log.info(">>>>>bno"+bno);
		return "/index";
	}
	
//	@GetMapping("/list")
//	public void list(Model m) {
//		List<BoardDTO> list=bsv.getList();
//		m.addAttribute("list",list);
//	}
	
	//페이징이 있는 리스트
	@GetMapping("/list")
	public void list(Model m, @RequestParam(value="pageNo", defaultValue = "0", required = false)int pageNo) {
//		int pageNo=0;
		int page=(pageNo==0? 0:pageNo-1);
		
		Page<BoardDTO> list=bsv.getList();
		
		log.info("total count:"+list.getTotalElements());//전체 글 개수
		log.info("total page:"+list.getTotalPages());//전체 페이지 수 => realEndPage
		log.info("pageNumber:"+list.getNumber());//현재 페이지
		log.info("page size:"+list.getSize());//한 페이지의 게시글 수=>qty
		log.info("page next:"+list.hasNext());//다음 페이지 여부 => boolean next
		log.info("page prev:"+list.hasPrevious());//이전 페이지 여부 => boolean prev
		
		log.info("list>>>>>",list.getContent());
		
		PageVO pageVO = new PageVO(list, pageNo);
		m.addAttribute("list",list);
		m.addAttribute("pageVO",pageVO);
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("bno")Long bno, Model m) {
		BoardDTO bdto=bsv.getDetail(bno);
		m.addAttribute("bdto",bdto);
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO bdto, RedirectAttributes re) {
		Long bno=bsv.modify(bdto);
		re.addFlashAttribute("bno",bdto.getBno());
		return "redirect:/board/detail";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno) {
		bsv.remove(bno);
		return "redirect:/board/list";
		
	}
	
	
	
	
}
