package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

	Long register(BoardDTO bdto);
	
	//BoardDTO객체를 db(entity객체 = Board)에 저장
	//Board=>BoardDTO변환
	default Board convertDtoToEntity(BoardDTO bdto) {
		return Board.builder().bno(bdto.getBno()).title(bdto.getTitle()).writer(bdto.getWriter()).content(bdto.getContent()).build();
	}
	
	//db(entity객체=board)에서 가져온 데이터를 boarddto객체로 변환
	default BoardDTO convertEntityToDto(BoardDTO bdto) {
		return BoardDTO.builder().bno(board.getBno()).title(board.getTitle()).writer(board.getWiter()).content(board.getContent()).build();
	}

	List<BoardDTO> getList();
}