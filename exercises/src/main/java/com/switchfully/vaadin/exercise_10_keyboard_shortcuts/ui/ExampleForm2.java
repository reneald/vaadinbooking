package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class ExampleForm2 extends CustomComponent {

    private Panel panel;
    private final Button submitButton;
    private final Button clearButton;
    private final TextField textField;
    private final Label result;

    public ExampleForm2() {
        // TODO Exercise 10: Fix this form to only handle key shortcuts in context of this form.
        panel = new Panel("Entry form");

        result = new Label();

        textField = new TextField("Name");
        submitButton = new Button("Save", e -> result.setValue("Submitted with name " + textField.getValue()));
        submitButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        submitButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        clearButton = new Button("Clear", e -> {
            textField.clear();
            result.setValue("");
        });
        clearButton.setClickShortcut(ShortcutAction.KeyCode.C, new int[] { ShortcutAction.ModifierKey.CTRL });

        HorizontalLayout buttons = new HorizontalLayout(submitButton, clearButton);
        buttons.setSpacing(true);

        panel.setContent(new VerticalLayout(textField, buttons, result));

        setCompositionRoot(panel);
    }

}
