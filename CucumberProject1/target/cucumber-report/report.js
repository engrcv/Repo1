$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login and verify the Inbox for unread Gmails",
  "description": "",
  "id": "login-and-verify-the-inbox-for-unread-gmails",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Login to Gmail with user Credentials",
  "description": "",
  "id": "login-and-verify-the-inbox-for-unread-gmails;login-to-gmail-with-user-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Open the Chrome, launch the application and fetch data from excel",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I read Enter the Username and Password",
  "keyword": "When "
});
formatter.match({
  "location": "Log4j_Logging_TC.open_the_Chrome_and_launch_the_application()"
});
formatter.result({
  "duration": 7535096899,
  "status": "passed"
});
formatter.match({
  "location": "Log4j_Logging_TC.enter_the_Username_and_Password()"
});
formatter.result({
  "duration": 10922983917,
  "status": "passed"
});
});