package fr.iridium.before_after_image

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BeforeAfterImage(
    modifier: Modifier = Modifier,
    beforeImage: @Composable () -> Unit = {},
    afterImage: @Composable () -> Unit = {},
    beforeLabel: String,
    afterLabel: String,
    thumb: @Composable () -> Unit
) {

//    for animation
    var offset by remember { mutableFloatStateOf(0.5f) }
    var animate by remember { mutableStateOf(false) }
    val animationOffset by animateFloatAsState(
        targetValue = offset, animationSpec = tween(
            durationMillis = 500, easing = EaseInOutCubic
        ), finishedListener = {
            animate = false
        }, label = ""
    )

    Box(
        modifier = modifier, contentAlignment = Alignment.TopCenter
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .drawWithContent {
                clipRect(right = size.width * if (animate) animationOffset else offset) {
                    this@drawWithContent.drawContent()
                }
            }) {
            beforeImage()
            if (beforeLabel.isNotEmpty()) {
                Surface(color = Color.Transparent,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .clickable {
                            offset = 1f
                            animate = true
                        }
                        .padding(horizontal = 8.dp, vertical = 4.dp)) {
                    Text(text = beforeLabel, style = TextStyle(color = Color.White))
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    clipRect(left = size.width * if (animate) animationOffset else offset) {
                        this@drawWithContent.drawContent()
                    }
                }) {
            afterImage()
            if (afterLabel.isNotEmpty()) {
                Surface(color = Color.Transparent,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .clickable {
                            offset = 0f
                            animate = true
                        }
                        .padding(horizontal = 8.dp, vertical = 4.dp)) {
                    Text(text = afterLabel, style = TextStyle(color = Color.White))
                }
            }
        }
        Slider(
            value = if (animate) animationOffset else offset,
            valueRange = 0f..1f,
            onValueChange = {
                offset = it
                animate = false
            },
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Transparent, inactiveTrackColor = Color.Transparent
            ),
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            thumb = {
                thumb()
            },
        )
    }
}

@Composable
fun BeforeAfterImage(
    modifier: Modifier = Modifier,
    beforeImageUrl: String,
    afterImageUrl: String,
    beforeLabel: String = "Before",
    afterLabel: String = "After",
    thumb: @Composable () -> Unit = { CustomThumb() }
) {
    BeforeAfterImage(modifier = modifier, beforeImage = {
        AsyncImage(
            model = beforeImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }, afterImage = {
        AsyncImage(
            model = afterImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }, beforeLabel = beforeLabel, afterLabel = afterLabel, thumb = thumb
    )
}

@Composable
fun BeforeAfterImage(
    beforeImage: Painter,
    afterImage: Painter,
    modifier: Modifier = Modifier,
    beboreLabel: String = "Before",
    afterLabel: String = "After",
    thumb: @Composable () -> Unit = { CustomThumb() }
) {
    BeforeAfterImage(modifier = modifier, beforeImage = {
        Image(
            painter = beforeImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }, afterImage = {
        Image(
            painter = afterImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }, beforeLabel = beboreLabel, afterLabel = afterLabel, thumb = thumb
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomThumb() {
    SliderDefaults.Thumb(
        interactionSource = remember { MutableInteractionSource() },
        thumbSize = DpSize(30.dp, 30.dp),
        colors = SliderDefaults.colors(
            thumbColor = Color.White.copy(alpha = 0.6f)
        ),
        modifier = Modifier.border(
            2.dp, Color.Black.copy(alpha = 0.6f), RoundedCornerShape(100)
        )
    )
}