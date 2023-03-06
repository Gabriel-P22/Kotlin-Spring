package com.mercadoLivro.Service

import com.mercadoLivro.Model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun createCustomer(customer: CustomerModel) {
        val id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id?.toInt()!! + 1
        }.toString()

        customer.id = id

        customers.add(customer)
    }

    fun getUserById(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun updateUserById(
        id: String,
        customer: CustomerModel
    ) {
        customers.filter { it.id == customer.id }.first().let {
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