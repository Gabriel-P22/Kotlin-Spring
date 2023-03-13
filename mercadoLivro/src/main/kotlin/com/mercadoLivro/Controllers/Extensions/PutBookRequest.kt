package com.mercadoLivro.Controllers.Extensions

import com.mercadoLivro.Controllers.Request.PutBookRequest
import com.mercadoLivro.Model.BookModel

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}