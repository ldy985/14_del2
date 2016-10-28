package Game;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_fields.iBuilder;
import desktop_resources.GUI;

import java.awt.*;

/**
 * Created by ldylab on 28-10-2016.
 */
public class FieldNew {

    private String title;
    private String subText;
    private int rent;
    private String actionText;


    public String getActionText() {
        return actionText;
    }

    public FieldNew setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRent() {
        return rent;
    }

    public FieldNew setRent(int rent) {
        this.rent = rent;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FieldNew setSubText(String subText) {
        this.subText = subText;
        return this;
    }

    public String getSubText() {
        return this.subText;
    }

    public FieldNew setActionText(String text) {
        actionText = text;
        return this;
    }

    public Field toField() {
        return new Street.Builder()
                .setTitle(title)
                .setRent(rent + "")
                .setSubText(rent+"")
                .build();
    }
}
