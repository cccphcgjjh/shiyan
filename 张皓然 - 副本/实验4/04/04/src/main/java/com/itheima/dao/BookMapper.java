package com.itheima.dao;

import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // 插入一条新的记录
    @Insert("INSERT INTO books(book_name, price, author) VALUES(#{bookName}, #{price}, #{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBook(Book book);

    // 根据 ID 删除记录
    @Delete("DELETE FROM books WHERE id = #{id}")
    int deleteBookById(Integer id);

    // 更新记录
    @Update("UPDATE books SET book_name=#{bookName}, price=#{price}, author=#{author} WHERE id=#{id}")
    int updateBook(Book book);

    // 根据 ID 查询记录
    @Select("SELECT * FROM books WHERE id = #{id}")
    Book selectBookById(Integer id);

    // 查询所有记录
    @Select("SELECT * FROM books")
    List<Book> selectAllBooks();
}