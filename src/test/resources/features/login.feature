Feature: Login feature
  As a user,
  I wan to be able to login
  So I can purchase products

  Scenario Outline: Success Login
    Given I have to navigate to login page
    When I login with "<username>" and "<password>"
    Then I am successfully logged in
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Scenario: Error login - no username
    Given I have to navigate to login page
    When I login with "" and "<password>"
    Then Then I see login error message 'Epic sadface: Username is required’
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |