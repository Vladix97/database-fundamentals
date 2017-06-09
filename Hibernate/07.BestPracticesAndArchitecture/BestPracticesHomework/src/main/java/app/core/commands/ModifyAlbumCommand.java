package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class ModifyAlbumCommand extends AbstractCommand {
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

    protected ModifyAlbumCommand(String[] data) {
        super(data);
    }
    /**
     * ModifyAlbum <albumId> <property> <new value>
     * For example
     * ModifyAlbum Name <new name>
     * ModifyAlbum BackgroundColor <new color>
     * ModifyAlbum IsPublic <True/False>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
