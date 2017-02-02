package command;

import model.Member;
import service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This command add new member
 * Created by Nataliia Kozoriz on 14.11.2016.
 */
public class AddMemberCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String selected = request.getParameter("name");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");

        MemberService mService = new MemberService();
        mService.add(new Member(email, selected, country, phone));
        List<Member> members = mService.getAll();

        HttpSession session = request.getSession(true);
        session.setAttribute("members", members);
        return "../jsp/members.jsp";
    }
}
