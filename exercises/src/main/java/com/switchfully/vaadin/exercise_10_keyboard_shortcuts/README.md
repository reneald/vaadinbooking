# Exercise 6 - Validation

![screenshot](exercise.png)

Add the following validation to the form:
* Name is required.
* City is required
* Number of rooms should be between > 0 and < 10000

Submitting the form when there are validation errors should show a warning notification.

## Extra credits
Add the following validation to the form:
* Four and five star hotels should have at least 20 rooms.

**Tip:** You can use a `CommitHandler` on the `BeanFieldGroup` for this.
