Feature: Search Engine results 
Scenario: Verify first results on different browsers and search engines
    Given User is on Search Engine "google" with browser "chrome"
    When User submit the search term "Hi"
    Then first result should be "Hi"
    
  