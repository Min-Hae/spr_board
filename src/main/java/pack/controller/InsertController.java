package pack.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//insert를 수행하는 함수
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardInter;
@Controller
public class InsertController {
	@Autowired
	private BoardInter boardInter;
	//댓글 다는 함수
	@RequestMapping(value="replyins", method=RequestMethod.GET )
	public ModelAndView ghi(@RequestParam("num") String num) {
		return new ModelAndView("reply", "reply", boardInter.getData(num));
	}
	//댓글 저장하는 함수
	@RequestMapping(value="replyins", method= RequestMethod.POST)
	public String insert(BoardBean bean) {
		boolean b = boardInter.saveReplyData(bean);
		boolean b1 = boardInter.updateOnum(bean);
		if(b) return "redirect:/boardlist";
		else return "error";
	}	
	
	//글 수정하는 함수
	@RequestMapping(value="editup", method=RequestMethod.GET)
	public ModelAndView edi(@RequestParam("num") String num) {
		return new ModelAndView("edit", "edit", boardInter.getData(num));
	}
	
	//글 수정 저장하는 함수
	@RequestMapping(value="editup", method= RequestMethod.POST)
	public String insertList(BoardBean bean) {
		boolean b = boardInter.saveEdit(bean);
		if(b) return "redirect:/boardlist";
		else return "error";
	}
	
	//글 작성하는 함수
	@RequestMapping("write")
	public String saveWrite(BoardBean bean, HttpServletRequest request) {
		Date d = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setBip(request.getRemoteAddr());
		bean.setBdate(form.format(d));
		bean.setNum(boardInter.getMaxNum()+1);
		bean.setGnum(boardInter.getMaxNum()+1);
		
		boolean b = boardInter.saveData(bean);
		if(b) return "redirect:/boardlist";
		else return "error";
	}
	
	
	
}
