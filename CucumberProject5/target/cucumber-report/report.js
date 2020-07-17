$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/ListOfHyperlinks.feature");
formatter.feature({
  "line": 2,
  "name": "Find all hyperlinks on a page and return them as a list",
  "description": "",
  "id": "find-all-hyperlinks-on-a-page-and-return-them-as-a-list",
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
  "name": "Find the hyperlinks on https://www.medibank.com.au/ page and return them as a list",
  "description": "",
  "id": "find-all-hyperlinks-on-a-page-and-return-them-as-a-list;find-the-hyperlinks-on-https://www.medibank.com.au/-page-and-return-them-as-a-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "For the URL: \"https://www.medibank.com.au/\" find the list of hyperlinks and validate them",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.medibank.com.au/",
      "offset": 14
    }
  ],
  "location": "Steps.for_the_URL_find_the_list_of_hyperlinks_and_validate_them(String)"
});
formatter.result({
  "duration": 73953967915,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat stepDefinition.Steps.for_the_URL_find_the_list_of_hyperlinks_and_validate_them(Steps.java:84)\r\n\tat ✽.Given For the URL: \"https://www.medibank.com.au/\" find the list of hyperlinks and validate them(Features/ListOfHyperlinks.feature:5)\r\n",
  "status": "pending"
});
});