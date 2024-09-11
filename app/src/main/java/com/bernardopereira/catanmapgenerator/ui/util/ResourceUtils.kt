package com.bernardopereira.catanmapgenerator.ui.util

import com.bernardopereira.catanmapgenerator.R
import com.bernardopereira.catanmapgenerator.data.entity.TileType

object ResourceUtils {
    fun getTileBackgroundImage(tileType: TileType): Int {
        return when (tileType) {
            TileType.DESERT -> R.drawable.desert_tile
            TileType.ORE -> R.drawable.ore_tile
            TileType.BRICK -> R.drawable.brick_tile
            TileType.WOOD -> R.drawable.wood_tile
            TileType.SHEEP -> R.drawable.sheep_tile
            TileType.WHEAT -> R.drawable.wheat_tile
        }
    }
}