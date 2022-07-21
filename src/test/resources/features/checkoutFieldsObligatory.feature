Feature: Check if Checkout page fields are obligatory
  1. Navigēt uz saiti: https://www.saucedemo.com/
  2. Ielogoties ar pareizu lietotāja vārdu/paroli
  3. Doties uz grozu
  4. Doties uz Checkout
  5. Pārbaudīt, vai FirstName/LastName/Zip code ir obligāts
  6. Pārbaudīt, vai forma parāda pareizu kļūdas paziņojumu pie katra neievadītā lauka

  Scenario: Order One Item From Online Shop
    Given I have to navigate to login page
    When I login with "standard_user" and "secret_sauce"
    Then I am successfully logged in

    Given I am successfully logged in
    When I add one item to the cart
    Then I see that item in the cart

    Given I see that item in the cart
    When I go to checkout
    Then I see "https://www.saucedemo.com/checkout-step-one.html" page

    Given I see "https://www.saucedemo.com/checkout-step-one.html" page
    When click Continue button
    Then I see "Error: First Name is required" in page

    Given I see "https://www.saucedemo.com/checkout-step-one.html" page
    When I enter name "Janis"
    And click Continue button
    Then I see "Error: Last Name is required" in page

    Given I see "https://www.saucedemo.com/checkout-step-one.html" page
    When I enter surname "Mutulis"
    And click Continue button
    Then I see "Error: Postal Code is required" in page

    Given I see "https://www.saucedemo.com/checkout-step-one.html" page
    When I enter code "LV-1079"
    And click Continue button
    Then I see "https://www.saucedemo.com/checkout-step-two.html" page