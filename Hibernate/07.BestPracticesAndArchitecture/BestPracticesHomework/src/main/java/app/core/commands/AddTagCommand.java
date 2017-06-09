package app.core.commands;

import app.annotations.Insert;
import app.domains.Tag;
import app.services.TagService;
import app.utilities.TagUtilities;

public class AddTagCommand extends AbstractCommand {

    @Insert
    private TagService tagService;

    public AddTagCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String tagName = TagUtilities.validateOrTransform(this.getData()[1]);
        Tag tag = new Tag();
        tag.setName(tagName);
        this.tagService.persist(tag);

        return tagName + " was added successfully to database";
    }
}
