package kr.co.javastudy.mapper;
import java.util.List;
import kr.co.javastudy.vo.Comment;

public interface CommentMapper {
	List<Comment> selectComment();
	List<Comment> selectCommentByBoardNo(int no);
	Comment selectCommentByNo(int no);
	void insertComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int no);
}
