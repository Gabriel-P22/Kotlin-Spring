package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PostCustomerRequest
import com.mercadoLivro.Controllers.Response.CustomerResponse
import com.mercadoLivro.Enums.CustomerStatus
import com.mercadoLivro.Model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}