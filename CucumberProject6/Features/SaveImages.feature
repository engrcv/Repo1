@tag
Feature: For any website that allows you to save images such as myntra.com,
- Find list of images on the page 
- Save it into a folder 
- it should accept two input parameters URL and folder path 

  Scenario: Find the list of images on myntra.com page and save them in a folder
    Given For the URL: "https://www.myntra.com/kurtas" find the list of images and save them in a "C:\Users\User\eclipse-workspace\CucumberProject6\Images" 

