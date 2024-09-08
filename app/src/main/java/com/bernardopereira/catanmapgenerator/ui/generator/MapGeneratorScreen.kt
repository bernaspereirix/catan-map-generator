package com.bernardopereira.catanmapgenerator.ui.generator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardopereira.catanmapgenerator.R
import com.bernardopereira.catanmapgenerator.data.MapConstants.mostFrequentNumbers
import com.bernardopereira.catanmapgenerator.data.MapGeneratorRepository
import com.bernardopereira.catanmapgenerator.data.entity.MapTile
import com.bernardopereira.catanmapgenerator.data.entity.TileType
import com.bernardopereira.catanmapgenerator.ui.shape.HexagonShape
import com.bernardopereira.catanmapgenerator.ui.theme.CatanRed
import com.bernardopereira.catanmapgenerator.ui.theme.CatanYellow
import com.bernardopereira.catanmapgenerator.ui.theme.Ocean
import com.bernardopereira.catanmapgenerator.ui.theme.Sand

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapGeneratorScreen(
    viewModel: MapGeneratorViewModel = MapGeneratorViewModel(MapGeneratorRepository())
) {
    val mapGeneratorUiState by viewModel.mapGeneratorUiState.collectAsState(null)
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = context.getString(R.string.app_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                },
                colors = TopAppBarColors(
                    containerColor = CatanRed,
                    scrolledContainerColor = CatanRed,
                    navigationIconContentColor = CatanRed,
                    titleContentColor = CatanYellow,
                    actionIconContentColor = CatanRed
                )
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            GameMap(mapGeneratorUiState?.mapTiles)
            Button(
                onClick = { viewModel.onGenerateButtonClicked() },
            ) {
                Text(text = context.getString(R.string.generate_map_bt))
            }
        }
    }
}

@Composable
private fun GameMap(tileList: List<MapTile>?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Sand, HexagonShape(true))
            .border(7.dp, Ocean, HexagonShape(true))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 80.dp, start = 18.dp)
        ) {
            if (tileList?.isNotEmpty() == true) {
                PopulatedMap(tileList)
            } else {
                BlankMap()
            }
        }
    }
}

@Composable
private fun PopulatedMap(tileList: List<MapTile>?) {
    var listIndex = 0
    // First row
    Row {
        tileList?.slice(IntRange(listIndex, 2))?.forEach {
            HexTile(it)
            listIndex++
        }
    }
    // Second row
    Row(modifier = Modifier.offset(y = (-19).dp)) {
        tileList?.slice(IntRange(listIndex, 6))?.forEach {
            HexTile(it)
            listIndex++
        }
    }
    // Third row
    Row(modifier = Modifier.offset(y = (-38).dp)) {
        tileList?.slice(IntRange(listIndex, 11))?.forEach {
            HexTile(it)
            listIndex++
        }
    }
    // Fourth row
    Row(modifier = Modifier.offset(y = (-57).dp)) {
        tileList?.slice(IntRange(listIndex, 15))?.forEach {
            HexTile(it)
            listIndex++
        }
    }
    // Fifth row
    Row(modifier = Modifier.offset(y = (-76).dp)) {
        tileList?.slice(IntRange(listIndex, tileList.size - 1))?.forEach {
            HexTile(it)
            listIndex++
        }
    }
}

@Composable
private fun BlankMap() {
    // First row
    Row {
        (0..2).map {
            BlankTile()
        }
    }
    // Second row
    Row(modifier = Modifier.offset(y = (-19).dp)) {
        (0..3).map {
            BlankTile()
        }
    }
    // Third row
    Row(modifier = Modifier.offset(y = (-38).dp)) {
        (0..4).map {
            BlankTile()
        }
    }
    // Fourth row
    Row(modifier = Modifier.offset(y = (-57).dp)) {
        (0..3).map {
            BlankTile()
        }
    }
    // Fifth row
    Row(modifier = Modifier.offset(y = (-76).dp)) {
        (0..2).map {
            BlankTile()
        }
    }
}

@Composable
private fun HexTile(tile: MapTile) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(75.dp)
            .border(0.5.dp, Color.Black, HexagonShape(false))
            .paint(
                painterResource(getTileBackgroundImage(tile.type)),
                contentScale = ContentScale.FillBounds
            )
    ) {
        if (tile.type != TileType.DESERT) {
            TileNumber(tile.number)
        }
    }
}

@Composable
private fun BlankTile() {
    Box(
        modifier = Modifier
            .size(75.dp)
            .clip(HexagonShape(false))
            .border(0.5.dp, Color.Black, HexagonShape(false))
            .background(Color.White)
    )
}

@Composable
private fun TileNumber(number: Int) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(30.dp)
            .aspectRatio(1f)
            .background(Sand, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = if (number in mostFrequentNumbers) {
                Color.Red
            } else {
                Color.Black
            }
        )
    }
}

private fun getTileBackgroundImage(tileType: TileType): Int {
    return when (tileType) {
        TileType.DESERT -> R.drawable.desert_tile
        TileType.ORE -> R.drawable.ore_tile
        TileType.BRICK -> R.drawable.brick_tile
        TileType.WOOD -> R.drawable.wood_tile
        TileType.SHEEP -> R.drawable.sheep_tile
        TileType.WHEAT -> R.drawable.wheat_tile
    }
}
