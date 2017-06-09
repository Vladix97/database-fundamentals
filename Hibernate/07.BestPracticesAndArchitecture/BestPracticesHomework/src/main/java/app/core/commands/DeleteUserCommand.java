package app.core.commands;

import app.annotations.Insert;
import app.domains.User;
import app.repositories.*;

public class DeleteUserCommand extends AbstractCommand {
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

    protected DeleteUserCommand(String[] data) {
        super(data);
    }

    /**
     *  DeleteUser <username>
     *  Delete User by username (only mark him as inactive)
     */
    @Override
    public String execute() {
        String username = this.getData()[1];
        User user = users.findByUsername(username);
        if(user != null){
            throw new UnsupportedOperationException("User with that username was not found");
        }
        user.setDeleted(true);
        return "User "+username+" was deleted from the database";
    }
}
