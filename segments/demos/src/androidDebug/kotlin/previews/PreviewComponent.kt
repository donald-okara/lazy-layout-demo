package previews

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.donald_okara.components.devices.DeviceCatalog
import io.github.donald_okara.components.devices.DeviceFrame
import io.github.donald_okara.components.devices.deviceSafePadding
import ke.don.design.theme.AppTheme

@Composable
fun PreviewComponent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = { Text("Welcome to previews") }
) {
    AppTheme(
        darkTheme = isSystemInDarkTheme().not()
    ){
        Surface(modifier = modifier) {
            Box(
                modifier = Modifier.padding(16.dp)
            ) {
                DeviceFrame(
                    modifier = Modifier,
                    spec = DeviceCatalog.IPhone17.copy(
                        bezel = DeviceCatalog.GalaxyS26.bezel.copy(
                            color = if(isSystemInDarkTheme()) Color(0xFFE8732A) else Color(0xFF303690)
                        )
                    ),
                ){
                    AppTheme{
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Column(
                                modifier = Modifier
                                    .deviceSafePadding()
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                content()
                            }
                        }
                    }
                }
            }
        }
    }

}