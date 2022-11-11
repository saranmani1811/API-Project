@Address
Feature: Address Module API Automation

  @Reg
  Scenario Outline: Verify add new address to the application through API
    Given User should add headers
    When User should add required data for adding the address "<first_name>", "<last_name>", "<mobile>", "<apartment>", <state>, <city>, <country>, "<zipcode>", "<address>" and "<address_type>"
    And User should send "POST" request to AddAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addAddress response body message matches "Address added successfully" and get the address id saved

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Mani       | Kandan    | 1234567898 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

  Scenario Outline: Verify update address in the application through API
    Given User should add headers
    When User should add required data for updating the address "<first_name>", "<last_name>", "<mobile>", "<apartment>", <state>, <city>, <country>, "<zipcode>", "<address>" and "<address_type>"
    And User should send "PUT" request to UpdateAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateAddress response body message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Mani       | Kandan    | 1234567898 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

  Scenario: Verify get address from the appilcation through API
    Given User should add headers
    When User should send "GET" request to getAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getaddress response body message matches "OK"

  Scenario: Verify delete address from the application through API
    Given User should add headers
    When User should add addressId in request body for deleting the address
    And User should send "DELETE" request to deleteaddress endpoint
    Then User should verify the status code is 200
    And User should verify the deleteAddress response body message matches "Address deleted successfully"
