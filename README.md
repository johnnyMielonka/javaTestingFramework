# Java Testing Framework - Example Project

## Overview
An example Java project for test automation purpose.
Main purpose is to gather a couple of commonly used code snippets under one hood.

- Implemented Selenium/WebDriver + Cucumber for BDD support.
- Basic setup of REST Assured.
- Supports configuration profiles - resources/\<name\>.properties.

## Execution
### Env profile config under
> resources / \<testEnv\>.properties
> 

### Env profile set in POM under (default test)
> maven-surefire-plugin / systemPropertyVariables / **testEnv**\
> mvn test **-DtestEnv="test"**

### BDD scenarios under
> run runers/TestRunner class with apropriate tag\
> mvn test **-Dcucumber.filter.tags="@tag"**