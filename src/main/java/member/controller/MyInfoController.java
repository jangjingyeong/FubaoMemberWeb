package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/member/myInfo.do")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 이동 2가지
		// 1. with Data <- DataBase에서 가져옴 
		// 쿼리문 : SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
		// 전달값이 있으니 매개변수, member를 리턴형으로 잡아야함 
		MemberService service = new MemberService();
		String memberId = request.getParameter("member-id");
		Member member = service.selectOneById(memberId);
		request.setAttribute("member", member); // 꼭 안써줘도 되지만 일반적으로 같이 씀 
		// 앞은 키값이라 "" 뒤는 변수명 
		RequestDispatcher view = request.getRequestDispatcher("/member/myInfo.jsp");
		view.forward(request, response);
		// 2. without Data(단순 페이지 이동)
//		response.sendRedirect("/member/myinfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
