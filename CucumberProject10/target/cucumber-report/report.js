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
  "name": "1_Attra products and services",
  "description": "",
  "id": "login-and-verify-the-inbox-for-unread-gmails;1-attra-products-and-services",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I launch Attra.com website and extract the list of services",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.get_Products_services_Attra()"
});
formatter.result({
  "duration": 28882260201,
  "status": "passed"
});
formatter.after({
  "duration": 681770328,
  "status": "passed"
});
});