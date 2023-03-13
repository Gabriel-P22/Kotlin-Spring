package com.mercadoLivro.Controllers.Response

import com.mercadoLivro.Enums.BookStatus
import com.mercadoLivro.Model.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)