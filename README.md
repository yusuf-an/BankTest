# BankTest
The App is deployed on https://challange-bank.herokuapp.com/


# This code consist solution for three coding problem into one project devided into packages:
- com.challange.fileParser for challange 1
- com.challange.temperatureCalculator for challange 2
- com.challange.phoneNumber for challange 3


# Rest APIs documentation for phone number problem:
- GET /phone-numbers
### Response:

```javascript
[
  {
    "id": long,
          "customer": {
              "name": string,
              "id": long
          },
          "phoneNumber": string,
     "active": boolean
  }
]
```

- GET /phone-numbers/{customerId}
### Response:

```javascript
[
  {
    "id": long,
          "customer": {
              "name": string,
              "id": long
          },
          "phoneNumber": string,
     "active": boolean
  }
]
```

- POST /activate/{phone-number}
### Response:

```javascript
  {
    "id": long,
          "customer": {
              "name": string,
              "id": long
          },
          "phoneNumber": string,
     "active": boolean
  }
```
