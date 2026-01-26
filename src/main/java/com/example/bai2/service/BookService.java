package com.example.bai2.service;

import com.example.bai2.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    
    private List<Book> books = new ArrayList<>(List.of(
        new Book(1, "Lập trình Java", "Nguyễn Văn A"),
        new Book(2, "Spring Boot", "Trần Quang Thiện"),
        new Book(3, "Microservices", "Lê Văn C")
    ));

    // Lấy tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách mới
    public void addBook(Book book) {
        books.add(book);
    }

    // Cập nhật sách
    public void updateBook(int id, Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    // Xóa sách
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
