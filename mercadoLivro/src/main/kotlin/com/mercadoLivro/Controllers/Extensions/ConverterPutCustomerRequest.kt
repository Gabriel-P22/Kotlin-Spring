package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PutCustomerRequest
import com.mercadoLivro.Model.CustomerModel

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}