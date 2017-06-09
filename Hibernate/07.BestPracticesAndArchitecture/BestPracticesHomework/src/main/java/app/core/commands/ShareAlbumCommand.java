package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class ShareAlbumCommand extends AbstractCommand {
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

    protected ShareAlbumCommand(String[] data) {
        super(data);
    }
    /**
     * ShareAlbum <albumId> <username> <permission>
     * For example:
     * ShareAlbum 4 dragon321 Owner
     * ShareAlbum 4 dragon11 Viewer
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
