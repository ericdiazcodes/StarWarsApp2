package com.example.starwarsapp2.utils

import org.junit.Assert

object NegativeAssert {

    fun assetNoExecution(message: String) = Assert.fail(message)
}