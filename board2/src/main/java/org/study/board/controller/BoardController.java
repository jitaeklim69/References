package org.study.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.study.board.model.BoardVO;
import org.study.board.model.Criteria;
import org.study.board.model.PageMaker;
import org.study.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "register", method=RequestMethod.GET)
	public String registerGet() {
		logger.info("register get");
		
		return "/board/register";
	}
	
	@RequestMapping(value = "register", method=RequestMethod.POST)
	public String registerPost(BoardVO board, RedirectAttributes rttr) {
		logger.info("register post: " + board);
		
		try {
			service.regist(board);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		logger.info("show all list");
		model.addAttribute("list",service.listAll());
		return "/board/list";
	}
	
	@RequestMapping(value="listAll", method=RequestMethod.POST)
	public void listAllPost(Model model) throws Exception {
		logger.info("show all list post");
		
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(@RequestParam("bno") int bno, Criteria cri, Model model) throws Exception {
		logger.info("read.. : " + cri);
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
		return "/board/read";
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("remove: " + cri);
		service.remove(bno);
		
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listPage?page=" + cri.getPage() + "&perPageNum="
				+ cri.getPerPageNum();
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public void ModifyGet( int bno, Criteria cri, Model model) throws Exception {
		model.addAttribute(service.read(bno));
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String ModifyPost(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.modify(board);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listPage?page=" + cri.getPage() + "&perPageNum=" 
				+ cri.getPerPageNum();
	}
	
	@RequestMapping(value="listCri", method = RequestMethod.GET)
	public void listCri(Criteria cri, Model model) throws Exception {
		logger.info("listCri: " + cri);
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		logger.info("listPage: " + cri);
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countBoardPage());
		model.addAttribute("pageMaker", pageMaker);
	}
}
