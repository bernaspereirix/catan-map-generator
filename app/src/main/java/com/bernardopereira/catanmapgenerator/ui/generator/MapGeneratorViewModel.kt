package com.bernardopereira.catanmapgenerator.ui.generator

import androidx.lifecycle.ViewModel
import com.bernardopereira.catanmapgenerator.data.entity.MapTile
import com.bernardopereira.catanmapgenerator.data.repository.MapGeneratorRepository
import kotlinx.coroutines.flow.StateFlow

class MapGeneratorViewModel(
    private val mapGeneratorRepository: MapGeneratorRepository
) : ViewModel() {

    private val _mapTiles = mapGeneratorRepository.mapTilesFlow
    val mapTiles: StateFlow<List<MapTile>?> = _mapTiles

    fun onGenerateButtonClicked() {
        mapGeneratorRepository.generateNewMap()
    }
}