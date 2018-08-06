package kr.or.ddit.boardTest.model;

import java.util.Date;

public class BoardTestVo {
	private int board_no;
	private String board_title;
	private String board_writer;
	private Date board_date;
	
	public BoardTestVo(){
		
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	@Override
	public String toString() {
		return "BoardTestVo [board_no=" + board_no + ", board_title="
				+ board_title + ", board_writer=" + board_writer
				+ ", board_date=" + board_date + "]";
	}
	
}
