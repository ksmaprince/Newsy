package hoods.com.newsy.features_components.headline.data.local.dao

import androidx.room.Room
import com.google.common.truth.Truth.assertThat
import hoods.com.newsy.MainDispatcherRule
import hoods.com.newsy.features_components.core.data.local.NewsyArticleDatabase
import hoods.com.newsy.utils.Utils
import hoods.com.newsy.utils.getTestData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.util.Util

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class HeadlineDaoKtTest {
    private lateinit var headlineDao: HeadlineDao
    private lateinit var db: NewsyArticleDatabase

    @get:Rule
    val mainCoroutinDispatcher = MainDispatcherRule()

    @Before
    fun setUp() {
        val app = RuntimeEnvironment.getApplication()
        db = Room.inMemoryDatabaseBuilder(
            context = app.applicationContext,
            klass = NewsyArticleDatabase::class.java
        ).allowMainThreadQueries().build()
        headlineDao = db.headlineDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun `getAllArticles return all articles from db correctly`() = runTest {
        val expected = Utils.headlineDto[0]
        headlineDao.insertHeadlineArticle(listOf(expected))
        val actual = headlineDao.getAllHeadlineArticles().getTestData()
        assertThat(actual[0]).isEqualTo(expected.copy(id = 1))
    }

    @Test
    fun `getHeadlineArticleById return article from db correctly`() = runTest {
        val expected = Utils.headlineDto[0]
        headlineDao.insertHeadlineArticle(listOf(expected))
        val article = headlineDao.getHeadlineArticle(1).first()

        assertThat(article.author).isEqualTo(expected.author)
        assertThat(article.content).isEqualTo(expected.content)
        assertThat(article.description).isEqualTo(expected.description)
        assertThat(article.publishedAt).isEqualTo(expected.publishedAt)
        assertThat(article.id).isEqualTo(1)
    }

    @Test
    fun `deleteAllArticle removes all non favourite article from db`() = runTest {
        val favouriteArticle = Utils.headlineDto[0].copy(favourite = true)
        val expected = Utils.headlineDto

        headlineDao.insertHeadlineArticle(listOf(favouriteArticle))
        headlineDao.insertHeadlineArticle(expected)

        headlineDao.removeAllHeadlineArticles()

        val actual = headlineDao.getAllHeadlineArticles().getTestData()

        assertThat(actual.size).isEqualTo(1)
    }

    @Test
    fun `removeFavouriteArticle deletes favourite article from db`() = runTest{
        val headlineArticle = Utils.headlineDto
        val headlineArticleFav = Utils.headlineDto[0].copy(favourite = true)
        headlineDao.insertHeadlineArticle(listOf(headlineArticleFav))
        headlineDao.insertHeadlineArticle(headlineArticle)

        headlineDao.removeFavouriteArticle(1)
        headlineDao.removeFavouriteArticle(2)

        val actual1 = headlineDao.getHeadlineArticle(id = 1).first()
        val actual2 = headlineDao.getHeadlineArticle(id = 2).first()

        assertThat(actual1).isNull()
        assertThat(actual2).isNotNull()
    }

    @Test
    fun `updateFavouriteArticle update the article correctly from db`()  = runTest{
        val favArticle = Utils.headlineDto[0].copy(favourite = true)
        val noFavArticle = Utils.headlineDto[0].copy(favourite = false)

        headlineDao.insertHeadlineArticle(listOf(favArticle))
        headlineDao.insertHeadlineArticle(listOf(noFavArticle))

        headlineDao.updateFavouriteArticle(false, 1)
        headlineDao.updateFavouriteArticle(true, 2)

        val actual = headlineDao.getAllHeadlineArticles().getTestData()

        assertThat(actual[0].favourite).isFalse()
        assertThat(actual[1].favourite).isTrue()
    }

}