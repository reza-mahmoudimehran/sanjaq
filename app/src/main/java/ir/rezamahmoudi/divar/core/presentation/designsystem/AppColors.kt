package ir.rezamahmoudi.divar.core.presentation.designsystem

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class AppColors(
    val materialColorScheme: ColorScheme,
    val designSystem: DesignSystem = DesignSystem()
)

data class DesignSystem(
    val transparent: Color = TransparentColor,

    val primary: Color = Blue20,
    val primary00: Color = Blue00,
    val primary10: Color = Blue10,
    val primary20: Color = Blue20,
    val primary30: Color = Blue30,
    val primary40: Color = Blue40,

    val secondary: Color = Green10,

    val neutral: Color = White,
    val neutral00: Color = Gray00,
    val neutral10: Color = Gray10,
    val neutral20: Color = Gray20,
    val neutral30: Color = Gray30,
    val neutral40: Color = Gray40,
    val neutral50: Color = Gray50,
    val neutral60: Color = Gray60,
    val neutral70: Color = Gray70,
    val neutral80: Color = Gray80,
    val neutral90: Color = Gray90,

    val primaryBackground: Color = Gray00,

    val primaryCardBackground: Color = Gray10,

    val primaryText: Color = neutral70,
    val secondaryText: Color = Lemon,

    val primaryIconTint: Color = neutral40,

    val primaryDivider: Color = neutral20
)
