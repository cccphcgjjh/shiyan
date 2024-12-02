package com.example.dao;

import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    List<Book> listBooks();

    List<Book> listBooksByParams(Map<String, Object> params);

    void insertBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Integer id);

    Book getBookById(Integer id);

    void deleteBooks(List<String> ids);
}
