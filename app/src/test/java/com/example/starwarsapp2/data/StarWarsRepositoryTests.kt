package com.example.starwarsapp2.data

import com.example.starwarsapp2.data.fake.FakeStarWarsNetwork
import com.example.starwarsapp2.data.model.PeopleResponseFixtures
import com.example.starwarsapp2.data.starwarsapi.repository.StarWarsRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StarWarsRepositoryTests {

    private lateinit var fakeStarWarsNetwork: FakeStarWarsNetwork
    private lateinit var testSubject: StarWarsRepository

    @Before
    fun setUp() {
        fakeStarWarsNetwork = FakeStarWarsNetwork()
        testSubject = StarWarsRepository(fakeStarWarsNetwork)
    }

    @Test
    fun `Given a successful response, When getPeople is called, Then return expected PeopleResponse`() {
        // Given
        fakeStarWarsNetwork.peopleResponse = PeopleResponseFixtures.success

        // When
        val result = testSubject.getPeople()

        // Then
        Assert.assertEquals(PeopleResponseFixtures.peopleResponse, result)
    }

    @Test(expected = IllegalStateException::class)
    fun `Given an error response, When getPeople is called, Then return expected Error`() {
        // Given
        fakeStarWarsNetwork.peopleResponse = PeopleResponseFixtures.error

        // When
        testSubject.getPeople()
    }
}