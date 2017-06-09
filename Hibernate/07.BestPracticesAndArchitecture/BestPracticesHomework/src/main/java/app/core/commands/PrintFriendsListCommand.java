package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class PrintFriendsListCommand extends AbstractCommand {
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

    protected PrintFriendsListCommand(String[] data) {
        super(data);
    }
    /**
     * PrintFriendsList <username>
     * prints all friends of user with given username
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
