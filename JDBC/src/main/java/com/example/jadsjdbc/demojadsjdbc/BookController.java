package com.example.jadsjdbc.demojadsjdbc;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/getBooks")
    public List<Book> getAllBook() throws SQLException{
        return DBOperations.getBooks();
    }

    @PostMapping("/createBook")
    public void createBook(@RequestBody Book book) throws SQLException {
        DBOperations.createBook(book);
    }

    @GetMapping("/getBookById")
    public Book getBookByID(@RequestParam(value = "id") int id) throws SQLException{
        return DBOperations.getBookById(id);
    }

    @PostMapping("/createTable")
    public void createTable(@RequestParam(value = "table_name") String name) throws SQLException {
        DBOperations.createTable(name);
    }
}
