package hoods.com.newsy.features_components.core.data.remote.models


import hoods.com.newsy.features_components.discover.data.local.models.DiscoverArticleDto
import hoods.com.newsy.features_components.headline.data.local.model.HeadlineDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    @SerialName("author")
    val author: String = "",
    @SerialName("content")
    val content: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String = "",
    @SerialName("source")
    val source: Source = Source(),
    @SerialName("title")
    val title: String = "",
    @SerialName("url")
    val url: String = "",
    @SerialName("urlToImage")
    val urlToImage: String? = null,
)

fun Article.toDiscoverArticle(page: Int, category: String): DiscoverArticleDto {
    if (category.isEmpty()) throw IllegalArgumentException("Category is empty")
    if (page < 0) throw IndexOutOfBoundsException("Page is negative")
    return DiscoverArticleDto(
        author = formatEmptyValue(author,"author"),
        content = formatEmptyValue(content,"content"),
        description = formatEmptyValue(description,"description"),
        publishedAt = formatEmptyValue(publishedAt, "date"),
        title = formatEmptyValue(title, "title"),
        source = formatEmptyValue(source.name, "source"),
        category = category,
        url = url,
        urlToImage = urlToImage,
        page = page
    )
}

fun Article.toHeadlineArticle(page: Int, category: String): HeadlineDto {
    if (category.isEmpty()) throw IllegalArgumentException("Category is empty")
    if (page<0) throw IndexOutOfBoundsException("Invalid page number")
    return HeadlineDto(
        author = formatEmptyValue(author, "author"),
        content = formatEmptyValue(content, "content"),
        description = formatEmptyValue(description, "description"),
        publishedAt = formatEmptyValue(publishedAt, "date"),
        source = formatEmptyValue(source.name, "source"),
        title = formatEmptyValue(title, "title"),
        url = url,
        urlToImage = urlToImage,
        page = page,
        category = category
    )
}


private fun formatEmptyValue(value: String?, default: String = ""): String {
    return if (value.isNullOrEmpty()) "Unknown $default"
    else value
}








