package hoods.com.newsy.features_components.headline.data.mapper

import com.google.common.truth.Truth.assertThat
import hoods.com.newsy.features_components.core.domain.mapper.Mapper
import hoods.com.newsy.features_components.core.domain.models.NewsyArticle
import hoods.com.newsy.features_components.headline.data.local.model.HeadlineDto
import hoods.com.newsy.utils.Utils
import org.junit.Before
import org.junit.Test

class HeadlineMapperTest {
    private lateinit var headlineMapper: Mapper<HeadlineDto, NewsyArticle>

    @Before
    fun setUp() {
        headlineMapper = HeadlineMapper<HeadlineDto, NewsyArticle>()
    }

    @Test
    fun `fromModel should map to HeadlineDto correctly`() {
        val newsyArticle = Utils.newsyArticles[0]
        val headlineDto = headlineMapper.fromModel(newsyArticle)
        assertThat(headlineDto.id).isEqualTo(1)
        assertThat(headlineDto.author).isEqualTo(newsyArticle.author)
        assertThat(headlineDto.content).isEqualTo(newsyArticle.content)
        assertThat(headlineDto.description).isEqualTo(newsyArticle.description)
        assertThat(headlineDto.publishedAt).isEqualTo(newsyArticle.publishedAt)
        assertThat(headlineDto.source).isEqualTo(newsyArticle.source)
        assertThat(headlineDto.title).isEqualTo(newsyArticle.title)
        assertThat(headlineDto.category).isEqualTo(newsyArticle.category)
        assertThat(headlineDto.favourite).isEqualTo(newsyArticle.favourite)
        assertThat(headlineDto.url).isEqualTo(newsyArticle.url)
        assertThat(headlineDto.urlToImage).isEqualTo(newsyArticle.urlToImage)
        assertThat(headlineDto.page).isEqualTo(newsyArticle.page)
    }

    @Test
    fun `toModel should map to NewsyArticle correctly`() {
        val headlineDto = Utils.headlineDto[0]
        val newsyArticle = headlineMapper.toModel(headlineDto)

        assertThat(newsyArticle.author).isEqualTo(headlineDto.author)
        assertThat(newsyArticle.content).isEqualTo(headlineDto.content)
        assertThat(newsyArticle.description).isEqualTo(headlineDto.description)
        assertThat(newsyArticle.publishedAt).isEqualTo(headlineDto.publishedAt)
        assertThat(newsyArticle.source).isEqualTo(headlineDto.source)
        assertThat(newsyArticle.title).isEqualTo(headlineDto.title)
        assertThat(newsyArticle.category).isEqualTo(headlineDto.category)
        assertThat(newsyArticle.favourite).isEqualTo(headlineDto.favourite)
        assertThat(newsyArticle.url).isEqualTo(headlineDto.url)
        assertThat(newsyArticle.urlToImage).isEqualTo(headlineDto.urlToImage)
        assertThat(newsyArticle.page).isEqualTo(headlineDto.page)
    }
}