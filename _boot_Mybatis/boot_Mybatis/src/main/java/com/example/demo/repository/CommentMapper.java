package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.CommentVO;

@Mapper
public interface CommentMapper {

	int insert(CommentVO cvo);

	int selectOneBnoTotalCount(long bno);

	List<CommentVO> getList(long bno);

	int edit(CommentVO cvo);

	int remove(long cno);

}