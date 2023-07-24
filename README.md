# Automated API tests for [Reqres.in](https://reqres.in)

## :pushpin: Content:

- [Stack of technologies](#computer-stack-of-technologies)
- [Running tests](#running_woman-running-tests)
- [Test cases](#page_facing_up-test-cases)
- [Build in Jenkins](#-build-in-jenkins)
- [Allure report](#-allure-report)
- [Allure TestOps Integration](#-allure-testops-integration)
- [Jira Integration](#-jira-integration)
- [Telegram notifications](#-telegram-notifications)


## :computer: Stack of technologies

<p align="center">
<a href="https://www.java.com/"><img width="5%" title="Java" src="images/logo/Java.svg"></a>
<a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></a>
<a href="https://github.com/"><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></a>
<a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="images/logo/JUnit5.svg"></a>
<a href="https://gradle.org/"><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></a>
<a href="https://docs.qameta.io/allure/"><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></a>
<a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="images/logo/Jira.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></a>
<a href="https://rest-assured.io/"><img width="5%" title="RestAssured" src="images/logo/RestAssured.svg"></a>
</p>


## :running_woman: Running tests

#### To run tests:

```
gradle clean test
```


### File *config.properties*
To run tests locally, you need to add the <code>config.properties</code> file to the resources folder <code>(src/test/resources/)</code>. The following properties must be specified in this file:
```
username=username
jobName=jobName
email=email
password=password
```


## :page_facing_up: Test cases

* Check user id
* Check for non-existent user
* Check user ids
* Check user creation
* Check successful registration
* Check failed registration without password
* Check user deletion


## <img width="5%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Build in [Jenkins](https://jenkins.autotests.cloud/job/diploma_api_lebedevich/)
<p align="center">
<img title="Jenkins Build" src="images/screens/JenkinsBuild.png">

</p>


## <img width="5%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.svg"> [Allure](https://jenkins.autotests.cloud/job/diploma_api_lebedevich/1/allure/) report
### Overview

<p align="center">
<img title="Allure Overview" src="images/screens/AllureReport1.png">
</p>

### Test result

<p align="center">
<img title="Test Results in Allure" src="images/screens/AllureReport2.png">
</p>


## <img width="5%" style="vertical-align:middle" title="Allure TestOps Report" src="images/logo/Allure_TO.svg"> [Allure TestOps](https://allure.autotests.cloud/launch/27535) Integration

<p align="center">
<img title="Test Results in Allure" src="images/screens/AllureTestOps.png">
</p>


## <img width="5%" style="vertical-align:middle" title="Jira Integration" src="images/logo/Jira.svg"> [Jira](https://jira.autotests.cloud/browse/HOMEWORK-806) Integration

And also we can see from <code>Jira</code>, which tests been added to <code>Allure</code> with their statuses

<p align="center">
<img title="Allure Overview" src="images/screens/JiraResults.png">
</p>


## <img width="5%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications

<p align="center">
<img width="50%" title="Telegram Notifications" src="images/screens/telegram.png">
</p>