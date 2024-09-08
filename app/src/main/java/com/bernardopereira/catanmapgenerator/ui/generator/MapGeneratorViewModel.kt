package com.bernardopereira.catanmapgenerator.ui.generator

import androidx.lifecycle.ViewModel
import com.bernardopereira.catanmapgenerator.data.MapGeneratorRepository
import com.bernardopereira.catanmapgenerator.data.entity.MapTile
import kotlinx.coroutines.flow.map

data class MapGeneratorUiState(
    val mapTiles: List<MapTile>
)

class MapGeneratorViewModel(
    private val mapGeneratorRepository: MapGeneratorRepository
) : ViewModel() {

    private val _mapTilesFlow = mapGeneratorRepository.mapTilesFlow

    val mapGeneratorUiState = _mapTilesFlow.map { mapTiles ->
        MapGeneratorUiState(mapTiles)
    }

    fun onGenerateButtonClicked() {
        mapGeneratorRepository.generateNewMap()
    }
}