package ro.alexmamo.realtimedatabase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ro.alexmamo.realtimedatabase.data.FirebaseCallback
import ro.alexmamo.realtimedatabase.data.Response

class ProductsViewModel (
    private val repository: ProductsRepository = ProductsRepository()
): ViewModel() {
    fun getResponseUsingCallback(callback: FirebaseCallback) {
        repository.getResponseFromRealtimeDatabaseUsingCallback(callback)
    }

    fun getResponseUsingLiveData() : MutableLiveData<Response> {
        return repository.getResponseFromRealtimeDatabaseUsingLiveData()
    }

    val responseLiveData = liveData(Dispatchers.IO) {
        emit(repository.getResponseFromRealtimeDatabaseUsingCoroutines())
    }
}