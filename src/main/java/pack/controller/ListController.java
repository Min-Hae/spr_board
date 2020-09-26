package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardInter;
@Controller
public class ListController {
	@Autowired
	private BoardInter boardInter;
	

	
	//게시판 목록을 나타내는 함수
	@RequestMapping("boardlist")
	public ModelAndView abc() {
		return new ModelAndView("boardlist", "list", boardInter.getDataAll());
	}
	//글 내용 보여주는 함수
	@RequestMapping("boardcontent")
	public ModelAndView def(@RequestParam("num") String num) {
		ModelAndView model = new ModelAndView();
		model.addObject("list", boardInter.updateReadcnt(num));
		model.addObject("list", boardInter.getData(num));
		model.setViewName("boardcontent");
		return model;
	}
	//글 작성하는 함수
	@RequestMapping(value= "boardwrite", method=RequestMethod.GET)
	public ModelAndView write() {
		return new ModelAndView("boardwrite");
	}
	//글 삭제 페이지 띄우는 함수
	@RequestMapping(value="del", method= RequestMethod.GET)
	public ModelAndView delete(@RequestParam("num") String num) {
		return new ModelAndView("delete", "delete", boardInter.getData(num));
	}
	//글 삭제하는 함수
	@RequestMapping(value="del", method= RequestMethod.POST)
	public String deleting(@RequestParam("num") String num, @RequestParam("pass") String passwd ) {
		String passCheck = boardInter.checkPass(num);
		boolean b1 = (passCheck.equals(passwd));
		if(b1) {
			boolean b2 = boardInter.delData(num);
			if(b2)
				return "redirect:/boardlist";
			else
				return "error";
		}
		else return "error";				
	}
}
