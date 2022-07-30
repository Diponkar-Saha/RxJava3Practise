package com.diponnkar.rxjava3practise.operators.transforming

import android.util.Log
import com.diponnkar.rxjava3practise.operators.Operator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable

class Buffer : Operator() {


    override fun <T> with(): List<String> {
        return listOf("Blue", "Red", "Green", "White")
    }

    override fun sample(): Disposable {
        return Observable.just("Mother", "Father", "Daughter", "Son")
            .buffer(3)
            .subscribe {
                Log.d(TAG, "onNext: $it")
            }
    }

    override fun detailedSample() {
        Observable.fromIterable(this.with<List<String>>())
            .buffer(2)
            .subscribe({
                Log.d(TAG, "onNext: ${it.toTypedArray().contentToString()}")
            }, {
                Log.d(TAG, "onError $it")
            })
    }
}