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
import org.study.board.model.Criteria;
import org.study.board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardServiceTest {

	@Autowired
	BoardService service;
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Test
	public void testListPage() throws Exception {
		int page = 10;
		
		Criteria cri = new Criteria();
		cri.setPage(5);
		cri.setPerPageNum(20);
		List<BoardVO> list = service.listCriteria(cri);
		for (BoardVO board : list) {
			logger.info(board.getBno() + ": " + board.getTitle());
		}
	}

}
