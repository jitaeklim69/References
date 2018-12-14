package org.study.board.service;

import java.util.List;

import org.study.board.model.BoardVO;
import org.study.board.model.Criteria;

public interface BoardService {

	public void regist(BoardVO vo) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void modify(BoardVO vo) throws Exception;
	
	public void remove(int bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countBoardPage() throws Exception;
}
