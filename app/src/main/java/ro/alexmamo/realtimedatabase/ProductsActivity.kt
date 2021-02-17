package ro.alexmamo.realtimedatabase

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ro.alexmamo.realtimedatabase.data.FirebaseCallback
import ro.alexmamo.realtimedatabase.data.Response
import ro.alexmamo.realtimedatabase.utils.Constants.TAG

class ProductsActivity : AppCompatActivity() {
    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        getResponseUsingCallback()
        getResponseUsingLiveData()
        getResponseUsingCoroutines()
    }

    private fun getResponseUsingCallback() {
        viewModel.getResponseUsingCallback(object : FirebaseCallback {
            override fun onResponse(response: Response) {
                printResponse(response)
            }
        })
    }

    private fun getResponseUsingLiveData() {
        viewModel.getResponseUsingLiveData().observe(this, {
            printResponse(it)
        })
    }

    private fun getResponseUsingCoroutines() {
        viewModel.responseLiveData.observe(this, {
            printResponse(it)
        })
    }

    private fun printResponse(response: Response) {
        response.products?.let { products ->
            products.forEach{ product ->
                product.name?.let {
                    Log.i(TAG, it)
                }
            }
        }

        response.exception?.let { exception ->
            exception.message?.let {
                Log.e(TAG, it)
            }
        }
    }
}