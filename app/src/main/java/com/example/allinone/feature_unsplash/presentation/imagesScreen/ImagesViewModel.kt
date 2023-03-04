package com.example.allinone.feature_unsplash.presentation.imagesScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allinone.feature_unsplash.Util.Resource
import com.example.allinone.feature_unsplash.domain.util.Order
import com.example.allinone.feature_unsplash.domain.repository.ImageInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ImagesViewModel"

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val repository: ImageInterface
): ViewModel() {


    var state by mutableStateOf(ImageState())




    init {
        getImages()
    }


    fun getImages(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false,
        page: Int = 1,
        order: String = Order.POPULAR
    ) {
        viewModelScope.launch {
            repository.getImagePosts(query = query, page =  page, order = order,fetchFromRemote = fetchFromRemote,)
                .collect { result ->
                    when(result) {

                        is Resource.Success -> {
                            result.data?.let { imagePosts ->

                                state = state.copy(
                                    imagePosts = imagePosts
                                )

                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoadingImages = result.isLoading)
                        }
                    }
                }
        }

    }




}