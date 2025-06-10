@GrabConfig(systemClassLoader=true)
@Grab('org.postgresql:postgresql:42.2.5')
import groovy.sql.Sql

//This method will create and return a connection to our database - look how easy it is to write methods!
//We'll call to this in each of our scripts that need to access the database
static def getDatabaseConnection() {
    def dbUrl = "jdbc:postgresql://groovydb.c38eiwk4ka29.us-east-1.rds.amazonaws.com:5432/postgres"
    def dbUser = "postgres"
    def dbPassword = "password"
    return Sql.newInstance(dbUrl, dbUser, dbPassword, "org.postgresql.Driver")
}


/* No need to run this code below - I used it to create the DB table we'll be working with

try {

    sql = getDatabaseConnection()

    sql.execute('''
        CREATE TABLE IF NOT EXISTS users (
            user_id SERIAL PRIMARY KEY,
            name TEXT NOT NULL,
            username TEXT NOT NULL UNIQUE,
            email TEXT UNIQUE
        )
    ''')
    println "Table 'users' created successfully"
} catch (Exception e) {
    println "Error creating table: ${e.getMessage()}"
} finally {
    sql.close()
}

*/