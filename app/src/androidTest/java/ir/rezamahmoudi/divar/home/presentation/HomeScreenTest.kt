package ir.rezamahmoudi.divar.home.presentation

import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import ir.rezamahmoudi.divar.app.presentation.mainactivity.MainActivity
import ir.rezamahmoudi.divar.core.presentation.designsystem.DivarTheme
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_POST_ROW_DTO_TEST_OBJECT_1
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_POST_ROW_DTO_TEST_OBJECT_2
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_POST_ROW_DTO_TEST_OBJECT_3
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_TITLE_ROW_DTO_TEST_OBJECT
import ir.rezamahmoudi.divar.core.util.test.TestTagConstants.IMAGE_SLIDER_ROW_ITEM_TEST_TAG
import ir.rezamahmoudi.divar.core.util.test.TestTagConstants.POST_ROW_ITEM_TEST_TAG
import ir.rezamahmoudi.divar.core.util.test.TestTagConstants.TITLE_ROW_ITEM_TEST_TAG
import ir.rezamahmoudi.divar.home.presentation.screen.HomeScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HomeScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            DivarTheme {
                HomeScreen(onNavigateToScreen = {}, navigateUp = {})
            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible() {
        composeRule.onNodeWithTag(TITLE_ROW_ITEM_TEST_TAG).assertIsDisplayed()
        composeRule.onNodeWithText(WIDGET_TITLE_ROW_DTO_TEST_OBJECT.data.text).assertIsDisplayed()

        composeRule.onAllNodesWithTag(POST_ROW_ITEM_TEST_TAG)[0].assertIsDisplayed()
        composeRule.onAllNodesWithTag(POST_ROW_ITEM_TEST_TAG)[1].assertIsDisplayed()
        composeRule.onAllNodesWithTag(POST_ROW_ITEM_TEST_TAG)[2].assertIsDisplayed()

        composeRule.onNodeWithText(WIDGET_POST_ROW_DTO_TEST_OBJECT_1.data.title).assertIsDisplayed()
        composeRule.onNodeWithText(WIDGET_POST_ROW_DTO_TEST_OBJECT_2.data.title).assertIsDisplayed()
        composeRule.onNodeWithText(WIDGET_POST_ROW_DTO_TEST_OBJECT_3.data.title).assertIsDisplayed()

        composeRule.onNodeWithTag(IMAGE_SLIDER_ROW_ITEM_TEST_TAG).assertDoesNotExist()
    }
}
