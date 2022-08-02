package com.tuyenhoang.app.connect

import android.os.StrictMode
import android.util.Log
import com.tuyenhoang.app.const.ColumnName
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectSQl {
    private var ip="192.168.0.103"
    private var port="1433"
    private var username="user1"
    private var password="admin"
    private var driver="net.sourceforge.jtds.jdbc.Driver"
    private var database="Project"
    private var url="jdbc:jtds:sqlserver://$ip:$port/$database"
    companion object{
        val instance=ConnectSQl()
    }
    fun connectToSQlServer():Connection?{
        val conn:Connection
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        return try {
            Class.forName(driver)
            conn = DriverManager.getConnection(url,username,password)
            conn
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}