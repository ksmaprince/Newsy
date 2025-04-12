package hoods.com.newsy.features_components.headline.domain.use_cases

import androidx.paging.PagingData
import hoods.com.newsy.features_components.core.domain.models.NewsyArticle
import hoods.com.newsy.features_components.headline.domain.repository.HeadlineRepository
import kotlinx.coroutines.flow.Flow

class FetchHeadlineArticleUseCase(
    private val repository: HeadlineRepository,
) {
    operator fun invoke(
        category: String,
        countryCode: String,
        languageCode: String,
    ): Flow<PagingData<NewsyArticle>> {
        if (category.isNullOrEmpty()) throw IllegalArgumentException("Category can't be null or empty")
        if (countryCode.isNullOrEmpty()) throw IllegalArgumentException("Country code can't be null or empty")
        if (languageCode.isNullOrEmpty()) throw IllegalArgumentException("Language cod can't be null or empty")
        return repository.fetchHeadlineArticle(
            category, countryCode, languageCode
        )
    }
}