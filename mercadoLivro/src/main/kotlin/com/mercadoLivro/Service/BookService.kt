package com.mercadoLivro.Service

import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    var bookRepository: BookRepository
) {

    fun getAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        var book = findBookById(id)
        book.status = BookStatus.deleted
        update(book)
    }

    fun findBookById(id: Int): BookModel {
        return bookRepository.findById(id).get()
    }

    fun getBookForStatus(status: BookStatus): List<BookModel> {
        return bookRepository.findByStatus(status)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }


}
