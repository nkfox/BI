package command;

import command.member.student.*;
import command.member.teacher.*;
import command.member.university.*;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is factory for all Commands
 * Created by Nataliia Kozoriz on 08/11/2016.
 */
public class CommandFactory {

    private static final Logger logger = Logger.getLogger(CommandFactory.class);

    private final Map<String, Command> commandMap = new HashMap<>();
    private static CommandFactory instance = null;

    private CommandFactory() throws NamingException {
    }

    public static synchronized CommandFactory getInstance() {
        if (instance == null) {
            try {
                instance = new CommandFactory();
            } catch (Exception ex) {
                logger.error("NewInstanceError", ex);
            }
        }
        return instance;
    }

    {
        commandMap.put("null", new EmptyCommand());

        commandMap.put("showUniversities", new UniversitiesCommand());
        commandMap.put("showUniversity", new UniversityCommand());
        commandMap.put("addUniversity", new AddUniversityCommand());
        commandMap.put("editUniversity", new EditUniversityCommand());
        commandMap.put("deleteUniversity", new DeleteUniversityCommand());

        commandMap.put("showStudents", new StudentsCommand());
        commandMap.put("showStudent", new StudentCommand());
        commandMap.put("addStudent", new AddStudentCommand());
        commandMap.put("editStudent", new EditStudentCommand());
        commandMap.put("deleteStudent", new DeleteStudentCommand());

        commandMap.put("showTeachers", new TeachersCommand());
        commandMap.put("showTeacher", new TeacherCommand());
        commandMap.put("addTeacher", new AddTeacherCommand());
        commandMap.put("editTeacher", new EditTeacherCommand());
        commandMap.put("deleteTeacher", new DeleteTeacherCommand());


        commandMap.put("showEvents", new EventsCommand());
        commandMap.put("addEvent", new AddEventCommand());

        commandMap.put("showProjects", new ProjectsCommand());
        commandMap.put("addProject", new AddProjectCommand());

        commandMap.put("showNews", new NewsCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String value = request.getParameter("act");
        Command command = commandMap.get(value);
        if (command == null) {
            command = commandMap.get("null");
        }
        return command;
    }
}
