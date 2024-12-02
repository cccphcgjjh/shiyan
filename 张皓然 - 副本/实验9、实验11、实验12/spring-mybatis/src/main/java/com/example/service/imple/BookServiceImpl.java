package com.example.service.impl;

import com.example.dao.BookMapper;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 书籍服务实现类，实现了书籍相关的业务逻辑方法。
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.listBooks();
    }

    @Override
    public List<Book> listBooksByParams(Map<String, Object> params) {
        return bookMapper.listBooksByParams(params);
    }

    @Override
    public Integer addBook(Book book) {
        bookMapper.insertBook(book);
        return book.getId();
    }

    @Override
    public Integer updateBook(Book book) {
        bookMapper.updateBook(book);
        return book.getId();
    }

    @Override
    public Integer deleteBook(int id) {
        bookMapper.deleteBookById(id);
        return id;
    }

    @Override
    public void deleteBooks(List<String> ids) {
        bookMapper.deleteBooks(ids);
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }
}
