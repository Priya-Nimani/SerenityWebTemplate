## Automated web tests using Serenity, Cucumber and Maven

# Project Title

A sample example of Serenity framework implementing BDD-style automated acceptance criteria, running against https://www.capitalone.co.uk/creditcards/secure/find-my-card.jsf.

## Getting Started
This project is developed as a template for web based serenity framework. This project can be used 
as a basic building block for implementing Serenity-Cucumber based test pack for any web based application under test.

### Prerequisites
In order to use this framework you need to have JDK 1.8 downloaded
Set compiler setting to Java 8 within project settings
Also you need to add the cucumber for java plugin within your IDE
 
### Setup
JDK 1.8 can be downloaded from
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

For plugin navigate to Settings/Plugins and add the Cucumber for Java plugin

## Running the tests
Create a maven run configuration with following goals-
AcceptanceTestBuildAndRun -

| Test to be executed                            | Command line to use                                                                                                                                 | Comments                                                       |
| -----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------:| --------------------------------------------------------------:|
| Exceute all the tests                          | clean verify -B -Pserenity serenity:aggregate -Dserenity.outputDirectory=./target/site/serenity "-Dcucumber.options=--tags @version=customTestTag   |  Scenarios with tag @version=customTestTag                     |
| To generate the aggregate report               | -Pserenity serenity:aggregate -Dserenity.outputDirectory=./target/site/serenity                                                                     |  Report named 'index.html' generated in `target/site/serenity` |


The URL to run the test against can be specified using webdriver.base.url in the serenity.properties file
 
### Break down into end to end tests
The customeTest.feature is to test the eligibility check webpage for various input combinations

## Built With

* [Serenity-Cucumber](http://thucydides.info/docs/serenity-staging/) - The BDD framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Jenkins](https://jenkins.io/doc/) - Build management

