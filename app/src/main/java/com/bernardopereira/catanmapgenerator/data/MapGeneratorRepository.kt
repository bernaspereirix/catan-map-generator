package com.bernardopereira.catanmapgenerator.data

import com.bernardopereira.catanmapgenerator.data.MapConstants.NUMBER_OF_TILES
import com.bernardopereira.catanmapgenerator.data.entity.MapTile
import com.bernardopereira.catanmapgenerator.data.entity.TileType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class MapGeneratorRepository {

    private val _mapTilesFlow: MutableStateFlow<List<MapTile>> = MutableStateFlow(emptyList())
    val mapTilesFlow: Flow<List<MapTile>> = _mapTilesFlow

    fun generateNewMap() {
        _mapTilesFlow.value = emptyList()

        val tiles = MapConstants.TILES.toMutableList()
        val tileNumbers = MapConstants.TILE_NUMBERS.toMutableList()
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