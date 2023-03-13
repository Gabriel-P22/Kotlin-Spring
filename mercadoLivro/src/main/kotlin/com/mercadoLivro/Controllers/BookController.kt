package com.mercadoLivro.Controllers

import com.mercadoLivro.Controllers.Request.PutBookRequest
import com.mercadoLivro.Controllers.Extensions.toBookModel
import com.mercadoLivro.Service.BookService
import com.mercadoLivro.Controllers.Request.PostBookRequest
import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomerById(request.customerId)
        return bookService.create(request.toBookModel(customer))
    }


    fun getAll(): List<BookModel> {
        return bookService.getAll()
    }

    @GetMapping("/actives")
    fun findActives(): List<BookModel> {
        return bookService.getBookForStatus(BookStatus.Active)
    }

    @GetMapping("/deleted")
    fun findDeleted(): List<BookModel> {
        return bookService.getBookForStatus(BookStatus.deleted)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel {
        return bookService.findBookById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findBookById(id)
        bookService.update(book.toBookModel(bookSaved))
    }
}