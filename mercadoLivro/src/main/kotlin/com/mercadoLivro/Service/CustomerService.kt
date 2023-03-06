package com.mercadoLivro.Service

import com.mercadoLivro.Controllers.Request.PostCustomerRequest
import com.mercadoLivro.Controllers.Request.PutCustomerRequest
import com.mercadoLivro.Model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun createCusomer(customer: PostCustomerRequest) {
        val id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

    fun getUserById(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun updateUserById(
        id: String,
        customer: PutCustomerRequest
    ) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteUserById(
        id: String
    ) {
        customers.removeIf { it.id == id }
    }

}