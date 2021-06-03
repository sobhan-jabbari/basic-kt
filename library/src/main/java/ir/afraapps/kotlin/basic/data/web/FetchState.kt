package ir.afraapps.kotlin.basic.data.web


class FetchState(val status: Status, val message: String? = null) {

    companion object {
        val NO_CONNECTION = FetchState(Status.NO_CONNECTION)
        val LOADING = FetchState(Status.LOADING)
        val SUCCESS = FetchState(Status.SUCCESS)
        val FAILED = FetchState(Status.FAILED)
        val FINISHED = FetchState(Status.FINISHED)
    }


    enum class Status {
        NO_CONNECTION, LOADING, SUCCESS, FAILED, FINISHED
    }
}