# Exercise 12 - Model View Presenter

Try to implement the existing code (the solution for Exercise 5) by using the Model-View-Presenter pattern instead.

Remember: 
* Only the `View` can contain Vaadin-specific code.
* Only the `Model` should contain actual business logic.
* `View` and `Model` do not depend on each other or the `Presenter`.
* The `Presenter` depends on the `View` (the interface of it), and listens to events from it.
* The `Presenter` also depends on the `Model` and listens to events from it.

## Extra credits
Write an (integration) test for the `Presenter` using the actual model, mocks for the services, and a test stub implementing the View interface
