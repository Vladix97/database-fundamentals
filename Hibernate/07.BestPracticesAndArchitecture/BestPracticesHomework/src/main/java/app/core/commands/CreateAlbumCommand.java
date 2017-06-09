package app.core.commands;

import app.annotations.Insert;
import app.domains.Album;
import app.domains.AlbumRole;
import app.domains.Tag;
import app.domains.User;
import app.domains.enums.Color;
import app.services.AlbumService;
import app.services.TagService;
import app.services.UserService;

public class CreateAlbumCommand extends AbstractCommand {

    @Insert
    private AlbumService albumService;

    @Insert
    private UserService userService;

    @Insert
    private TagService tagService;

    protected CreateAlbumCommand(String[] data) {
        super(data);
    }

    /**
     *CreateAlbum <username> <albumTitle> <BackgroundColor> <tag1> <tag2>...<tagN>
     */
    @Override
    public String execute() {
        Album album = new Album();

        String username = super.getData()[1];
        User user = this.userService.findByUsername(username);
        AlbumRole albumRole = new AlbumRole();
        albumRole.setUser(user);
        album.getAlbumRoles().add(albumRole);

        String albumTitle = super.getData()[2];
        album.setName(albumTitle);

        Color backgroundColor = Color.valueOf(super.getData()[3].toUpperCase());
        album.setBackgroundColor(backgroundColor);

        for (int i = 4; i < super.getData().length; i++) {
            String tagName = super.getData()[i];
            Tag tag = this.tagService.findByName(tagName);

            album.getTags().add(tag);
        }

        return String.format("% album was created", albumTitle);
    }
}
