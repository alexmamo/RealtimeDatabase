package ro.alexmamo.realtimedatabase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import ro.alexmamo.realtimedatabase.data.FirebaseCallback
import ro.alexmamo.realtimedatabase.data.Product
import ro.alexmamo.realtimedatabase.data.Response
import ro.alexmamo.realtimedatabase.utils.Constants.PRODUCTS_REF

class ProductsRepository(
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference,
    private val productRef: DatabaseReference = rootRef.child(PRODUCTS_REF)
) {
    fun getResponseFromRealtimeDatabaseUsingCallback(callback: FirebaseCallback) {
        productRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.products = result.children.map { snapShot ->
                        snapShot.getValue(Product::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            callback.onResponse(response)
        }
    }

    fun getResponseFromRealtimeDatabaseUsingLiveData() : MutableLiveData<Response> {
        val mutableLiveData = MutableLiveData<Response>()
        productRef.get().addOnCompleteListener { task ->
            val response = Response()
            if (task.isSuccessful) {
                val result = task.result
                result?.let {
                    response.products = result.children.map { snapShot ->
                        snapShot.getValue(Product::class.java)!!
                    }
                }
            } else {
                response.exception = task.exception
            }
            mutableLiveData.value = response
        }
        return mutableLiveData
    }

    suspend fun getResponseFromRealtimeDatabaseUsingCoroutines(): Response {
        val response = Response()
        try {
            response.products = productRef.get().await().children.map { snapShot ->
                snapShot.getValue(Product::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }
}