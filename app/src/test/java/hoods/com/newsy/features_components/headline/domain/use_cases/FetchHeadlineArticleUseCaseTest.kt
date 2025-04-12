package hoods.com.newsy.features_components.headline.domain.use_cases

import androidx.paging.testing.asSnapshot
import com.google.common.truth.Truth.assertThat
import hoods.com.newsy.features_components.FakeHeadLineRepo
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertThrows
import org.junit.Test

class FetchHeadlineArticleUseCaseTest {

    private val repository = FakeHeadLineRepo()

    private val fetchHeadlineArticleUseCase = FetchHeadlineArticleUseCase(repository)

    @Test
    fun `fetchHeadlineArticleUseCase returns paging data correctly`() = runTest {
        val result = fetchHeadlineArticleUseCase.invoke("sports", "us", "en")
        val pagingData = result.asSnapshot()
        assertThat(pagingData).isNotEmpty()
        assertThat(pagingData.first().title).isEqualTo("Title of Article One")
    }

    @Test
    fun `fetchHeadlineArticleUseCase should throw exception when category is empty`() = runTest {
        assertThrows(IllegalArgumentException::class.java){
            fetchHeadlineArticleUseCase("", "us", "en")
        }
    }
    @Test
    fun `fetchHeadlineArticleUseCase should throw exception when country code is empty`() = runTest {
        assertThrows(IllegalArgumentException::class.java){
            fetchHeadlineArticleUseCase("sports", "", "en")
        }
    }
    @Test
    fun `fetchHeadlineArticleUseCase should throw exception when language code is empty`() = runTest {
        assertThrows(IllegalArgumentException::class.java){
            fetchHeadlineArticleUseCase("sports", "us", "")
        }
    }
}