package com.task.cloneyoutube.rv_activity.homeviewmodel

import androidx.lifecycle.ViewModel
import com.task.cloneyoutube.NameChanel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {


    private val _videoList = MutableStateFlow<List<NameChanel>>(emptyList())
    val videoList: StateFlow<List<NameChanel>> = _videoList.asStateFlow()
    private var listVideos = arrayListOf<NameChanel>(
        NameChanel(NameVideo = "TechExplained", Visits = "450k vistas", DateCreation = "hace 2 semanas"),
        NameChanel(NameVideo = "GamingGuru", Visits = "1.2M vistas", DateCreation = "hace 1 semana"),
        NameChanel(NameVideo = "DailyVlogs", Visits = "980k vistas", DateCreation = "hace 3 semanas"),
        NameChanel(NameVideo = "CookingWithJoy", Visits = "350k vistas", DateCreation = "hace 5 semanas"),
        NameChanel(NameVideo = "TravelTales", Visits = "760k vistas", DateCreation = "hace 2 meses"),
        NameChanel(NameVideo = "MusicMania", Visits = "1.8M vistas", DateCreation = "hace 1 semana"),
        NameChanel(NameVideo = "FitnessFreak", Visits = "620k vistas", DateCreation = "hace 4 semanas"),
        NameChanel(NameVideo = "MovieReviews", Visits = "540k vistas", DateCreation = "hace 3 semanas"),
        NameChanel(NameVideo = "ScienceSimplified", Visits = "1M vistas", DateCreation = "hace 2 días"),
        NameChanel(NameVideo = "HistoryHub", Visits = "400k vistas", DateCreation = "hace 6 semanas")
    )
    private val _uiState = MutableStateFlow(HomeUIState(listVideos))
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()
    init{
        _uiState.value = HomeUIState(videos = listVideos)
    }

    fun setData(){
        val videoOne = obtainVideo()
        _uiState.value = HomeUIState(videos = listVideos)
        _videoList.value = listVideos
    }

    private fun obtainVideo(): NameChanel = listVideos.random()

}