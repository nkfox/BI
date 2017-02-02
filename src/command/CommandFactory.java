package command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is factory for all Commands
 * Created by Nataliia Kozoriz on 08.11.2016.
 */
public class CommandFactory {

    private final Map<String, Command> commandMap = new HashMap<>();
    private static CommandFactory instance = null;

    private CommandFactory() throws NamingException {
    }

    public static synchronized CommandFactory getInstance() {
        if (instance == null) {
            try {
                instance = new CommandFactory();
            } catch (NamingException ex) {
                Logger.getLogger(CommandFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    {
        commandMap.put("null", new EmptyCommand());
        commandMap.put("showMembers", new MemberCommand());
        commandMap.put("showEvents", new EventCommand());
        commandMap.put("showProjects", new ProjectCommand());
        commandMap.put("showNews", new NewsCommand());
        commandMap.put("addMember", new AddMemberCommand());
        commandMap.put("addEvent", new AddEventCommand());
        commandMap.put("addProject", new AddProjectCommand());
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
