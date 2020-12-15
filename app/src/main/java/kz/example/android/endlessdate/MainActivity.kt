package kz.example.android.endlessdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kz.example.android.endlessdate.core.utills.apiResource.Status
import kz.example.android.endlessdate.views.adapters.DateAdapter
import kz.example.android.endlessdate.views.adapters.DateReclistPaginationListener
import kz.example.android.endlessdate.views.adapters.OnDateItemInteractionListener
import kz.example.android.endlessdate.views.dates.DatesViewModel
import kz.example.android.endlessdate.views.exchange.ExchangeBottomSheetDialog
import kz.example.android.endlessdate.views.exchange.ExchangeViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity(), OnDateItemInteractionListener {

    private val datesViewModel: DatesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            addOnScrollListener(object: DateReclistPaginationListener(){
                override fun requestNewData() {
                    datesViewModel.datesLiveData.value?.last()?.let {
                        datesViewModel.fetchDateList(
                            it
                        )
                    }?: kotlin.run { datesViewModel.fetchDateList() }
                }
            })
        }

        datesViewModel.datesLiveData.observe(this, Observer {
            recList.adapter = DateAdapter(it,this)
        })
    }

    override fun onDateItemClick(d: Date) {
        val bottomSheetFragment = ExchangeBottomSheetDialog.newInstance(d)
        bottomSheetFragment.show(supportFragmentManager, "aaaaa")
        bottomSheetFragment.tag
    }


}