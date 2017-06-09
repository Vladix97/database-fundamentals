package app.core.commands;


import app.annotations.Insert;
import app.domains.Town;
import app.services.TownService;

public class AddTownCommand extends AbstractCommand {

    @Insert
    private TownService townService;

    protected AddTownCommand(String[] data) {
        super(data);
    }

    /**
     *  AddTown <townName> <countryName>
     */
    @Override
    public String execute() {
        String townName = this.getData()[1];
        String countryName = this.getData()[2];
        Town town = new Town();
        town.setName(townName);
        town.setCountry(countryName);

        this.townService.persist(town);

        return townName + " was added to database";
    }
}
