package com.web.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.web.board.domain.Board;
import com.web.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/")
	public String home() {
		return "welcom";
	}

	//POST - 게시글 추가
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void>  addBoard(@RequestBody Board board, UriComponentsBuilder ucBuilder) {
		Board savedBoard = boardService.saveBoard(board);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{board_no}").buildAndExpand(savedBoard.getBoard_no()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//GET - 게시글 확인
	@RequestMapping(value="/{board_no}", method=RequestMethod.GET)
	public ResponseEntity<Board> getBoard(@PathVariable int board_no){
		Board fetchedBoard = boardService.findByBoard_no(board_no);
		if(fetchedBoard == null) {
			return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Board>(fetchedBoard, HttpStatus.OK);
	}
	
	//GET - 게시글 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<Board>> listBoards(){
		List<Board> boardList = boardService.boardList();
		if(boardList.isEmpty()) {
			return new ResponseEntity<List<Board>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
	}
	
	//PUT - 게시글 수정
	@RequestMapping(value="/{board_no}", method=RequestMethod.PUT)
	public ResponseEntity<Board> updateBoard(@PathVariable int board_no, @RequestBody Board board){
		Board updatedBoard = boardService.updateBoard(board_no, board);
		if(updatedBoard == null) {
			return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Board>(updatedBoard, HttpStatus.OK);
	}
	
	//DELETE - 게시글 삭제
	@RequestMapping(value="/{board_no}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBoard(@PathVariable int board_no){
		Boolean deleteResult = boardService.deleteBoard(board_no);
		if(deleteResult == null || !deleteResult) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}






