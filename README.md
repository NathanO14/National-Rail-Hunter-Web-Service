# National-Train-Hunter-Web-Service
National Train Hunter Web Service

## Initial Setup

Generate the extra Java sources to connect to the Live Departure Boards Staff Web Service and compile:  

```./mvnw generate-sources```

### Environment Variables:

| Name                   | Description                                                                                 |  
|------------------------|---------------------------------------------------------------------------------------------|
| LDBSV_TOKEN            | Live Departure Boards Web Service (LDBSVWS / OpenLDBSVWS) token                                 |
| JDBC_DATABASE_URL      | PostgreSQL database URL (e.g. <b>jdbc:postgresql://localhost:5432/nationaltrainhunter</b>)  |
| JDBC_DATABASE_USERNAME | PostgreSQL database username                                                                |
| JDBC_DATABASE_PASSWORD | PostgreSQL database password                                                                |

## Tests

Run tests via the command line:  

```./mvnw test```