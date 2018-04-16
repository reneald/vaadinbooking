package com.switchfully.vaadin.exercise_10_keyboard_shortcuts.ui;

import com.vaadin.event.Action;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class ExampleForm2 extends CustomComponent
        /* Solution Added Start */
        implements Action.Handler
        /* Solution Added End */
{

    // Solution Added Start
    Action action_ok = new ShortcutAction("Default key",
            ShortcutAction.KeyCode.ENTER, null);

    Action action_clear = new ShortcutAction("Ctrl+C",
            ShortcutAction.KeyCode.C, new int[] { ShortcutAction.ModifierKey.CTRL });
    // Solution Added End

    private Panel panel;
    private final Button submitButton;
    private final Button clearButton;
    private final TextField textField;
    private final Label result;

    public ExampleForm2() {
        panel = new Panel("Entry form");
        panel.addActionHandler(this);

        result = new Label();

        textField = new TextField("Name");
        submitButton = new Button("Save", e -> result.setValue("Submitted with name " + textField.getValue()));
        submitButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        // Solution removed Start
//        submitButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        // Solution removed End

        clearButton = new Button("Clear", e -> {
            textField.clear();
            result.setValue("");
        });
        // Solution removed Start
//        clearButton.setClickShortcut(ShortcutAction.KeyCode.C, new int[] { ShortcutAction.ModifierKey.CTRL });
        // Solution removed End

        HorizontalLayout buttons = new HorizontalLayout(submitButton, clearButton);
        buttons.setSpacing(true);

        panel.setContent(new VerticalLayout(textField, buttons, result));

        setCompositionRoot(panel);
    }

    /* Solution Added Start */
    @Override
    public Action[] getActions(Object target, Object sender) {
        return new Action[] {action_ok, action_clear};
    }

    @Override
    public void handleAction(Action action, Object sender, Object target) {
        if (action == action_ok) {
            submitButton.click();
        }
        if (action == action_clear) {
            clearButton.click();
        }
    }
    /* Solution Added End */

}
