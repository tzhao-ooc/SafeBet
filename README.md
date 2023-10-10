# SafeBet

### PostgreSQL installation 

[download](https://www.postgresql.org/download/) version 15

```code
# succeed if you can run this in terminal
psql --help

## or for mac os, run
brew install postgresql@15
## you may need add path to your .bash / .zshrc file to run psql commands in terminal
```
-  When we deploy our application, we should use the internal database connection to secure our database.  
  In case I forget to switch back to external connection, here's how to change it
``` code
  # in resources/application.properties
  # comment out
  spring.datasource.url=jdbc:postgresql://dpg-cki4s0ce1qns73f52amg-a/safebetdb
  # add
  spring.datasource.url=jdbc:postgresql://dpg-cki4s0ce1qns73f52amg-a.oregon-postgres.render.com/safebetdb
```
#### Information needed for DB connection:
-   Databse: safebetdb
-   Username:safebetdb_user
-   Password:rt85WlKak3ZupBshE4KZ7Jq78prGAlhq
-   Internal Database URL: postgres://safebetdb_user:rt85WlKak3ZupBshE4KZ7Jq78prGAlhq@dpg-cki4s0ce1qns73f52amg-a/safebetdb
-   External Database URL: postgres://safebetdb_user:rt85WlKak3ZupBshE4KZ7Jq78prGAlhq@dpg-cki4s0ce1qns73f52amg-a.oregon-postgres.render.com/safebetdb
-   PSQL Command: 
-     PASSWORD=rt85WlKak3ZupBshE4KZ7Jq78prGAlhq psql -h dpg-cki4s0ce1qns73f52amg-a.oregon-postgres.render.com -U safebetdb_user safebetdb


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


