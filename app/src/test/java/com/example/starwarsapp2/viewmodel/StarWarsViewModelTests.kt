package com.example.starwarsapp2.viewmodel

import com.example.starwarsapp2.data.fake.FakeStarWarsRepository
import com.example.starwarsapp2.data.model.PeopleResponseFixtures
import com.example.starwarsapp2.utils.AssertHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StarWarsViewModelTests {

    private lateinit var fakeStarWarsRepository: FakeStarWarsRepository
    private lateinit var testSubject: StarWarsViewModel

    @Before
    fun setUp() {
        fakeStarWarsRepository = FakeStarWarsRepository()
        testSubject = StarWarsViewModel(fakeStarWarsRepository)
    }

    @Test
    fun `Given a successful response, When getPeople is called, Then return expected response`() {
        // Given
        fakeStarWarsRepository.peopleResponse = PeopleResponseFixtures.success
        testSubject.addCallback(
            StarWarsViewModel.Callback(
                success = {
                    // Then
                    Assert.assertEquals(it, PeopleResponseFixtures.peopleResponse)
                },
                error = {
                    // Not used.
                    AssertHelper.assetNoExecution()
                }
            ))

        // When
        testSubject.getPeople()
    }

    @Test
    fun `Given an error response, When getPeople is called, Then return expected error`() {
        // Given
        fakeStarWarsRepository.peopleResponse = PeopleResponseFixtures.error
        testSubject.addCallback(
            StarWarsViewModel.Callback(
                success = {
                    // Not used.
                    AssertHelper.assetNoExecution()
                },
                error = {
                    // Then
                    Assert.assertEquals(it, PeopleResponseFixtures.error.message())
                }
            ))

        // When
        testSubject.getPeople()
    }
}