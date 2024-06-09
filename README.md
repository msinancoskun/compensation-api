Compensation API

# This is an API created to get compensation data of employees of a company.

*** This is the API Postman collection that can be used to test it.***

# EXAMPLE DATA TO SEARCH FOR
 {
    "id": 294,
    "salary": 0,
    "employer": "",
    "location": "0",
    "yearsAtWork": 0,
    "yearsOfExperience": 0,
    "signInBonus": 0,
    "annualBonus": 0,
    "annualStockBonus": 0,
    "gender": "Male",
    "timestamp": "2017-09-03T10:32:31.000+00:00"
}

*** Only thing to do is to build and run the project on any IDE you would like, -my choice was Visual Studio Code- ***

# There are three main functionalities of this API.
    - filterBy /api/v1/compensation_data?salary=0&gender=Male
    - filterByWithPagination /api/v1/compensation_data?salary=0&page=1&size=2
    - getCompensationWithId /api/v1/compensation_data/123?fields=id,yearsAtWork,yearsOfExperience,gender


# filterBy filters a data based on the properties listed above.
# also a pagination functinality is implemented for all.
# getCompensationWithId lists one compensation data matching with the given id and brings only the fields searched for.


PS: There is a problem with listing the necessary fields that is, yearsOfExperience and yearsAtWork are showing even though not called but their values are 0. If they are called to be listed, then their actual values will be printed as a response.

