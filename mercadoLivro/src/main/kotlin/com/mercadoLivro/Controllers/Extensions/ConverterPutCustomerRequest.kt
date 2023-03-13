package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PutCustomerRequest
import com.mercadoLivro.Model.CustomerModel

fun PutCustomerRequest.toCustomerModel(previusValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previusValue.id,
        name = this.name,
        email = this.email,
        status = previusValue.status
    )
}