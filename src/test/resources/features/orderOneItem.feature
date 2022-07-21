Feature: Order One Item From Online Shop
  Scenārijs
  1. Navigēt uz saiti: https://www.saucedemo.com/
  2. Ielogoties ar pareizu lietotāja vārdu/paroli
  3. Pārbaudīt, vai lietotājs ir ielogojies
  4. Ievietot Grozā 1 produktu
  5. Doties uz grozu
  6. Pārbaudīt, vai šī prece ir grozā
  7. Doties uz Checkout
  8. Ievadīt vārdu/uzvārdu/pasta indeksu
  9. Doties uz Checkout overview lapu, pārbaudīt datus
  10. Doties uz finish lapu un pārbaudīt vai viss notika veiksmīgi
  11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'

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
    When I enter name "Janis"
    And I enter surname "Mutulis"
    And I enter code "LV-1079"
    And click Continue button
    Then I see "https://www.saucedemo.com/checkout-step-two.html" page

    Given I see "https://www.saucedemo.com/checkout-step-two.html" page
    When I see backpack in Checkout overview
    And I click Finish button
    Then I see "https://www.saucedemo.com/checkout-complete.html" page

    Given I see "https://www.saucedemo.com/checkout-complete.html" page
    When I see "THANK YOU FOR YOUR ORDER" in page
    And I click Back Home button
    Then I see "https://www.saucedemo.com/inventory.html" page