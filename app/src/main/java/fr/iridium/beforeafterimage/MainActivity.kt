package fr.iridium.beforeafterimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.iridium.before_after_image.BeforeAfterImage
import fr.iridium.beforeafterimage.ui.theme.BeforeAfterImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeforeAfterImageTheme {
                val beforeImage = painterResource(id = R.drawable.before)
                val afterImage = painterResource(id = R.drawable.after)
                BeforeAfterImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.3f)
                        .padding(16.dp)
                        .clip(shape = RoundedCornerShape(16.dp)),
                    beforeImage = beforeImage,
                    afterImage = afterImage
                )

            }
        }
    }
}