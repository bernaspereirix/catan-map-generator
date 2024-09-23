package com.bernardopereira.catanmapgenerator.ui.generator

import com.bernardopereira.catanmapgenerator.data.repository.MapGeneratorRepository
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.Test

internal class MapGeneratorViewModelTest {

    private val mockMapGeneratorRepository = mockk<MapGeneratorRepository>(relaxed = true)

    // Component under test
    private lateinit var cut: MapGeneratorViewModel

    @Test
    fun `WHEN generate new map button is clicked THEN call repository`() {
        every { mockMapGeneratorRepository.generateNewMap() } just runs
        cut = MapGeneratorViewModel(mockMapGeneratorRepository)

        cut.onGenerateButtonClicked()

        verify { mockMapGeneratorRepository.generateNewMap() }
    }
}