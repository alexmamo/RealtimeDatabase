package ro.alexmamo.realtimedatabase.data

data class Response(
    var products: List<Product>? = null,
    var exception: Exception? = null
)