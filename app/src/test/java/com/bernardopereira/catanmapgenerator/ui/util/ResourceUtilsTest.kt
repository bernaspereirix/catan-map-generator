package com.bernardopereira.catanmapgenerator.ui.util

import com.bernardopereira.catanmapgenerator.R
import com.bernardopereira.catanmapgenerator.data.entity.TileType
import io.kotlintest.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ResourceUtilsTest {

    @ParameterizedTest
    @MethodSource("getTestResources")
    fun `WHEN getTileBackgroundImage THEN return correct resource`(
        tileType: TileType,
        expectedResource: Int,
    ) {
        val result = ResourceUtils.getTileBackgroundImage(tileType)
        result shouldBe expectedResource
    }

    companion object {
        @JvmStatic
        fun getTestResources(): List<Arguments> =
            listOf(
                Arguments.of(TileType.DESERT, R.drawable.desert_tile),
                Arguments.of(TileType.ORE, R.drawable.ore_tile),
                Arguments.of(TileType.BRICK, R.drawable.brick_tile),
                Arguments.of(TileType.WOOD, R.drawable.wood_tile),
                Arguments.of(TileType.SHEEP, R.drawable.sheep_tile),
                Arguments.of(TileType.WHEAT, R.drawable.wheat_tile),
            )
    }
}