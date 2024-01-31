package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.handler.FileHandler;
import com.example.demo.handler.PagingHandler;
import com.example.demo.service.BoardService;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bsv;
	
	@Inject
	private FileHandler fh;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo,@RequestParam(name="files",required=false)MultipartFile[] files) {
		
		List<FileVO>flist=null;
		if(files[0].getSize()>0||files!=null) {
			//파일 핸들러 작업
			flist=fh.uploadFiles(files);
		}
		bsv.register(new BoardDTO(bvo,flist));
		//파일 업로드 부분 추가 		
		return "index";
	}
	
	@GetMapping("/list")
	public void list(Model m, PagingVO pgvo) {
		List<BoardVO> list = bsv.list(pgvo);
		//totalCount
		int totalCount = bsv.getTotalCount(pgvo);
		//PagingHandler
		PagingHandler ph = new PagingHandler(pgvo, totalCount);
		m.addAttribute("list", list);
		//PagingHandler 객체 보내기
		m.addAttribute("ph", ph);
	}
	
	@GetMapping({"/detail","/modify"})
	public void detail(@RequestParam("bno")long bno,Model m) {
		BoardDTO bdto = bsv.selectOne(bno);
		m.addAttribute("bdto", bdto);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo, @RequestParam(name="files", required = false)MultipartFile[] files) {
		List<FileVO> flist = null;
		if(files[0].getSize()>0||files != null) {
			flist = fh.uploadFiles(files);
		}
		bsv.modify(new BoardDTO(bvo,flist));
		return "redirect:/board/detail?bno="+bvo.getBno();
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") long bno) {
		int isOK = bsv.remove(bno);
		return "redirect:/board/list";
	}
}