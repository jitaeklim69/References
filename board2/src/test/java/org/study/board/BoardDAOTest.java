package org.study.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.board.model.BoardVO;
import org.study.board.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Autowired
	BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 타이틀");
		vo.setContent("새로운 컨텐트");
		vo.setWriter("김철수");
		
		dao.create(vo);
	}
	
	@Test
	public void testListPage() throws Exception {
		int page = 10;
		
		List<BoardVO> list = dao.listPage(page);
		for (BoardVO board : list) {
			logger.info(board.getBno() + ": " + board.getTitle());
		}
	}

}
