package com.mercadoLivro.Controllers.Response

import com.mercadoLivro.Enums.CustomerStatus
import javax.persistence.*

data class CustomerResponse(
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)


