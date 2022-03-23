
# Hello

This application is recieving HTTP POST requests with JSON representing matrix of values and returns mirrored copy of it as JSON.

## Usage example:

### url: 
localhost:8080/mirror

Content-Type:application/json

### BODY:
[
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]


## result that we recieve: 

[[3,2,1],[6,5,4],[9,8,7]]








