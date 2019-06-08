Feature: ChaosItem Controller

  Background:
    * url 'http://127.0.0.1:8080/'
    * configure logPrettyRequest = true
    * configure logPrettyResponse = true

  Scenario: Add an Item to a List
    Given path 'chaosItem/add/'
      And request
        """
        {
          "item":
          {
            "done": false,
            "content": "Simple Entry"
          },
          "idList": 1
        }
        """
      When method POST
      Then status 200
      * def idItem = response.id
    Given path 'chaosItem/add/'
      And request
      """
        {
          "item":
          {
            "done": true,
            "content": "Sub Entry"
          },
          "idItem": '#(idItem)'
        }
      """
      When method POST
      Then status 200
    Given path '/chaosList/get/1'
      When method GET
      Then status 200
      And match response ==
        """
        {
          "id": 1,
          "name": "Simple List",
          "items": [
            {
              "id": '#(idItem)',
              "done": false,
              "content": "Simple Entry",
              "items": [
                  {
                    "id": #number,
                    "done": true,
                    "content": "Sub Entry",
                    "items": #present
                  }
              ]
            }
          ]
        }
        """

  Scenario: return Client error if ListId and ItemId is missing
    Given path 'chaosItem/add/'
    And request
        """
        {
          "item":
          {
            "done": false,
            "content": "No id"
          }
        }
        """
    When method POST
    Then status 400