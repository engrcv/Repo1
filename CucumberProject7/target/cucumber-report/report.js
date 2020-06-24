$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/SaveImages.feature");
formatter.feature({
  "line": 2,
  "name": "For any website that allows you to save images such as myntra.com,",
  "description": "- Find list of images on the page \n- Save it into a folder \n- it should accept two input parameters URL and folder path",
  "id": "for-any-website-that-allows-you-to-save-images-such-as-myntra.com,",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Find the list of images on myntra.com page and save them in a folder",
  "description": "",
  "id": "for-any-website-that-allows-you-to-save-images-such-as-myntra.com,;find-the-list-of-images-on-myntra.com-page-and-save-them-in-a-folder",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "For the URL: \"https://www.myntra.com/kurtas?f\u003dGender%3Amen%20women%2Cwomen\" find the list of images and save them in a \"C:\\Users\\User\\eclipse-workspace\\CucumberProject6\\Images\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.myntra.com/kurtas?f\u003dGender%3Amen%20women%2Cwomen",
      "offset": 14
    },
    {
      "val": "C:\\Users\\User\\eclipse-workspace\\CucumberProject6\\Images",
      "offset": 120
    }
  ],
  "location": "Steps.for_the_URL_find_the_list_of_images_and_save_them_in_a(String,String)"
});
formatter.result({
  "duration": 28953329136,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat stepDefinition.Steps.for_the_URL_find_the_list_of_images_and_save_them_in_a(Steps.java:63)\r\n\tat ✽.Given For the URL: \"https://www.myntra.com/kurtas?f\u003dGender%3Amen%20women%2Cwomen\" find the list of images and save them in a \"C:\\Users\\User\\eclipse-workspace\\CucumberProject6\\Images\"(Features/SaveImages.feature:8)\r\n",
  "status": "pending"
});
});