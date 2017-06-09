package app.core.commands;

import app.annotations.Insert;
import app.repositories.*;

public class ExitCommand extends AbstractCommand {
    @Insert
    private AlbumRoleRepository albumRoles;
    @Insert
    private AlbumRepository albums;
    @Insert
    private PictureRepository pictures;
    @Insert
    private TagRepository tags;
    @Insert
    private TownRepository towns;
    @Insert
    private UserRepository users;

    protected ExitCommand(String[] data) {
        super(data);
    }
    /**
     *
     */

    @Override
    public String execute() {
        return null;
    }
}
