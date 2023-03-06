package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PostCustomerRequest
import com.mercadoLivro.Model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}