package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;
@Repository
public class BoardImpl extends SqlSessionDaoSupport implements BoardInter{
	@Autowired
	public BoardImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	//현재의 num값 가져오는 함수
	@Override
	public int currentGetNum() {
		// TODO Auto-generated method stub
		return 0;
	}
	//글 삭제하는 함수
	@Override
	public boolean delData(String num) {
		try {
			int re = getSqlSession().delete("delData",num);
			if(re >0)
				return true;
			else
				return false;
		}catch (Exception e) {
			System.out.println("delData err :" + e);
			return false;
		}
	}
	//모든 리스트 가져오는 함수
	@Override
	public List<BoardDto> getDataAll() {
		return getSqlSession().selectList("selectDataAll");
	}
	public int getPageSu() {

		return 0;
	}
	
	//리스트를 얻는 함수
	@Override
	public List<BoardDto> getData(String num) {
		return getSqlSession().selectList("getData", num);
	}
	//댓글 반환 함수
	@Override
	public List<BoardDto> getReplyData(String num) {
		return getSqlSession().selectList("getData", num);
	}
	//글 or 댓글 작성하는 함수
	@Override
	public boolean saveData(BoardBean bean) {
		try {
			getSqlSession().insert("insertData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("saveData err : "+ e);
			return false;
		}
	}
	//글 수정하는 함수
	@Override
	public boolean saveEdit(BoardBean bean) {
		try {
			getSqlSession().update("saveData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("saveEdit err : "+ e);
			return false;
		}
		
	}
	//댓글 저장하는 함수
	@Override
	public boolean saveReplyData(BoardBean bean) {
		try {
			getSqlSession().insert("saveReply", bean);
			return true;
		} catch (Exception e) {
			System.out.println("saveReplyData err : "+ e);
			return false;
		}
	}
	public int totalList() {
		return 0;
	}
	//order num을 증가하는 함수
	@Override
	public boolean updateOnum(BoardBean bean) {
		try {
			getSqlSession().update("updateOnum", bean);
			return true;
		} catch (Exception e) {
			System.out.println("updateOnum err : "+ e);
			return false;
		}
		
	}
	//조회수 증가하는 함수
	@Override
	public boolean updateReadcnt(String num) {
		try {
			getSqlSession().update("updateReadcnt", num);
			return true;
		} catch (Exception e) {
			System.out.println("updateReadcnt err : "+ e);
			return false;
		}	
	}
	//num의 최대값을 반환하는 함수
	@Override
	public int getMaxNum() {
		int max = getSqlSession().selectOne("currentGetNum");
		return max;
	}
	//비밀번호 확인하는 함수
	@Override
	public String checkPass(String num) {
		return getSqlSession().selectOne("checkPass", num);
		
		}
}
