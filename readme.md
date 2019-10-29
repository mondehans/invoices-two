Running the application
=========================

git clone https://github.com/mondehans/invoices-two
cd invoices-two
mvn clean install
java -jar target/invoices-0.0.1-SNAPSHOT.jar

URLs 
=========
http://localhost:9080/swagger-ui.html
http://localhost:9080/v2/api-docs

http://localhost:9080/invoices



curl -X POST -H 'Content-Type: application/json' -i http://localhost:9080/invoices --data '{
  "client": "monde1",
  "id": 0,
  "invoiceDate": "2019-10-29T08:46:23.839Z",
  "lineItems": [
    {
      "description": "first item12",
      "quantity": 10,
      "unitPrice": 20
    }
  ],
  "subTotal": 0,
  "total": 0,
  "vat": 0,
  "vatRate": 0
}'

curl -X GET -H 'Content-Type: application/json' -i http://localhost:9080/invoices 

curl -X GET -H 'Content-Type: application/json' -i http://localhost:9080/invoices/1
