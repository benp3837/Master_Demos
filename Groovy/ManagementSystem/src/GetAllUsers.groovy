def selectAllUsers() {
    def sql = DBConnectionUtil.getDatabaseConnection()
    try {
        def users = sql.rows('SELECT * FROM users')
        if (users.isEmpty()) {
            println "No users found in the database."
        } else {
            users.each { user ->
                println "User ID: ${user.user_id}, Name: ${user.name}, Username: ${user.username}, Email: ${user.email}"
            }
        }
    } catch (Exception e) {
        println "Error retrieving users: ${e.message}"
    } finally {
        sql.close()
    }
}

// Example usage
selectAllUsers()
