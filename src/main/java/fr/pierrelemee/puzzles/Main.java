package fr.pierrelemee.puzzles;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import fr.pierrelemee.puzzles.commands.AbstractCommand;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "fr.pierrelemee.puzzles")
public class Main {

    static {
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.OFF);
    }

    private static AnnotationConfigApplicationContext context;

    public static void main(String ... args) {

        try {
            if (args.length == 0) {
                throw new Exception("Usage: puzzles <command>");
            }
            commandForName(args[0]).run();
            System.exit(0);

        } catch (Exception e) {
            // TODO: show error properly
            e.printStackTrace();
        }
    }

    private static AbstractCommand commandForName(String name) throws Exception {
        if (null == context) {
            context = new AnnotationConfigApplicationContext(Main.class);
        }
        for (AbstractCommand command: context.getBeansOfType(AbstractCommand.class).values()) {
            if (command.getName().equals(name)) {
                return command;
            }
        }
        throw new Exception(String.format("Unknown command '%s'", name));
    }
}
