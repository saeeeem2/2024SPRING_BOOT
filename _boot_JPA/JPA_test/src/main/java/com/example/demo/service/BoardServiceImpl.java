package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository repository;

	@Override
	public Long register(BoardDTO bdto) {
		//저장 객체는 Board
		//save : insert 후 저장 객체를 리턴
		return repository.save(convertDtoToEntity(bdto)).getBno();
		
	}

	@Override
	public List<BoardDTO> getList() {
		//db에서 list로 리턴이 되기 때문에 Board list로 리턴 => dto객체로 변환
		//(Sort.by(Sort.Direction.DESC,"기준 칼럼명")
		List<Board> list=repository.findAll(Sort.by(Sort.Direction.DESC,"bno"));
		List<BoardDTO> dtoList=new ArrayList<>();
		for(Board board:list) {
			dtoList.add(convertEntityToDto(board));
		}
		return dtoList;
	}
}
