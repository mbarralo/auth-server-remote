

# auth-server-remote

Simple Authorization server and Resource server communication

```
cd auth-server && mvn spring-boot:run

cd resource-server && mvn spring-boot:run
```


## Steps

### get token from authorization server

```

POST http://localhost:8081/oauth/token

POST /oauth/token HTTP/1.1
Host: localhost:8081
Content-Type: application/x-www-form-urlencoded
Authorization: Basic Y2xpZW50OnNlY3JldA==
Cache-Control: no-cache
Postman-Token: 6d7e768a-b5ef-4bf9-b216-327e2f8c141e

username=user&password=password&grant_type=password&scope=read

```


the client sends the application client & secret as basic auth 
and the username and password in form-urlencoded

---

### request resource from resource server

```
GET http://localhost:8080/ping

headers:
Authorization: Bearer {{token}}
``` 

---

#### notes
 
* resource server needs the url `security.oauth2.resource.user-info-uri=http://localhost:8081/user`
to validate tokens 

* this constant validation can be removed if the resource server supports JWT

