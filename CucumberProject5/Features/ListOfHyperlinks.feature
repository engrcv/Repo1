@tag
Feature: Find all hyperlinks on a page and return them as a list

  Scenario: Find the hyperlinks on https://www.medibank.com.au/ page and return them as a list
    Given For the URL: "https://www.medibank.com.au/" find the list of hyperlinks and validate them 

