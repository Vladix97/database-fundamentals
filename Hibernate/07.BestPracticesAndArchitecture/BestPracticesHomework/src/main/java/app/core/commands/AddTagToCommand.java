package app.core.commands;

import app.annotations.Insert;
import app.domains.Album;
import app.domains.Tag;
import app.services.AlbumService;
import app.services.TagService;

public class AddTagToCommand extends AbstractCommand {

    @Insert
    private TagService tagService;

    @Insert
    private AlbumService albumService;

    protected AddTagToCommand(String[] data) {
        super(data);
    }

    /**
     * AddTagTo <albumName> <tag>
     */
    @Override
    public String execute() {
        String albumName = super.getData()[1];
        String tagName = super.getData()[2];

        Tag tag = this.tagService.findByName(tagName);
        Album album = this.albumService.findByName(albumName);

        album.getTags().add(tag);

        return String.format("Added %s tag to %s album", tagName, albumName);
    }
}
