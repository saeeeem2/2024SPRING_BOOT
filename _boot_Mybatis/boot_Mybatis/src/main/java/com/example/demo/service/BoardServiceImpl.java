package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper bm;
}
