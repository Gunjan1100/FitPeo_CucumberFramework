
  Feature: Fitpeo Revenue Page Validation

    Background: Steps common for all scenarios
      Given From the homepage, navigate to the Revenue Calculator Page

    @fitpeo01
  Scenario:   Adjust the slider value

    When Scroll down the page until the revenue calculator slider is visible
    And Adjust the slider to set its value and bottom text field value should be updated
    And select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474
    And Take the screenshot
   Then Validate value  enter in textbox



