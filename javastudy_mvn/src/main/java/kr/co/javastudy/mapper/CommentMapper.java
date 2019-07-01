package kr.co.javastudy.mapper;
import java.util.List;
import kr.co.javastudy.vo.Comment;

public interface CommentMapper {
	List<Comment> selectComment();
	List<Comment> selectCommentByNo(int no);
	void insertComment(Comment comment);
	void deleteComment(int no);
}
