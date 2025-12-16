def insertUser(name, username, email) {
    def sql = DBConnectionUtil.getDatabaseConnection()
    try {
        sql.executeInsert('''
            INSERT INTO users (name, username, email)
            VALUES (?, ?, ?)
        ''', [name, username, email])
        println "User inserted successfully: $name"
    } catch (Exception e) {
        println "Error inserting user: ${e.message}"
    } finally {
        sql.close()
    }
}

// Example usage
insertUser("Jane Doe", "jjianedoe", "jane.doe@revature.com")