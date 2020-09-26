package pack.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//insert�� �����ϴ� �Լ�
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardInter;
@Controller
public class InsertController {
	@Autowired
	private BoardInter boardInter;
	//��� �ٴ� �Լ�
	@RequestMapping(value="replyins", method=RequestMethod.GET )
	public ModelAndView ghi(@RequestParam("num") String num) {
		return new ModelAndView("reply", "reply", boardInter.getData(num));
	}
	//��� �����ϴ� �Լ�
	@RequestMapping(value="replyins", method= RequestMethod.POST)
	public String insert(BoardBean bean,  HttpServletRequest request) {
		Date d = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		int nested = bean.getNested() + 1;
		bean.setNum(boardInter.getMaxNum()+1);
		bean.setGnum(bean.getGnum());
		bean.setNested(nested);
		bean.setBip(request.getRemoteAddr());
		bean.setBdate(form.format(d));
		boolean b1 = boardInter.updateOnum(bean);
		bean.setOnum(bean.getOnum()+1);
		boolean b = boardInter.saveData(bean);
		if(b) return "redirect:/boardlist";
		else return "error";
	}	
	
	//�� �����ϴ� �Լ�
	@RequestMapping(value="editup", method=RequestMethod.GET)
	public ModelAndView edi(@RequestParam("num") String num) {
		return new ModelAndView("edit", "edit", boardInter.getData(num));
	}
	
	//�� ���� �����ϴ� �Լ�
	@RequestMapping(value="editup", method= RequestMethod.POST)
	public String insertList(BoardBean bean) {
		boolean b = boardInter.saveEdit(bean);
		if(b) return "redirect:/boardlist";
		else return "error";
	}
	
	//�� �ۼ��ϴ� �Լ�
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
