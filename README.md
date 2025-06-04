# Java Testing Framework - Example Project

## Overview
An example Java project for test automation purpose.
Main purpose is to gather couple of commonly used code snippets under one hood.

Implemented Selenium/WebDriver + Behave for BDD support. 
Supports configuration profiles - resources/<envName>.properties.

## Execution
### Env profile config under
> resources / <testEnv>.properties

### Env profile set in POM under (default test) 
> maven-surefire-plugin / systemPropertyVariables / **testEnv**
> mvn test **-DtestEnv="test"**

### BDD scenarios under
> run runers/TestRunner class with apropriate tag
> mvn test **-Dcucumber.filter.tags="@tag"**
