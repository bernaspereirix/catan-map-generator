package com.bernardopereira.catanmapgenerator.data

import com.bernardopereira.catanmapgenerator.data.entity.TileType

object MapConstants {
    val TILE_NUMBERS = listOf(2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12)
    val MOST_FREQUENT_NUMBERS = listOf(6, 8)
    val TILES = listOf(
        TileType.DESERT,
        TileType.ORE,
        TileType.ORE,
        TileType.ORE,
        TileType.WOOD,
        TileType.WOOD,
        TileType.WOOD,
        TileType.WOOD,
        TileType.BRICK,
        TileType.BRICK,
        TileType.BRICK,
        TileType.SHEEP,
        TileType.SHEEP,
        TileType.SHEEP,
        TileType.SHEEP,
        TileType.WHEAT,
        TileType.WHEAT,
        TileType.WHEAT,
        TileType.WHEAT,
    )

    const val NUMBER_OF_TILES = 19
}