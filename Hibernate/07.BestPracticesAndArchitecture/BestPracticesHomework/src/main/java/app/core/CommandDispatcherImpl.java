package app.core;

import app.annotations.Insert;
import app.core.commands.AbstractCommand;
import app.repositories.*;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Component
public class CommandDispatcherImpl implements CommandDispatcher{
    private final String COMMANDS_PACKAGE = "app.core.commands.";
    private final String COMMAND_SUFFIX = "Command";

    private final AlbumRoleService albumRoles;
    private final AlbumService albums;
    private final PictureService pictures;
    private final TagService tags;
    private final TownService towns;
    private final UserService users;

    @Autowired
    public CommandDispatcherImpl(
            AlbumRoleService albumRoles,
            AlbumService albums,
            PictureService pictures,
            TagService tags,
            TownService towns,
            UserService users) {
        this.albumRoles = albumRoles;
        this.albums = albums;
        this.pictures = pictures;
        this.tags = tags;
        this.towns = towns;
        this.users = users;
    }

    @Override
    public Executable dispatchCommand(String commandName, String[] commandParameters) {
        commandName = COMMANDS_PACKAGE + commandName + COMMAND_SUFFIX;

        Executable commandInstance = null;
        try {
            Class<AbstractCommand> commandClass = (Class<AbstractCommand>) Class.forName(commandName);
            Constructor ctor = commandClass.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);
            commandInstance = (AbstractCommand) ctor.newInstance((Object)commandParameters);
            this.injectDependencies(commandInstance, commandClass);
        } catch (ReflectiveOperationException e) {
            throw new UnsupportedOperationException("Invalid command");
        }

        return commandInstance;
    }

    private void injectDependencies(Executable commandInstance,
                                    Class<AbstractCommand> commandClass) throws
            IllegalAccessException {
        Field[] cmdFields = commandClass.getDeclaredFields();
        Field[] theseFields = CommandDispatcherImpl.class.getDeclaredFields();

        for (Field field : cmdFields) {
            if (!field.isAnnotationPresent(Insert.class)) {
                continue;
            }
            field.setAccessible(true);

            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(field.getType())) {
                    continue;
                }

                thisField.setAccessible(true);
                field.set(commandInstance, thisField.get(this));
            }
        }
    }
}
