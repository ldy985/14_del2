package Game;

import desktop_fields.Field;
import desktop_fields.Street;

/**
 * Created by ldylab on 28-10-2016.
 */

// Acts as an extention to the GUI.
// Makes it possible to set and get the actionText.
public class FieldNew {

    private String title;
    private String actionText;
    private int rent;

    // Extends the GUI class to be able to set and get actionText.
    public String getActionText() {
        return actionText;
    }

    public FieldNew setActionText(String text) {
        actionText = text;
        return this;
    }

    // Returns rent
    public int getRent() {
        return rent;
    }

    // Sets the rent
    public FieldNew setRent(int rent) {
        this.rent = rent;
        return this;
    }

    // Sets the title
    public FieldNew setTitle(String title) {
        this.title = title;
        return this;
    }

    // Uses the GUI to set the title, rent, subtext and description.
    public Field toField() {
        Street.Builder a = new Street.Builder()
                .setTitle(title)
                .setRent(rent + "")
                .setSubText(rent + " Points");
        if (title.toLowerCase().contains("the") && !title.toLowerCase().contains(" the ")) {
            a.setDescription("This is "+title+". Landing here will result in: ");
        } else {
            a.setDescription("This is the "+title+". Landing here will result in: ");
        }
        return a.build();
    }


}
