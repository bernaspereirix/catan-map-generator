package com.bernardopereira.catanmapgenerator.data.repository

import com.bernardopereira.catanmapgenerator.data.MapConstants
import com.bernardopereira.catanmapgenerator.data.MapConstants.NUMBER_OF_TILES
import com.bernardopereira.catanmapgenerator.data.entity.MapTile
import com.bernardopereira.catanmapgenerator.data.entity.TileType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class MapGeneratorRepository {

    private val _mapTilesFlow: MutableStateFlow<List<MapTile>?> = MutableStateFlow(null)
    val mapTilesFlow: StateFlow<List<MapTile>?> = _mapTilesFlow

    fun generateNewMap() {
        val tiles = MapConstants.tiles.toMutableList()
        val tileNumbers = MapConstants.tileNumbers.toMutableList()
        val newTileList = mutableListOf<MapTile>()
        (1..NUMBER_OF_TILES).map {
            val randomTileMap = tiles[Random.nextInt(tiles.size)]
            if (randomTileMap == TileType.DESERT) {
                // 0 is reserved for the desert tile
                newTileList.add(MapTile(0, TileType.DESERT))
                tiles.remove(TileType.DESERT)
            } else {
                val randomTileNumber = tileNumbers[Random.nextInt(tileNumbers.size)]
                newTileList.add(MapTile(randomTileNumber, randomTileMap))
                tiles.remove(randomTileMap)
                tileNumbers.remove(randomTileNumber)
            }
        }
        _mapTilesFlow.value = newTileList
    }
}