# Kotlin + Spring Boot

## you also can reference to these articles
https://ithelp.ithome.com.tw/articles/10250038


## how to register an account
### api/user/register example:
```
curl --location --request POST 'http://localhost:8080/api/user/register' \
--header 'Content-Type: application/json' \
--data-raw '{
  "username": "tim",
  "email": "tim@gmail.com",
  "password": "1qaz2wsx",
  "authorities": ["ROLE_ADMIN"]
}'
```

## how to get JWT token by account and pwd
### /api/authenticate example:
```
curl --location --request POST 'http://localhost:8080/api/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "username": "tim",
  "password": "1qaz2wsx"
}'
```
