package com.bootcamp.tugas3_bootcampidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.tugas3_bootcampidn.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDetailNewsBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDetailNewsBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val news = intent.getParcelableExtra<News>(EXTRA_NEWS)!!

		binding.apply {
			imgNews.setImageResource(news.imgNews)
			tvJudul.text = news.titleNews
			tvDeskripsi.text = news.description

		}
	}

	companion object{
		const val EXTRA_NEWS = "news"
	}
}