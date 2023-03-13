package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PostBookRequest
import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.BookModel
import com.mercadoLivro.Model.CustomerModel

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.Active,
        customer = customer
    )
}