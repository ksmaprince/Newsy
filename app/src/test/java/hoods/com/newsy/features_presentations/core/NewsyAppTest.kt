package hoods.com.newsy.features_presentations.core


import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import hoods.com.newsy.features_presentations.core.components.NewysAppDrawerContent
import hoods.com.newsy.features_presentations.core.navigation.UiScreen
import hoods.com.newsy.utils.TestTags
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class NewsyAppTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `App drawer display content correctly`() {
        val currentRoute = mutableStateOf(UiScreen.HeadlineScreen().route)
        composeTestRule.setContent {
            NewysAppDrawerContent(
                currentRoute = currentRoute.value,
                navigateToHome = {},
                navigateToSetting = {
                    currentRoute.value = UiScreen.SearchScreen().route
                },
                navigateToFavouriteScreen = {},
                closeDrawer = {}
            )
        }

        composeTestRule.onNodeWithTag(TestTags.NewsyLogoIcon).assertIsDisplayed()

        composeTestRule.onNodeWithText("Home")
            .assertIsDisplayed()
//            .assertIsSelected()



//        composeTestRule.onNodeWithText("Favourite")
//            .assertIsDisplayed()
//            .assertIsNotSelected()
//
//        composeTestRule.onNodeWithText("Settings")
//            .assertIsDisplayed()
//            .assertIsNotSelected()
//            .performClick()
//            .assertIsSelected()
//
//        composeTestRule.onRoot()
//            .printToLog("drawer")

        //App launches in Home Screen
//        composeTestRule.onNodeWithContentDescription("Newsy").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Hot News", useUnmergedTree = true).assertIsDisplayed()
//        composeTestRule.onNodeWithText("Discover News", useUnmergedTree = true).assertIsDisplayed()
//        composeTestRule.onNodeWithTag(TestTags.DrawerBtn,useUnmergedTree = true).performClick()
//
//        //DrawerScreen
//        composeTestRule.onNodeWithTag(TestTags.DrawerContainer).assertIsDisplayed()
//        composeTestRule.onNodeWithContentDescription("Home").performClick()
//        composeTestRule.onNodeWithTag(TestTags.DrawerContainer).assertIsNotDisplayed()
//
//        //Home Screen
//        composeTestRule.onNodeWithContentDescription("Newsy").assertIsDisplayed()
//        composeTestRule.onNodeWithTag(TestTags.DrawerBtn,useUnmergedTree = true).performClick()
//        //Favourite Screen
//        composeTestRule.onNodeWithContentDescription("Favourite").performClick()
//        composeTestRule.onNodeWithTag(TestTags.DrawerContainer).assertIsNotDisplayed()
//        composeTestRule.onNodeWithText("Favourite Screen").assertIsDisplayed()
//        //Setting Screen
//        composeTestRule.onNodeWithTag(TestTags.DrawerBtn,useUnmergedTree = true).performClick()
//        composeTestRule.onNodeWithContentDescription("Settings").performClick()
//        composeTestRule.onNodeWithTag(TestTags.DrawerContainer).assertIsNotDisplayed()
//        composeTestRule.onNodeWithText("Settings Screen").assertIsDisplayed()
    }
}