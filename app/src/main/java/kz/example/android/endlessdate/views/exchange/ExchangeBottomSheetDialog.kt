package kz.example.android.endlessdate.views.exchange

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_dialog.*
import kz.example.android.endlessdate.R
import kz.example.android.endlessdate.core.utills.apiResource.Status
import kz.example.android.endlessdate.data.ExchangeRate
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

private const val DATE = "date"

class ExchangeBottomSheetDialog: BottomSheetDialogFragment() {
    private val exchangeViewModel: ExchangeViewModel by viewModel()
    private var date: Date? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_dialog, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            date = it.getSerializable(DATE) as Date
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        date?.let {
            exchangeViewModel.getDayExchange(it).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                when(it.status){
                    Status.LOADING -> {
                        showLoadingUi()
                    }
                    Status.SUCCESS -> {
                        it.data?.valute?.let { it1 -> showExchangeRateUi(it1) }
                    }
                    Status.ERROR -> {
                        showErrorDialog(it.message + "возможно курс на данную дату не установлен")
                    }
                }
            })
        }?: kotlin.run {
            showErrorDialog("Date is not valid")
        }

    }

    private fun showLoadingUi(){
        progressBar.visibility = View.VISIBLE
    }
    private fun showExchangeRateUi(exchange: ExchangeRate){
        progressBar.visibility = View.GONE
        usdTitle.text = exchange.USD.name
        usdValue.text = exchange.USD.getNominalizedValue().toString()
        kztTitle.text = exchange.KZT.name
        kztValue.text = exchange.KZT.getNominalizedValue().toString()
        eurTitle.text = exchange.EUR.name
        eurValue.text = exchange.EUR.getNominalizedValue().toString()
    }

    private fun showErrorDialog(message: String){
        dialog?.cancel()
        AlertDialog.Builder(requireContext())
            .setTitle("Ошибка при загрузке")
            .setMessage(message)
            .setPositiveButton("Ok"){dialogInterface, i -> dialog?.cancel() }
            .show()
    }

    companion object{
        @JvmStatic
        fun newInstance(date: Date) = ExchangeBottomSheetDialog().apply {
            arguments = Bundle().apply {
                putSerializable(DATE, date)
            }
        }
    }



}