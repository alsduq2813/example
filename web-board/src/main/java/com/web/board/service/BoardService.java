package com.web.board.service;

import java.util.List;

import com.web.board.domain.Board;

public interface BoardService {
	
	Board findByWriter(String Writer);
	
	List<Board> boardList();

	Board saveBoard(Board board);
	
	Boolean isBoardExist(Board board);
	
	Board updateBoard(int board_no, Board board);
	
	Board patchBoard(int board_no, Board board);
	
	Boolean deleteBoard(int board_no);

	Board findByBoard_no(int board_no);
}
