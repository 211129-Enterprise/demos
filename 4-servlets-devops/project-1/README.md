# Project 1 - Custom Object Relational Mapping Framework
>***:clock2: Due Monday Jan. 10th, 2022***

## Description

This project will be to create a custom object relational mapping (ORM) framework. This framework will allow for a simplified and SQL-free interaction with the relational data source. The requirements of the project are purposefully vague, the intention is to allow for you to be creative in your implementation of this framework. There are many ways that this task can be approached, and you are encouraged to explore existing Java ORM implementations in order to get some inspiration. Some suggested features that your ORM can provide are:

1. A public API that can be added as a dependency in other projects

2. File-based or programmatic configuration of entities

3. Programmatic persistence of entities (basic CRUD support)
  - Think of the `save()` and `get()` metthod's from Hibernate's `Session` interface.

4. Basic transaction management (begin, commit, savepoint, rollback)

5. Connection pooling

6. Lightweight session creation

7. Session-based caching to minimize calls to the database

It is encouraged that you provide clear documentation on how to use your framework in the form of a `README.md` file example [here](https://github.com/210823-Enterprise/demos/edit/main/4-servlets-devops/project-1/p1-sample-readme.md).

<br>

## Tech Stack
- [ ] Java 8
- [ ] JUnit
- [ ] Apache Maven
- [ ] PostGreSQL deployed on AWS RDS
- [ ] Git VCS (on GitHub)

### Stretch Goals
- [ ] For presentation, add a web layer with servlets, and a simple user interface to demonstrate CRUD operations.
- [ ] Deploy your demo on an EC2
- [ ] Monitor code quality with SonarCloud CI

<br>

## Init Instructions
- Create a new repository on your own GitHub (naming convention: `orm_name_p1`; with `orm_name` being replaced by the name of your custom framework)

<br>

## Presentation
- [ ] Finalized version of framework must be pushed to your repository within this organization by the presentation date (Sept. 27th, 2021)
- [ ] 10-15 minute live demonstration of the implemented features using a **demo application** to showcase the ORM's functionality
- *You will be presenting ***Monday Jan. 10th, 2022***

<br>

## Workflow Tips
- [ ] Use a [kanban board](https://www.atlassian.com/agile/kanban/boards) like [Trello](https://trello.com/en-US) for task management.
- [ ] Technically this is not *Team* project, but I strongly reccomend you work with others to ask questions and generate ideas.
- [ ] Research popular ORM's like [these](https://en.wikipedia.org/wiki/List_of_object%E2%80%93relational_mapping_software)
