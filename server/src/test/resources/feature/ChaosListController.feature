Feature: ChaosList Controller

Background:
* url 'http://127.0.0.1:8080/'
* configure logPrettyRequest = true
* configure logPrettyResponse = true


Scenario: Fetch a list
Given path '/chaosList/get/1'
When method GET
Then status 200
And match $ == { "id": 1, "name": "Simple List", "items": [] }


Scenario: Add an Item
Given path '/chaosList/create'
And request { "name": "yipee" }
When method POST
Then status 201
And match $ == { id: #number, "name": "yipee", "items": #present }
