package com.monapk.retrofitapirequest.network.model

import com.squareup.moshi.Json

data class Gurunavi(
        @Json(name = "@attributes")
        val attributes: Attributes,
        val hit_per_page: Int,
        val page_offset: Int,
        val rest: List<Rest>,
        val total_hit_count: Int
)