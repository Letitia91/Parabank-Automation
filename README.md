# ParaBank - Bank Website Automation 
[ParaBank](https://parabank.parasoft.com/parabank/index.htm) 

## Scope of the project 
ParaBank is a demo site used for demonstration of Parasoft software solutions.
The test automation project for ParaBank is covering UI and API acceptance testing.

## Installation
* Java
* Maven
* Chrome
* Lombok Plugin
* Recommendation: IntelliJ IDEA (programming environment)

## Concepts Included
* OOP
* Parallel test runs
* POJO - Plain Old Java Object 
* Common WEB page interaction methods
* Common API interaction methods
* Commonly used test utility classes

## Tools
* Maven
* TestNG
* Selenium WebDriver
* Lombok
* Spring 
* WebDriver Manager

## Requirements
In order to utilise this project you need to have the following installed locally:
* Maven 
* Java 

## Usage
The project is bases on OOP Principles, therefore the Page Objects are separated by the test scripts.
To facilitate a lean process, two "bases" have been created:
* BasePage which contains the utility methods
* BaseTests which contains the general setup for the classes and for the tests

The packages are named as follows:

**pages**
1. MainPage (contains the main page selectors)

**pojos** (created with *Lombok Tool*)
1. Customer

**services** (contains the utility methods for the **pojos** package )
1. CustomerServices

**steps** (contains the methods specific for every page)
1. Forgot login steps

**tests** (contains the tests specific for every page)
1. MainTests

The project is divided in UI acceptance test and API tests. 

## Reporting
* TBD

## Project status
* initial phase: in progress


