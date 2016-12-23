package com.sandburman.quickstart;

import java.util.*;
import static java.util.stream.Collectors.*;
import java.sql.*;

import com.sandburman.obj.*;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // List<String> names = Arrays.asList("Tom", "Jerry", "Jack", "Jill");
        //
        // System.out.println( "Hello World!" );
        //
        // System.out.println(
        //     names.stream()
        //          .map(String::toUpperCase)
        //          .collect(joining(", "))
        // );

    }

    static {
      try {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    private static Connection getConnection() throws SQLException {
      return DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB", "sandeep", "@Dolby786");
    }

    private static void persistBlog (Blog blog) {
      String query = "INSERT INTO BLOG (ID, NAME, CONTENT) VALUES (?,?,?)";

      try {
        PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setLong(1, blog.getId());
        stmt.setString(1, blog.getName());
        stmt.setString(1, blog.getContent());

        stmt.executeUpdate();

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
