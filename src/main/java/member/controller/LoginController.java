package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		
		Member member = new Member(memberId, memberPw);
		
//		Member member = new Member();
//		member.setMemberId(memberId);
//		member.setMemberPw(memberPw);
		
		// SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?
		// 매개변수 1개, 리턴타입 member 
		MemberService service = new MemberService();
		Member mOne = service.selectCheckLogin(member);
		
//		Member mOne = service.selectCheckLogin(memberId, memberPw);
		
		
		if(mOne != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", mOne.getMemberId());
			session.setAttribute("memberName", mOne.getMemberName());
			// 가져온 데이터의 정보를 저장해줌 
			// 로그인 성공!
			request.setAttribute("msg", "로그인 성공!");
			request.setAttribute("url", "/index.jsp");
			RequestDispatcher view 
			= request.getRequestDispatcher("/WEB-INF/views/member/serviceSuccess.jsp");
			view.forward(request, response); // 누락 주의 
		} else {
			// 로그인 실패!
			request.setAttribute("msg", "로그인 실패!");
			RequestDispatcher view 
			= request.getRequestDispatcher("/WEB-INF/views/member/serviceFailed.jsp");
			view.forward(request, response); // 누락 주의 
		}
		
		
	}

}
