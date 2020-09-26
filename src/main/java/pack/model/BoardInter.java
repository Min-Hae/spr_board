package pack.model;

import java.util.List;

import pack.controller.BoardBean;

public interface BoardInter {
	List<BoardDto> getDataAll();
	List<BoardDto> getData(String num);
	List<BoardDto> getReplyData(String num);
	boolean delData(String num);
	
	int currentGetNum();
	boolean saveData(BoardBean bean);
	boolean saveEdit(BoardBean bean);
	boolean saveReplyData(BoardBean bean);
	int totalList();
	int getPageSu();
	boolean updateReadcnt(String num);
	boolean updateOnum(BoardBean bean);
	String checkPass(String num);
	int getMaxNum();
	
}
