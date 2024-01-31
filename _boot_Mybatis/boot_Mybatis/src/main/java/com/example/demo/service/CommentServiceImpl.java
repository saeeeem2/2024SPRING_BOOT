package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.CommentVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.handler.PagingHandler;
import com.example.demo.repository.BoardMapper;
import com.example.demo.repository.CommentMapper;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

	@Inject
	private CommentMapper cm;

	@Inject
	private BoardMapper bm;

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cm.insert(cvo);
	}

	@Override
	public PagingHandler getList(long bno, PagingVO pgvo) {
		// TODO Auto-generated method stub
		int totalCount = cm.selectOneBnoTotalCount(bno);
		List<CommentVO> list = cm.getList(bno, pgvo);
		PagingHandler ph = new PagingHandler(pgvo, totalCount, list);
		return ph;
	}


	@Override
	public int edit(CommentVO cvo) {
		
		return cm.edit(cvo);
	}

	@Override
	public int remove(long cno) {
		
		return cm.remove(cno);
	}

}