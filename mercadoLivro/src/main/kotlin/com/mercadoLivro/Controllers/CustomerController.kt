package com.mercadoLivro.Controllers

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
    fun createCusomer(@RequestBody customer: PostCustomerRequest) {
        return customerService.createCusomer(customer)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): CustomerModel {
        return getUserById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUserById(
        @PathVariable id: String,
        @RequestBody customer: PutCustomerRequest
    ) {
        return customerService.updateUserById(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUserById(
        @PathVariable id: String
    ) {
        return customerService.deleteUserById(id)
    }
}