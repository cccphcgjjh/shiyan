package com.example.service;

import com.example.entity.Book;
import java.util.List;
import java.util.Map;

/**
 * 书籍服务接口，定义了书籍相关的业务逻辑方法。
 */
public interface BookService {

    /**
     * 查询所有书籍。
     * @return 书籍列表
     */
    List<Book> getAllBooks();

    /**
     * 根据参数查询书籍。
     * @param params 参数映射
     * @return 书籍列表
     */
    List<Book> listBooksByParams(Map<String, Object> params);

    /**
     * 添加一本新书。
     * @param book 书籍对象
     * @return 书籍ID
     */
    Integer addBook(Book book);

    /**
     * 更新一本书的信息。
     * @param book 书籍对象
     * @return 书籍ID
     */
    Integer updateBook(Book book);

    /**
     * 根据ID删除一本书。
     * @param id 书籍ID
     * @return 书籍ID
     */
    Integer deleteBook(int id);

    /**
     * 根据多个ID删除多本书。
     * @param ids 书籍ID列表
     */
    void deleteBooks(List<String> ids);

    /**
     * 根据ID查询一本书。
     * @param id 书籍ID
     * @return 书籍对象
     */
    Book getBookById(int id);
}
