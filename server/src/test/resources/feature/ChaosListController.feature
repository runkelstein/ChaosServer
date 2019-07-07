Feature: ChaosList Controller

  Background:
  * url 'http://127.0.0.1:8080/'
  * configure logPrettyRequest = true
  * configure logPrettyResponse = true

  Scenario: Fetch all lists for user
    Given  path '/chaosList/listing'
    When method GET
    Then status 200
    And match response ==
    """
  [
    { "id": 1, "name": "Simple List" },
    { "id": 2, "name": "Simple List 2" },
    { "id": 3, "name": "Frauen ansprechen" },
    { "id": 4, "name": "Simple List 3" }
  ]
  """

  Scenario: Fetch a list
    Given path '/chaosList/get/2'
    When method GET
    Then status 200
    And match response == { "id": 2, "name": "Simple List 2", "doc": {"title":"Simple List 2", items: []} }

  Scenario: Add, Change and Delete a List
    Given path '/chaosList/create'
      And request { "name": "yipee", "doc": {"title":"yipee", items: []}  }
      When method POST
      Then status 201
      And match response == { id: #number, "name": "yipee", "doc":  #present }
      * def listId = response.id
      * print listId

    Given path '/chaosList/change/' + listId
      And request { "name": "changed", "doc": {"title":"changed", items: []}   }
      When method PUT
      Then status 200
      And match response == { id: '#(listId)', "name": "changed", "doc": {"title":"changed", items: []} }

    Given path '/chaosList/delete/' + listId
      When method DELETE
      Then status 200

  Scenario: return status code 404 for non existing lists
    Given path '/chaosList/get/42'
      When method GET
      Then status 404

    Given path '/chaosList/change/77'
      And request { "name": "77" }
      When method PUT
      Then status 404