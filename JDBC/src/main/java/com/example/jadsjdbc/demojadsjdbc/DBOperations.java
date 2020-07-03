package com.example.jadsjdbc.demojadsjdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations extends Connection {

    private static java.sql.Connection connection;

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "piyushagg@5807");
    }

    // protocol + type_of_db + host url + port_no + db_name

    public static void createTable(String name) throws SQLException {

        getConnection();
        Statement statement = connection.createStatement();
        boolean result = statement.execute("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, book_name VARCHAR(30), " +
                "author_name VARCHAR(30), cost INT)");

        if(result){
            System.out.println("Table: " + name + " has been created successfully");
        }else{
            System.out.println("Table: " + name +" has not been created");
        }

        connection.close();

    }

    public static void createBook(Book book) throws SQLException {

        getConnection();

        // if you are taking table name in the parameter, you need to ensure that table exists, if not create that table first

        PreparedStatement statement = connection.prepareStatement("INSERT INTO my_books(book_name, author_name, cost) " +
                "VALUES (?, ?, ?)");

        statement.setString(1, book.getBook_name());
        statement.setString(2, book.getAuthor_name());
        statement.setInt(3, book.getCost());

        int rows_affected = statement.executeUpdate();

        if(rows_affected >= 1){
            System.out.println(rows_affected + " rows are affected");
        }else{
            System.out.println("Unable to insert in the table");
        }

        connection.close();
    }

    public static List<Book> getBooks() throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from my_books");

        List<Book> book_list = new ArrayList<>();

        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = new Book(id, book_name, author_name, cost);
            book_list.add(book);
        }

        connection.close();

        return book_list;
    }

    public static Book getBookById(int id) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from my_books where id = " + id);

        Book book = null;

        while(resultSet.next()){

            int book_id = resultSet.getInt(1);
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            book = new Book(id, book_name, author_name, cost);
        }

        connection.close();
        return book;
    }

}
