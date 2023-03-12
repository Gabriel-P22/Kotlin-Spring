package com.mercadoLivro.Repository

import com.mercadoLivro.Model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String): List<CustomerModel>
}