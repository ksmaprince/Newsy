package hoods.com.newsy.features_components.core.data.remote.models

import com.google.common.truth.Truth.assertThat
import hoods.com.newsy.utils.Utils
import org.junit.Assert.assertThrows
import org.junit.Test

class ArticleKtTest {
    @Test
    fun `toHeadlineArticle should map to headline correctly`() {
        val article = Utils.testArticles[0]
        val headlineDto = article.toHeadlineArticle(0, "sport")
        assertThat(headlineDto.id).isEqualTo(0)
        assertThat(headlineDto.author).isEqualTo(article.author)
        assertThat(headlineDto.content).isEqualTo(article.content)
        assertThat(headlineDto.description).isEqualTo(article.description)
        assertThat(headlineDto.publishedAt).isEqualTo(article.publishedAt)
        assertThat(headlineDto.source).isEqualTo(article.source.name)
        assertThat(headlineDto.title).isEqualTo(article.title)
        assertThat(headlineDto.category).isEqualTo("sport")
        assertThat(headlineDto.favourite).isFalse()
        assertThat(headlineDto.url).isEqualTo(article.url)
        assertThat(headlineDto.urlToImage).isEqualTo(article.urlToImage)
        assertThat(headlineDto.page).isEqualTo(0)
    }

    @Test
    fun `toHeadlineArticle should map null or empty value with formatted output`() {
        val article = Article()
        val headlineDto = article.toHeadlineArticle(0, "sport")
        assertThat(headlineDto.id).isEqualTo(0)
        assertThat(headlineDto.author).isEqualTo("Unknown author")
        assertThat(headlineDto.content).isEqualTo("Unknown content")
        assertThat(headlineDto.description).isEqualTo("Unknown description")
        assertThat(headlineDto.publishedAt).isEqualTo("Unknown date")
        assertThat(headlineDto.source).isEqualTo("Unknown source")
        assertThat(headlineDto.title).isEqualTo("Unknown title")
        assertThat(headlineDto.category).isEqualTo("sport")
        assertThat(headlineDto.favourite).isFalse()
        assertThat(headlineDto.url).isEmpty()
        assertThat(headlineDto.urlToImage).isNull()
    }

    @Test
    fun `toHeadlineArticle should throw IllegalArgument Exc when category is empty`() {
        val article = Article()
        assertThrows(IllegalArgumentException::class.java) {
            article.toHeadlineArticle(0, "")
        }
    }

    @Test
    fun `toHeadlineArticle should throw IndexOutOfBound Exc when page is -ve`() {
        val article = Article()
        assertThrows(IndexOutOfBoundsException::class.java) {
            article.toHeadlineArticle(-1, "sport")
        }
    }

    @Test
    fun `toDescoverArticle should map to discover correctly`() {
        val article = Utils.testArticles[0]
        val discoverDto = article.toDiscoverArticle(0, "wildlife")
        assertThat(discoverDto.id).isEqualTo(0)
        assertThat(discoverDto.author).isEqualTo(article.author)
        assertThat(discoverDto.content).isEqualTo(article.content)
        assertThat(discoverDto.description).isEqualTo(article.description)
        assertThat(discoverDto.publishedAt).isEqualTo(article.publishedAt)
        assertThat(discoverDto.source).isEqualTo(article.source.name)
        assertThat(discoverDto.title).isEqualTo(article.title)
        assertThat(discoverDto.category).isEqualTo("wildlife")
        assertThat(discoverDto.favourite).isFalse()
        assertThat(discoverDto.url).isEqualTo(article.url)
        assertThat(discoverDto.urlToImage).isEqualTo(article.urlToImage)
        assertThat(discoverDto.page).isEqualTo(0)
    }

    @Test
    fun `toDiscoverArticle should map null or empty value with formatted output`() {
        val article = Article()
        val discoverDto = article.toDiscoverArticle(0, "wildlife")
        assertThat(discoverDto.id).isEqualTo(0)
        assertThat(discoverDto.author).isEqualTo("Unknown author")
        assertThat(discoverDto.content).isEqualTo("Unknown content")
        assertThat(discoverDto.description).isEqualTo("Unknown description")
        assertThat(discoverDto.publishedAt).isEqualTo("Unknown date")
        assertThat(discoverDto.source).isEqualTo("Unknown source")
        assertThat(discoverDto.title).isEqualTo("Unknown title")
        assertThat(discoverDto.category).isEqualTo("wildlife")
        assertThat(discoverDto.favourite).isFalse()
        assertThat(discoverDto.url).isEmpty()
        assertThat(discoverDto.urlToImage).isNull()
    }

    @Test
    fun `toDiscoverArticle should throw IllegalArgument Exc when category is empty`() {
        val article = Article()
        assertThrows(IllegalArgumentException::class.java) {
            article.toDiscoverArticle(0, "")
        }
    }

    @Test
    fun `toDiscoverArticle should throw IndexOutOfBound Exc when page is -ve`() {
        val article = Article()
        assertThrows(IndexOutOfBoundsException::class.java) {
            article.toDiscoverArticle(-1, "wildlife")
        }
    }
}