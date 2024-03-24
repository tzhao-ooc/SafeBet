# SafeBet

## Documentation

### Features
- User sign up and log in: Allow user to sign up and log in. So far, the application will only direct succesful sign up/ log in to a new page which will re-designed in later iterations.
- Games On Today page: allow user to check daily game events via API integration. We will save game events to database and allow user to select game events to bet.
- User Stat page: So far, we only have a simple template.

### Database
- User table Created: Store userid, username, password and email. We will add more information in later iterations such as role, age, etc.
- current_bets table created: stores relevant bet information that will help determine gain/loss of currency.

### Group Dynamic
- Effective communication
- Solid contributions
- Lots of teamwork
- healthy timeline




## Other Information
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


