# ParaBank - Bank Website Automation 
[ParaBank](https://parabank.parasoft.com/parabank/index.htm) 

## Scope of the project 
ParaBank is a demo site used for demonstration of Parasoft software solutions.
The test automation project for ParaBank is covering UI and API acceptance testing.

## Concepts Included
* OOP
* Parallel test runs
* POJO - Plain Old Java Object 
* Common WEB page interaction methods
* Common API interaction methods
* Commonly used test utility classes

## Tools
* Maven
* JUnit
* TestNG
* Selenium WebDriver
* Lombok
* Spring 

## Requirements
In order to utilise this project you need to have the following installed locally:
* Maven 
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in the configuration)
* Java 

## Usage
The project is bases on OOP Principles, therefore the Page Objects are separated by the test scripts.
The packages are named as follows:

**pages**
1. BasePage (contains the utility methods)
2. MainPage (contains the main page selectors and behaviour)

**pojos** (created with *Lombok Tool*)
1. Customer

**services** (contains the utility methods for the **pojos** package )
1. CustomerServices

**tests**
1. BaseTests (contains the general setup for the classes and for the tests)
2. MainTests (contains the login tests)

The project is divided in UI acceptance test and API tests. 

## Reporting

## Project status
* initial phase: in progress


