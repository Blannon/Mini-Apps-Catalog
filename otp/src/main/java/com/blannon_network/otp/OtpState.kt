package com.blannon_network.otp

data class OtpState(
    val code: List<Int?> = (1 ..4).map { null },
    val isFocusedIndex :Int? = null,
    val isvalid: Boolean? = null
)
