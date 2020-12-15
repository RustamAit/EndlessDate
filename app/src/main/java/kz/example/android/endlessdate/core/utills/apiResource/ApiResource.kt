package kz.example.android.endlessdate.core.utills.apiResource

data class ApiResource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ApiResource<T> = ApiResource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ApiResource<T> =
            ApiResource(status = Status.ERROR, data = data, message = message)

        fun <T> loading(): ApiResource<T> = ApiResource(status = Status.LOADING, data = null, message = null)
    }
}