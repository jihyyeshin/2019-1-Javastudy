package kr.co.javastudy.mapper;
import java.util.List;
import kr.co.javastudy.vo.Comment;

public interface CommentMapper {
	List<Comment> selectComment();
	void insertComment(Comment comment);
}
