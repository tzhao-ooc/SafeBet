# SafeBet

### PostgreSQL installation 

[download](https://www.postgresql.org/download/)

```code
# succeed if you can run this in terminal
psql --help
```


### Using docker to test if the application ready to Deploy:

[download](https://docs.docker.com/engine/install/)

```code
# create image
docker build -t safebetapp .
# view existing images
docker images
# run image
docker run -p 8080:8080 safebetapp

```
You can now using localhost:8080 to access the application through docker image.


