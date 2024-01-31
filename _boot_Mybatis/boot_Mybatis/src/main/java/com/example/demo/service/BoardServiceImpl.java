package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.repository.BoardMapper;
import com.example.demo.repository.FileMapper;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardMapper bm;
	
	@Inject
	private FileMapper fm;

	@Transactional
	@Override
	public void register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		int isOK=bm.insert(boardDTO.getBvo());
		if(isOK>0&& boardDTO.getFlist().size()>0) {
			long bno=bm.getBno();
			for(FileVO fvo : boardDTO.getFlist()) {
				fvo.setBno(bno);
				isOK*=fm.insertFile(fvo);
			}
		}
	}

	@Override
	public List<BoardVO> list(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bm.list(pgvo);
	}

	@Transactional
	@Override
	public BoardDTO selectOne(long bno) {
		BoardDTO bdto=new BoardDTO();
		bdto.setBvo(bm.selectOne(bno));
		bdto.setFlist(fm.getFileList(bno));
		return bdto;
	}

	@Transactional
	@Override
	public void modify(BoardDTO bdto) {
		// TODO Auto-generated method stub
		int isOK = bm.edit(bdto.getBvo());
		if(isOK > 0 && bdto.getFlist().size()>0) {
			long bno = bdto.getBvo().getBno();
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				isOK*=fm.insertFile(fvo);
			}
		}
	}

	@Override
	public int remove(long bno) {
		// TODO Auto-generated method stub
		return bm.remove(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bm.getTotalCount(pgvo);
	}
}