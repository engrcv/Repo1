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
  "name": "Open the Chrome and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I read Enter the Username and Password from excel \"InFile.xlsx\"",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.open_the_Chrome_and_launch_the_application()"
});
formatter.result({
  "duration": 12252929757,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InFile.xlsx",
      "offset": 51
    }
  ],
  "location": "Steps.enter_the_Username_and_Password(String)"
});
formatter.result({
  "duration": 775918203,
  "status": "passed"
});
});