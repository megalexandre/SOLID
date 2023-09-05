package solid.s.repository

import org.springframework.stereotype.Repository
import solid.s.dto.Customer

@Repository
class CustomerRepository {

    fun save(customer: Customer): Customer = customer

}