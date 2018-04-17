package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.event.Action;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class ExampleForm1 extends CustomComponent
        implements Action.Handler
{
    Action action_ok = new ShortcutAction("Default key",
            ShortcutAction.KeyCode.ENTER, null);

    Action action_clear = new ShortcutAction("Ctrl+C",
            ShortcutAction.KeyCode.C, new int[] { ShortcutAction.ModifierKey.CTRL });

    private Panel panel;
    private final Button searchButton;
    private final Button clearButton;
    private final TextField textField;
    private final Label result;

    public ExampleForm1() {
        panel = new Panel("Search form");
        panel.addActionHandler(this);

        result = new Label();

        textField = new TextField("Filter");
        searchButton = new Button("Search", e -> result.setValue("Searching with filter " + textField.getValue()));
        searchButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        clearButton = new Button("Clear", e -> {
            textField.clear();
            result.setValue("");
        });

        HorizontalLayout buttons = new HorizontalLayout(searchButton, clearButton);
        buttons.setSpacing(true);

        panel.setContent(new VerticalLayout(textField, buttons, result));

        setCompositionRoot(panel);
    }

    @Override
    public Action[] getActions(Object target, Object sender) {
        return new Action[] {action_ok, action_clear};
    }

    @Override
    public void handleAction(Action action, Object sender, Object target) {
        if (action == action_ok) {
            searchButton.click();
        }
        if (action == action_clear) {
            clearButton.click();
        }
    }

}
