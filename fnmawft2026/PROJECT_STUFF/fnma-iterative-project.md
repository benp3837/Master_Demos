# FNMA TTP Iterative Project - Loan Management Portal

## Executive Summary

The Loan Management Portal will emulate a real-world web application for financial loan application processing. Core features include user account and profile creation, submission and management of loan applications, and role-based privileges. After logging in, Users have the ability to edit their profile and loan applications. Managers have the ability to view, edit, approve, or reject any outstanding loan applications. Users can create and manage multiple simultaneous loan applications.

New Functionalities and Technologies will be added to the Loan Management Portal over the course of 4 iterations.

---

## Baseline User Stories

- As a User, I should be able to open a new User Account
- As a User, I should be able to apply for a new Loan
- As a User, I should be able to view/edit/close all my pending Loan Applications
- As a User, I should be able to edit my Profile Information
- As a Manager, I should be able to open a new Manager Account
- As a Manager, I should be able to view/edit/approve/reject any pending Loan Applications

- **As a User or Manager, I cannot perform any of the above functionalities without logging in first.**

- Add 2 more User Stories determined by the developer and approved by the trainer. Be creative :)
    - As a [User/Manager], I ...
    - As a [User/Manager], I ...

---

## Technologies & Iterations

### Iteration I – Weeks 1–5 – INDIVIDUAL (Due 8/14)
**Stack:** Java, SQL, JDBC, Javalin, Postman, JUnit, Gradle

- The back-end system will use JDBC which manages a connection to a SQL database
- The middle tier will use Javalin for dynamic web application development
- The middle tier will follow proper layered architecture and have 60%+ test coverage of the service layer 

**PRESENTATION DATE: 8/14**

- The presentation is just another 1-1 check in with me
- You will show your functionalities through Postman (yes, if you made a front end you can skip Postman)
- Then you'll run your tests
- I may ask a question or two but I won't grill you

---

### Iteration II – Weeks 6–8 – INDIVIDUAL or PAIR (You can present on 9/3 OR 9/8)
**Tech Stack:** Spring Boot (with Spring Data and Spring Web), Partial Front End with HTML/CSS/JS or Angular

- Backend technologies replaced with Spring Boot 
- Service Layer Testing and Logging are required
- At least 6 user stories must be FULL STACK (HTTP requests sent from a Front End application instead of Postman)
   - Login is mandatory full stack functionality, and counts for 1 of the 6.

**PRESENTATION**

- Slides are not required but are encouraged. See the example slides in this directory
- Present the project's functionality through the Front End, and Postman.
- Presentations should be 10 minutes MAX. Shoot for 5-7.
- These presentations will be in front of the cohort.

---

### Iteration III – Week 9-11 – GROUP (Due 9/22)

**Tech Stack:** Spring Boot, Angular/TypeScript, Python, AWS (possibly but... probably not)

- Service Layer Testing and Logging are required

**Additional User Stories:**
- As a User, I can request other users to join a loan application. Requested Users get a notification.
- As a User receiving a request to join a loan application, I can approve or reject the request.
- Use Python for A NEW "CREATIVE" USER STORY. Come up with something useful/cool together! This could be anything from Data Visualization (Graphs etc.), Data Analysis, or external communications like email notifications.


**PRESENTATION**

- Slides are required. See the example slides in this directory.
- Present the project's functionality through the Angular webpage. Don't show any code.
- Then, show off your test coverage and a quick look at the logs.
- Presentations should be 20 minutes MAX. Shoot for 10-15 minutes.
- These presentations will be in front of both cohorts, as well as Revature + FNMA internals (including your team leads, possibly).

---


### General Project Timeline

| Milestone | Date |
|---|---|
| Project Start | 7/20 |
| Iteration 1 Check-in 1 | 8/07 |
| Iteration 1 Check-in 2 (submission) | 8/14 |
| Iteration 2 Check-in | 8/28 |
| Iteration 2 Presentation (submission) | 9/4 |
| Iteration 3 Dry Run (in person for Reston) | 9/21 |
| Iteration 3 Presentation (in person for Reston) | 9/22 |
