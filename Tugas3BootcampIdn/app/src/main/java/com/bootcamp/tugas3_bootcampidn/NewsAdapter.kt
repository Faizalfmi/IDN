package com.bootcamp.tugas3_bootcampidn

import android.content.ClipData
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3_bootcampidn.databinding.ItemRowNewsBinding
import com.bumptech.glide.Glide

@Suppress("UNREACHABLE_CODE")
class NewsAdapter() :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(val binding: ItemRowNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: News) {
            binding.apply {
                imgNews.setImageResource(data.imgNews)
                tvJudul.text = data.titleNews
                tvPenulis.text = data.author
                tvTanggalPosting.text = data.dateNews
                binding.cardNews.setOnClickListener {
                    val intent = Intent(itemView.context,DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_NEWS,newsList[position])
                    itemView.context.startActivity(intent)
                }
            }
        }
        fun bind(news: ArticlesItem) {
            binding.apply {
                tvJudul.text = news.title
                tvPenulis.text = news.description
                tvTanggalPosting.text = news.publishedAt
                Glide.with(imgNews)
                    .load(news.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgNews)
                binding.cardNews.setOnClickListener {
                    val intent = Intent(itemView.context,DetailNewsActivity::class.java)
                    intent.putExtra(DetailNewsActivity.EXTRA_NEWS,newsList[position])
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemRowNewsBinding.inflate(layoutInflater, parent, false)

        return NewsViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(newsList[position])

    }

//    fun setData(data: List<ArticlesItem>){
//        newsList = data
//        notifyDataSetChanged()
//    }
}


