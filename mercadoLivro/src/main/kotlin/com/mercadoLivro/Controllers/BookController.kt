package com.mercadoLivro.Controllers

import com.mercadoLivro.Controllers.Request.PutBookRequest
import com.mercadoLivro.Controllers.Extensions.toBookModel
import com.mercadoLivro.Controllers.Extensions.toBookResponse
import com.mercadoLivro.Service.BookService
import com.mercadoLivro.Controllers.Request.PostBookRequest
import com.mercadoLivro.Controllers.Response.BookResponse
import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Service.CustomerService
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

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

    @GetMapping
    fun getAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getAll(pageable).map {
            it.toBookResponse()
        }
    }

    @GetMapping("/actives")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getBookForStatus(BookStatus.ACTIVE, pageable).map {
            it.toBookResponse()
        }
    }

    @GetMapping("/deleted")
    fun findDeleted(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getBookForStatus(BookStatus.DELETED, pageable).map {
            it.toBookResponse()
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse {
        return bookService.findBookById(id).toBookResponse()
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