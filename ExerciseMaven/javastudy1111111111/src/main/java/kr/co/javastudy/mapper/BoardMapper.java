package kr.co.javastudy.mapper;

import java.util.List;

import kr.co.javastudy.vo.Board;

public interface BoardMapper {
	List<Board> selectBoard();
	void insertBoard(Board board);
	void deleteBoard(int no);
	void editBoard(Board board);
	Board detailBoard(int no);
}
