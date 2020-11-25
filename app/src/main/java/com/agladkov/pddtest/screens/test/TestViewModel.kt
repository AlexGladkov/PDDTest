package com.agladkov.pddtest.screens.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agladkov.pddtest.common.views.BaseCellModel
import com.agladkov.pddtest.common.views.HeaderCellModel
import com.agladkov.pddtest.data.themes.ThemesRepository
import com.agladkov.pddtest.data.themes.retrofit.ThemesApi
import com.agladkov.pddtest.data.themes.models.mapToCellModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestViewModel @Inject constructor(
    private val themesRepository: ThemesRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _items = MutableLiveData<List<BaseCellModel>>(emptyList())
    var items: LiveData<List<BaseCellModel>> = _items

    private val _error = MutableLiveData<String>("")
    var error: LiveData<String> = _error

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun generateData() {
        compositeDisposable.add(
            themesRepository.fetchThemes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    val testData = ArrayList<BaseCellModel>()
                    testData.add(HeaderCellModel(title = "Выберите тесты"))

                    testData.addAll(response.themes.map { it.mapToCellModel() })
                    _items.postValue(testData)
                }, {
                    _error.postValue("Error loading data, ${it.localizedMessage}")
                })
        )
    }
}