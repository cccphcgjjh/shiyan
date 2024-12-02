package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import com.example.config.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 书籍控制器，处理与书籍相关的HTTP请求。
 */
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/list")
    public List<Book> listBooks(@RequestParam Map<String, Object> params) {
        System.out.println("listBooks by params===" + params);
        return bookService.listBooksByParams(params);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) throws Exception {
        System.out.println("addBook===");
        Utils.printValues(book);
        bookService.addBook(book);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        System.out.println("deleteBook by id===" + id);
        bookService.deleteBook(id);
        return "success";
    }

    @PostMapping("/deleteByIds")
    public String deleteBooksByIds(@RequestBody List<String> ids) {
        System.out.println("deleteBooks by ids===" + ids);
        bookService.deleteBooks(ids);
        return "success";
    }

    @PostMapping("/update")
    public String updateBook(@RequestBody Book book) throws Exception {
        Utils.printValues(book);
        bookService.updateBook(book);
        return "success";
    }
}
