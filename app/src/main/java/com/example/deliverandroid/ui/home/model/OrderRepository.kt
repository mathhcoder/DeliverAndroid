package com.example.deliverandroid.ui.home.model

import uz.muslimaat.app.base.model.BaseRepository
import io.reactivex.rxjava3.core.Observable

class OrderRepository(
    val dao: OrderDao,
    val api: OrderApi
): BaseRepository() {


    fun getData(): Observable<List<OrderEntity>> {
        return Observable.fromSingle(api.getAll()
            .doOnSuccess {
                dao.updateAll(it)
            }
        ).publish { network ->
            Observable.merge(
                network,
                Observable.fromSingle(dao.getAll()).takeUntil(network)
            )
        }
    }

    fun getOrder(id: Long): OrderEntity? {
        return dao.getAll(id).firstOrNull()
    }

}