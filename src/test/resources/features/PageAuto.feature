Feature: MUTA navigator
  see the subpage "Contáctanos".
  Filling out the form to recycle with MUTA without sending the form.
  Scenario:  The user can access the contact us subpage and fill in the form incorrectly.
    Given The user navigate to mutaworld.com
    When The user navigates to the Contactanos subpage
    And The user does not fill in the form
    Then User simulates form submission failure
    Then The form is cleared

    Scenario:  The user can access the contact us subpage and fill in the form correctly.
      Given The user navigate to mutaworld.com
      When The user navigates to the Contactanos subpage
      And The user fills out the form with valid information
      Then The user successfully simulates sending the form
      Then The form is cleared

  Scenario:  The user can access the contact us subpage and fill in the form incorrectly.
    Given The user navigate to mutaworld.com
    When The user navigates to the Contactanos subpage
    And The user fills out the form with invalid information
    Then The user successfully simulates sending the form
    Then The form is cleared







