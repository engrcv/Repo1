$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/ParseXML.feature");
formatter.feature({
  "line": 2,
  "name": "scenario in Cucumber to parse XML and print the values based on tag names.",
  "description": "Develop a generic method with required input parameters and read the node value. \nTo print number of parent nodes, associated child nodes and read data based on parent tag and chile tag name",
  "id": "scenario-in-cucumber-to-parse-xml-and-print-the-values-based-on-tag-names.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "To parse the XML and print the values based on tag names",
  "description": "",
  "id": "scenario-in-cucumber-to-parse-xml-and-print-the-values-based-on-tag-names.;to-parse-the-xml-and-print-the-values-based-on-tag-names",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "The XML file",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Document get parsed",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I read the values based on the tag names",
  "keyword": "Then "
});
formatter.match({
  "location": "MyXMLParserJDOM2.main()"
});
formatter.result({
  "duration": 438879935,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});