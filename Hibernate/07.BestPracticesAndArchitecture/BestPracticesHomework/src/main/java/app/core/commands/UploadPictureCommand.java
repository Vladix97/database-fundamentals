package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class UploadPictureCommand extends AbstractCommand {
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

    protected UploadPictureCommand(String[] data) {
        super(data);
    }
    /**
     * UploadPicture <albumName> <pictureTitle> <pictureFilePath>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
