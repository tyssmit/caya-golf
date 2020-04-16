package com.globomantics.cayagolf
import android.database.SQLException
import java.sql.Connection
import java.sql.DriverManager
import java.sql.DriverManager.*
import java.sql.Statement
import java.sql.ResultSet
import java.util.Properties

class DatabaseConnection {

    object MySQLDatabaseExampleKotlin {

        private var conn: Connection? = null
        private var username = "cayagolf"
        private var password = "Abcd1234"
        @JvmStatic fun main(args: Array<String>) {
            // make a connection to MySQL Server
            getConnection()

            executeMySQLQuery()
        }
        fun executeMySQLQuery() {
            var stmt: Statement? = null
            var resultset: ResultSet? = null
            try {
                stmt = conn!!.createStatement()
                resultset = stmt!!.executeQuery("SHOW DATABASES;")
                if (stmt.execute("SHOW DATABASES;")) {
                    resultset = stmt.resultSet
                }
                while (resultset!!.next()) {
                    println(resultset.getString("Database"))
                }
            } catch (ex: SQLException) {

                ex.printStackTrace()
            } finally {

                if (resultset != null) {
                    try {
                        resultset.close()
                    } catch (sqlEx: SQLException) {
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close()
                    } catch (sqlEx: SQLException) {
                    }
                }
                if (conn != null) {
                    try {
                        conn!!.close()
                    } catch (sqlEx: SQLException) {
                    }
                    conn = null
                }
            }
        }
        /**
         * This method makes a connection to MySQL Server
         */
        fun getConnection() {
            val connectionProps = Properties()
            connectionProps["user"] = username
            connectionProps["password"] = password
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance()
                conn = getConnection(
                    "jdbc:" + "mysql" + "://" +
                            "caya.database.windows.net" +
                            ":" + "1433" + "/" +
                            "",
                    connectionProps)
            } catch (ex: SQLException) {
                // handle any errors
                ex.printStackTrace()
            } catch (ex: Exception) {
                // handle any errors
                ex.printStackTrace()
            }
        }
    }

}