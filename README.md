# National-Train-Hunter-Web-Service
National Train Hunter Web Service

##Initial Setup

Generate the extra Java sources to connect to NR API and compile
./mvnw generate-sources

To run tests, pass in the LDB Token
./mvnw test -DLDB_TOKEN={YOUR_TOKEN_VALUE}

### Environment Variables:

| Name                   | Description                                                                                 |  
|------------------------|---------------------------------------------------------------------------------------------|
| LDB_TOKEN              | Live Departure Boards Web Service (LDBWS / OpenLDBWS) token                                 |
| JDBC_DATABASE_URL      | PostgreSQL database URL (e.g. <b>jdbc:postgresql://localhost:5432/nationaltrainhunter</b>)  |
| JDBC_DATABASE_USERNAME | PostgreSQL database username                                                                |
| JDBC_DATABASE_PASSWORD | PostgreSQL database password                                                                |
