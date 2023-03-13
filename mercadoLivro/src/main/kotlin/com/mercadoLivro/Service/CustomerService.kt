package com.mercadoLivro.Service

import com.mercadoLivro.Enums.CustomerStatus
import com.mercadoLivro.Model.CustomerModel
import com.mercadoLivro.Repository.CustomerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).get()
    }

    fun updateUserById(
        customer: CustomerModel
    ) {
      if(!customerRepository.existsById(customer.id!!)) {
          throw Exception()
      }
        customerRepository.save(customer)
    }

    fun deleteUserById(
        id: Int
    ) {
       val customer = getCustomerById(id)
        bookService.deleteByCustomer(customer)
        customer.status = CustomerStatus.DISABLED
        customerRepository.save(customer)
    }
}