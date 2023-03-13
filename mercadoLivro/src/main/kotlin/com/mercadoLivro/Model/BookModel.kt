package com.mercadoLivro.Model

import com.mercadoLivro.Enums.BookStatus
import java.awt.print.Book
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

    ) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if(field == BookStatus.DELETED || field == BookStatus.CANCELED)
                throw Exception("it is not possible to change the book with the status ${field}")
            field = value
        }

    constructor(id: Int? = null,
            name: String,
            price: BigDecimal,
            customer: CustomerModel? = null,
            status: BookStatus?): this(id, name, price, customer) {
                this.status = status
            }
}