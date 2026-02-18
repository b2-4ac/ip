# Epsilon User Guide

![// Product screenshot goes here](Ui.png)

Welcome to the User Guide for Epsilon, a Task Tracking Application.

## Adding Tasks: `todo`, `deadline` and `event`

Adds a task to your current list of tasks.
All dates (e.g. DEADLINE, START, END) are to be entered in YYYY-MM-DD format.

Adding a "To Do" task (A Task with no Time Aspect):
Format: `todo TITLE`

Adding a "Deadline" task (A Task with a Deadline):
Format: `deadline TITLE /by DEADLINE`

Adding a "Event" task (A Task with a Start and End date):
Format: `event TITLE /from START /to END`

Examples:
 - `todo Buy Milk`
 - `deadline Submit Project /by 2026-02-20`
 - `event Career Fair /from 2026-06-14 /to 2026-06-18`

## Listing All Tasks: `list`

Prints a list of all current recorded tasks.

Format: `list`

```
> list

1. /T/[ ] Buy Milk
2. /D/[ ] Submit Project (by: Feb 20 2026)
3. /E/[ ] Career Fair (from: Jun 14 2026 to: Jun 18 2026)
```

## Marking Tasks: `mark`

Marks a specified Task as Completed.

Format: `mark ID`

Example:
 - `mark 2`

```
> mark 2

Task marked as Completed. Good Job!

> list

1. /T/[ ] Buy Milk
2. /D/[X] Submit Project (by: Feb 20 2026)
3. /E/[ ] Career Fair (from: Jun 14 2026 to: Jun 18 2026)
```

## Unmarking Tasks: `unmark`

Unmarks a specified Task, that task is now incomplete.

Format: `unmark ID`

Example:
 - `unmark 1`

```
> list

1. /T/[X] Buy Milk
2. /D/[X] Submit Project (by: Feb 20 2026)
3. /E/[ ] Career Fair (from: Jun 14 2026 to: Jun 18 2026)

> unmark 1

Task as been reset. Get it done soon!

> list

1. /T/[ ] Buy Milk
2. /D/[X] Submit Project (by: Feb 20 2026)
3. /E/[ ] Career Fair (from: Jun 14 2026 to: Jun 18 2026)

```

## Deleting Tasks: `delete`

Deletes a specified task from the list.

Format: `delete ID`

Example:
 - `delete 3`

```
> delete 3

Task removed succcessfully.

> list

1. /T/[ ] Buy Milk
2. /D/[X] Submit Project (by: Feb 20 2026)
```

## Finding Tasks: `find`

Searches the current list of tasks for tasks that contain a specified string.

Format: `find SEARCH_STRING`

Example:
 - `find Submit`

```
> find Submit

1. /D/[X] Submit Project (by: Feb 20 2026)
```

## Show Upcoming Tasks: `upcoming`

Shows all Deadline tasks that are due within a week, as well as Event tasks that start within a week.

Format: `upcoming`

```
> list

1. /T/[ ] Buy Milk
2. /D/[X] Submit Project (by: Feb 20 2026)
3. /D/[ ] Return Book (by: Feb 22 2026)
4. /E/[ ] Career Fair (from: Jun 14 2026 to: Jun 18 2026)

> upcoming

1. /D/[X] Submit Project (by: Feb 20 2026)
2. /D/[ ] Return Book (by: Feb 22 2026)
```

## Exit Application: `bye`

Saves all currently written tasks and exits the application.

Format: `bye`
