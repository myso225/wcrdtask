Simple spring-boot rest api with elastic search repository for merchants
========================================================================

Project is configured for maven build manager. To run this project:
1. Install maven
2. In console navigate to project root folder.
3. Run command: mvn spring-boot:run

Maven will build project and run the rest api on http://localhost:8080/

Data entity:
Merchant(id, name, description, address, latitude, longitude)

To add merchant to elasticsearch repository use POST request with url http://localhost:8080/merchant and header application/json
In post request body send merchant object as json. Json merchant examples:

{"id":"1","name":"Merchant1","description":"Merchant number one is book store.","address":"Južná trieda 1544/7, 040 01 Košice","location":{"lat":48.715866,"lon":21.26065}}
{"id":"2","name":"Merchant2","description":"Merchant number two is bicycle shop.","address":"Letná 7/21, 040 01 Košice","location":{"lat":48.729084,"lon":21.24299}}
{"id":"3","name":"Merchant3","description":"Merchant number three is car parts store.","address":"Košická 11942, 080 01 Prešov-Solivar","location":{"lat":48.971654,"lon":21.253895}}
{"id":"4","name":"Merchant4","description":"Merchant number four is tea shop.","address":"Florianova, 080 01 Presov","location":{"lat":48.996824,"lon":21.238101}}
{"id":"5","name":"Merchant5","description":"Merchant number five is something else.","address":"Lemešany 290, 082 03 Lemešany","location":{"lat":48.849548,"lon":21.272497}}

To get all merchants use GET request with url http://localhost:8080/merchant
To get merchant by id use GET request with url http://localhost:8080/merchant/{id}
Example: http://localhost:8080/merchant/1
To get merchant by name use GET request with url http://localhost:8080/merchant/name/{name}
Example: http://localhost:8080/merchant/name/Merchant1
To get merchant by description use GET request with url http://localhost:8080/merchant/description/{desc}
Example: http://localhost:8080/merchant/description/book
To get merchant by location and distance use GET request with url http://localhost:8080/merchant/lat/{lat}/lon/{lon}/dist/{dist}
Example: http://localhost:8080/merchant/lat/48.967873/lon/21.253605/dist/5km

To update merchant use PUT request with url http://localhost:8080/merchant, header application/json
and request body as json of merchant with particular id and updated field values.

To remove merchant from elasticsearch repository use DELETE request with url http://localhost:8080/merchant/id where id is ID of merchant to be deleted.
