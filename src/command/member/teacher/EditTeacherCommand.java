package command.member.teacher;

import command.Command;
import model.Teacher;
import model.University;
import org.apache.log4j.Logger;
import service.TeacherService;
import service.UniversityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * This command edits teacher.
 * Created by Nataliia Kozoriz on 05/02/2017.
 */
public class EditTeacherCommand implements Command {

    private static final Logger logger = Logger.getLogger(TeacherCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String email = request.getParameter("teacherEmail");
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            String info = request.getParameter("info");
            String picture = request.getParameter("picture");
            Date birthDate = Date.valueOf(request.getParameter("birthDate"));
            String universityEmail = request.getParameter("universityEmail");
            String post = request.getParameter("post");
            String degree = request.getParameter("degree");

            UniversityService uService = new UniversityService();
            University university = uService.get(universityEmail);

            TeacherService tService = new TeacherService();
            tService.edit(new Teacher(email, name, country, info, picture, birthDate, university, post, degree));
            List<Teacher> teachers = tService.getAll();

            HttpSession session = request.getSession(true);
            session.setAttribute("teachers", teachers);
            return TEACHER;
        } catch (Exception ex) {
            logger.error("DBError", ex);
        }
        return START_PAGE;
    }
}