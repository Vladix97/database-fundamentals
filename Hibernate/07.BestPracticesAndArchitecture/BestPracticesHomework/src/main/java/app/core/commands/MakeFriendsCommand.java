package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class MakeFriendsCommand extends AbstractCommand {
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

    protected MakeFriendsCommand(String[] data) {
        super(data);
    }
    /**
     * bidirectional adding friends
     * MakeFriends <username1> <username2>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
