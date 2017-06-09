package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class UploadProfilePictureCommand extends AbstractCommand {
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

    protected UploadProfilePictureCommand(String[] data) {
        super(data);
    }
    /**
     * UploadProfilePicture <username> <pictureFilePath>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
