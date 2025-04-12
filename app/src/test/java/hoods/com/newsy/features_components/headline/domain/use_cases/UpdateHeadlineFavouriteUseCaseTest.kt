package hoods.com.newsy.features_components.headline.domain.use_cases

import androidx.paging.testing.asSnapshot
import com.google.common.truth.Truth.assertThat
import hoods.com.newsy.features_components.FakeHeadLineRepo
import hoods.com.newsy.utils.Utils
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UpdateHeadlineFavouriteUseCaseTest{
    private val repository = FakeHeadLineRepo()
    private val updateHeadlineFavouriteUseCase = UpdateHeadlineFavouriteUseCase(repository)

    @Test
    fun `updateHeadline should update favourite data correctly`() = runTest {
        val article = Utils.newsyArticles.first().copy(favourite = true)
        updateHeadlineFavouriteUseCase.invoke(article = article)
        val actual = repository.fetchHeadlineArticle("sport", "us", "en")
            .asSnapshot().first()
        assertThat(actual.favourite).isTrue()
    }
}