package solid.s.services

import org.springframework.stereotype.Service
import solid.s.CustomerType.INDIVIDUAL
import solid.s.CustomerType.LEGAL
import solid.s.dto.Customer
import solid.s.dto.PhoneNumber
import solid.s.repository.CustomerRepository

@Service
class CustomerService(
    val customerRepository: CustomerRepository
    ){

    fun saveCustomer(customer: Customer){
        if(validDocumentNumber(customer) && validPhoneNumber(customer.phoneNumbers)){
            customerRepository.save(customer)
        }
    }

    private fun validDocumentNumber(customer: Customer): Boolean =
        when(customer.customerType){
            LEGAL -> customer.documentNumber.number.length == 14
            INDIVIDUAL -> customer.documentNumber.number.length == 11
        }


    private fun validPhoneNumber(phoneNumbers: List<PhoneNumber>?): Boolean{
        if(!phoneNumbers.isNullOrEmpty()){

            if (phoneNumbers.none { it.preferential }) {
                return false
            }

            if (phoneNumbers.count { it.preferential } > 1) {
               return false
            }
        }

        return true
    }

}