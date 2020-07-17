@tag
Feature: scenario in Cucumber to parse XML and print the values based on tag names.
  Develop a generic method with required input parameters and read the node value. 
  To print number of parent nodes, associated child nodes and read data based on parent tag and chile tag name

  Scenario: To parse the XML and print the values based on tag names
    Given The XML file
    When Document get parsed
    Then I read the values based on the tag names
