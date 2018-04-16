# Exercise 10 - Keyboard shortcuts

This exercise contains two forms.<br>
The buttons have keyboard shotcuts defined on them using `Button.setClickShortcut()`.

The problem is that this defines these shortcuts globally.
You will notice that no matter where the focus is, the first form will always submit when pressing enter.

Try to solve this issue by using an `ActionHandler` on the `Panel` in `ExampleForm1` and `ExampleForm2`.

If the focus is on the first form, then the shortcuts should trigger the first form only.
The same should apply for the second form.

For more information, see: https://vaadin.com/docs/v7/framework/advanced/advanced-shortcuts.html
