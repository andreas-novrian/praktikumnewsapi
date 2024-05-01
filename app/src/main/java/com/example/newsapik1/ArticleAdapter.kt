package com.example.newsapik1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapik1.data.Article
import com.example.newsapik1.databinding.ItemArticleBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleViewHolder>() {
    var articles = emptyList<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

}

class ArticleViewHolder(private val binding: ItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        binding.tvTitle.text = article.title
        binding.tvDescription.text = article.description
        Glide.with(binding.root)
            .load(article.urlToImage)
            .centerCrop()
            .into(binding.ivAvatar)
    }
}
