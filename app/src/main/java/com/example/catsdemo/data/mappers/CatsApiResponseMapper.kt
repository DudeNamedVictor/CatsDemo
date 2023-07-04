package com.example.catsdemo.data.mappers

import com.example.catsdemo.data.models.response.CatsApiItems
import com.example.catsdemo.domain.entities.Cats

class CatsApiResponseMapper {

    fun toCatsList(response: List<CatsApiItems>) = response.map { Cats(it.id, it.url) }

}