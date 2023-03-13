package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PostBookRequest
import com.mercadoLivro.Controllers.Response.BookResponse
import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Model.CustomerModel

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun BookModel.toBookResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer
    )
}