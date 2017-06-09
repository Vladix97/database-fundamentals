package app.core.commands;

import app.annotations.Insert;
import app.justdoitbyneki.ImplementItByYourself;
import app.repositories.*;

public class ModifyUserCommand extends AbstractCommand {
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

    protected ModifyUserCommand(String[] data) {
        super(data);
    }
    /**
     * ModifyUser <username> <property> <new value>
     * For example:
     * ModifyUser <username> Password <NewPassword>
     * ModifyUser <username> Email <NewEmail>
     * ModifyUser <username> FirstName <NewFirstName>
     * ModifyUser <username> LastName <newLastName>
     * ModifyUser <username> BornTown <newBornTownName>
     * ModifyUser <username> CurrentTown <newCurrentTownName>
     * !!! Cannot change username
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
