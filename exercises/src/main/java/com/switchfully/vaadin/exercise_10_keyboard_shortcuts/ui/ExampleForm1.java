package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class ExampleForm1 extends CustomComponent {

    private Panel panel;
    private final Button searchButton;
    private final Button clearButton;
    private final TextField textField;
    private final Label result;

    public ExampleForm1() {
        // TODO Exercise 10: Fix this form to only handle key shortcuts in context of this form.
        panel = new Panel("Search form");

        result = new Label();

        textField = new TextField("Filter");
        searchButton = new Button("Search", e -> result.setValue("Searching with filter " + textField.getValue()));
        searchButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        searchButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        clearButton = new Button("Clear", e -> {
            textField.clear();
            result.setValue("");
        });
        clearButton.setClickShortcut(ShortcutAction.KeyCode.C, new int[] { ShortcutAction.ModifierKey.CTRL });

        HorizontalLayout buttons = new HorizontalLayout(searchButton, clearButton);
        buttons.setSpacing(true);

        panel.setContent(new VerticalLayout(textField, buttons, result));

        setCompositionRoot(panel);
    }

}
