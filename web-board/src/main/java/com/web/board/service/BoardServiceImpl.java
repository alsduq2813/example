package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.board.domain.Board;
import com.web.board.repository.BoardRepository;

@Service("boardService")
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public Board findByWriter(String Writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> boardList() {
		return boardRepository.findAll();
	}

	@Override
	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}
	
	@Override
	public Board findByBoard_no(int board_no) {
		return boardRepository.findOne(board_no);
	}

	@Override
	public Boolean isBoardExist(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board updateBoard(int board_no, Board board) {
		Board fetchedBoard = boardRepository.findOne(board_no);
		if(fetchedBoard == null) {
			return null;
		}
		Board updatedBoard = boardRepository.save(board);
		return updatedBoard;
	}

	@Override
	public Board patchBoard(int board_no, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBoard(int board_no) {
		Board fetchedBoard = boardRepository.findOne(board_no);
		if(fetchedBoard == null) {
			return false;
		}else {
			boardRepository.delete(board_no);
			return true;
		}
	}

	

}
