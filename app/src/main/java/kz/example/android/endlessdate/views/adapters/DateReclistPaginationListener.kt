package kz.example.android.endlessdate.views.adapters

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class DateReclistPaginationListener: RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        require(recyclerView.layoutManager is LinearLayoutManager){"RecList layoutManager should be LinearLayoutManager"}
        (recyclerView.layoutManager as? LinearLayoutManager)?.let { layoutManager ->
            val visibleItemCount: Int = layoutManager.childCount
            val totalItemCount: Int = layoutManager.itemCount
            val firstVisibleItemPosition: Int = layoutManager.findFirstVisibleItemPosition()
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                requestNewData()
            }
        }
    }

    abstract fun requestNewData()

}