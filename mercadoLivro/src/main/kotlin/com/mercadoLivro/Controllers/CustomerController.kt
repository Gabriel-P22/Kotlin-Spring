package com.mercadoLivro.Controllers

import com.mercadoLivro.Controllers.Extensions.toCustomerModel
import com.mercadoLivro.Controllers.Extensions.toResponse
import com.mercadoLivro.Controllers.Request.PostCustomerRequest
import com.mercadoLivro.Controllers.Request.PutCustomerRequest
import com.mercadoLivro.Controllers.Response.CustomerResponse
import com.mercadoLivro.Service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers")
class CustomerController(
    var customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAllCustomers(name).map {
            it.toResponse()
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        return customerService.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): CustomerResponse {
        return customerService.getCustomerById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUserById(
        @PathVariable id: Int,
        @RequestBody customer: PutCustomerRequest
    ) {
        val customerSaved = customerService.getCustomerById(id)
        return customerService.updateUserById(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUserById(
        @PathVariable id: Int
    ) {
        customerService.deleteUserById(id)
    }
}