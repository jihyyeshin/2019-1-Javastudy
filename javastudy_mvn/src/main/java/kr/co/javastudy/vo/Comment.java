package kr.co.javastudy.vo;

public class Comment {
	private int no;
	private int board_no;
	private String content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return board_no;
	}
	public void setBoardNo(int board_no) {
		this.board_no = board_no;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
