package com.mercadoLivro.Service

import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Model.CustomerModel
import com.mercadoLivro.Repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class BookService(
    var bookRepository: BookRepository
) {

    fun getAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        var book = findBookById(id)
        book.status = BookStatus.DELETED
        update(book)
    }

    fun findBookById(id: Int): BookModel {
        return bookRepository.findById(id).get()
    }

    fun getBookForStatus(status: BookStatus, pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(status, pageable)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for(book in books) {
            book.status = BookStatus.DELETED
        }
        bookRepository.saveAll(books)
    }
}
