package kr.co.javastudy.mapper;

import java.util.List;
import kr.co.javastudy.vo.Board;

public interface BoardMapper {
	List<Board> selectBoard();
	void insertBoard(Board board);
	Board selectBoardByNo(int no);
	void deleteBoard(int no);
	void updateBoard(Board board);
}
