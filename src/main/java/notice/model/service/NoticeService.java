package notice.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO nDao;
	private JDBCTemplate jdbcTemplate;
	
	public NoticeService() {
		nDao = new NoticeDAO();
		// jdbcTemplate = new JDBCTemplate(); // 싱글톤패턴 적용해서 생성자 private라 못만든다! 
		jdbcTemplate = JDBCTemplate.getInstance(); // 이렇게 객체 만들어줌 ! 
	}
	
	public int insertNotice(Notice notice) {
		Connection conn = jdbcTemplate.createConnection();
		int result = nDao.insertNotice(conn, notice);
		if(result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	
	// 공지사항 전체 목록 조회
	public List<Notice> selectNoticeList() {
		Connection conn = jdbcTemplate.createConnection();
		List<Notice> nList = nDao.selectNoticeList(conn);
		jdbcTemplate.close(conn);
		return nList;
	}

}
