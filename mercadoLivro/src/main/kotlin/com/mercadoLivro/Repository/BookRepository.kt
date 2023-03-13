package com.mercadoLivro.Repository

import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus): List<BookModel>
}