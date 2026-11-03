Feature: Landing page

  Scenario Outline: The web elements are visible on the page
    When the landing page is open
    Then <elementByName> is visible
    Examples:
      | elementByName                      |
      | "Solutions"                        |
      | "About Us"                         |
      | "Services"                         |
      | "Products"                         |
      | "Locations"                        |
      | "Admin Page"                       |
      | "Experience the difference"        |
      | "Customer Login"                   |
      | "Username"                         |
      | "Password"                         |
      | "Forgot login info?"               |
      | "Register"                         |
      | "home"                             |
      | "about"                            |
      | "contact"                          |
      | "Withdraw Funds"                   |
      | "Transfer Funds"                   |
      | "Check Balances"                   |
      | "Make Deposits"                    |
      | "ATM Services"                     |
      | "Bill Pay"                         |
      | "Account History"                  |
      | "Transfer Funds"                   |
      | "Read More"                        |
      | "Latest News"                      |
      | "Home"                             |
      | "Site Map"                         |
      | "Contact Us"                       |
      | "© Parasoft. All rights reserved." |
      | "www.parasoft.com"                 |
      | "Online Services"                  |

  Scenario Outline: The inputs are enabled on the page
    When the landing page is open
    Then <elementByInputType> is enabled
    Examples:
      | elementByInputType |
      | "password"         |
      | "submit"           |
      | "text"             |

  Scenario: Open AboutUs page
    When click on About us link
    Then info title on About Us page is displayed

  Scenario: Open Services page
    When click on Services link
    Then services title on Services page is displayed

  Scenario: Successful Login
    When input username, password and click button log in
    Then Accounts Overview Title is displayed

  Scenario: Request loan
    When click on Request loan and input data and click apply button
    Then request processed title displayed

  Scenario: Logout
    When click on logout
    Then username input enabled