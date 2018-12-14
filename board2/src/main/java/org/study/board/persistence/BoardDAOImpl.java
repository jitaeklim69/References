package org.study.board.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.board.model.BoardVO;
import org.study.board.model.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String name = "org.study.board.mapper.BoardMapper";
	@Autowired
	SqlSession session;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(name + ".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(name + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(name + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(name + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(name + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return session.selectList(name + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(name + ".listCriteria", cri);
	}

	@Override
	public int getTotalBoardNum() throws Exception {
		return session.selectOne(name + ".getTotal");
	}

}
