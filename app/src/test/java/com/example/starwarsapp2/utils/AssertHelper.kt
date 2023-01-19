package com.example.starwarsapp2.utils

import org.junit.Assert

object AssertHelper {

    fun assetNoExecution() = Assert.fail("This should not execute.")
}