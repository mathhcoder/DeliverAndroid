package com.example.deliverandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.deliverandroid.base.BaseViewModel
import com.example.deliverandroid.base.model.LocationModel
import com.example.deliverandroid.base.model.ProductModel
import com.example.deliverandroid.ui.home.model.OrderModel
import com.example.deliverandroid.ui.home.model.OrderRepository
import com.example.deliverandroid.ui.home.model.OrderType
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber


class OrderViewModel(private val repository: OrderRepository) : BaseViewModel() {

    private val _data = MutableLiveData<List<OrderModel>>()
    val data: LiveData<List<OrderModel>> = _data

    private var disposable = CompositeDisposable()

    init{
        getData()
    }
    fun getData() {
        disposable.add(
            repository.getData()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Timber.e("getData Success")
                    _data.postValue(it.map { d ->
                        OrderModel(
                            id = d.id,
                            number = d.number,
                            paymentStatus = d.paymentStatus,
                            time = d.time,
                            prise = d.prise,
                            payment = d.payment,
                            address = d.address,
                            orderType = d.orderType,
                            commints = d.commints,
                            products = d.products,
                            prepayment = d.prepayment,
                            tel = d.tel,
                            )
                    })
                }, {
                    Timber.e("getData Error")
                    Timber.e(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        Timber.e("AsmaViewModel clear")
    }

}