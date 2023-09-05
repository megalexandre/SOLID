package solid.s.dto

import solid.s.CustomerType

data class Customer (
    val customerType: CustomerType,
    val documentNumber: DocumentNumber,
    val phoneNumbers: List<PhoneNumber>,
)

data class DocumentNumber(
    val number: String
)

data class PhoneNumber(
    val preferential: Boolean,
    val number: String,
)

