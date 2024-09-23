package com.bernardopereira.catanmapgenerator.data.repository

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.Test

internal class MapGeneratorRepositoryTest {

    // Component under test
    private lateinit var cut: MapGeneratorRepository

    @Test
    fun `WHEN generateNewMap THEN update flow`() {
        cut = MapGeneratorRepository()

        cut.mapTilesFlow.value shouldBe null

        cut.generateNewMap()

        cut.mapTilesFlow.value shouldNotBe null
    }
}