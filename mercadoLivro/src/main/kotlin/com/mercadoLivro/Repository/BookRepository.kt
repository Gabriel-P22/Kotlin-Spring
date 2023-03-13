package com.mercadoLivro.Repository

import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable

interface BookRepository: JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(status: CustomerModel): List<BookModel>
}