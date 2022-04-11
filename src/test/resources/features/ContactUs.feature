Feature: Contact Us

  Scenario Outline: Contact us form
    Given Home page is open
    When I click on Contact us link
    And I select Subject <heading>
    And I enter <email> into Email address field
    And I enter <order> into Order reference field
    And I enter <message> into Message field
    And I click Send button
    Then The text <alert> appears

    Examples:
      | heading          | email            | order                      | message      | alert                                               |
      | Webmaster        | hope@example.com | 13                         | Hello world! | Your message has been successfully sent to our team.|
      | Customer service | hope@example.com | lskdfjlsjfd48739563$%$^%$! | Hi there!    | Your message has been successfully sent to our team.|

