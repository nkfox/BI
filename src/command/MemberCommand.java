package command;

import model.Member;
import service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This command shows all members
 * Created by Nataliia Kozoriz on 14.11.2016.
 */
public class MemberCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            MemberService mService = new MemberService();
            List<Member> members = mService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("members", members);

            return MEMBERS;
        } catch (Exception ex) {
            Logger.getLogger(MemberCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return START_PAGE;
    }

}
