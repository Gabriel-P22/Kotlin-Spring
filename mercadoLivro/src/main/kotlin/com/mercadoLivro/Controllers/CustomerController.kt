package com.mercadoLivro.Controllers

import com.mercadoLivro.Controllers.Extensions.toCustomerModel
import com.mercadoLivro.Controllers.Request.PostCustomerRequest
import com.mercadoLivro.Controllers.Request.PutCustomerRequest
import com.mercadoLivro.Model.CustomerModel
import com.mercadoLivro.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers")
class CustomerController(
    var customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAllCustomers(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        return customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): CustomerModel {
        return customerService.getUserById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUserById(
        @PathVariable id: Int,
        @RequestBody customer: PutCustomerRequest
    ) {
        return customerService.updateUserById(id, customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUserById(
        @PathVariable id: Int
    ) {
        return customerService.deleteUserById(id)
    }
}