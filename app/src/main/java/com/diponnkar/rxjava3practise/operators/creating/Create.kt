package com.diponnkar.rxjava3practise.operators.creating

import android.util.Log
import com.diponnkar.rxjava3practise.operators.Operator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable

class Create : Operator() {
    override fun sample(): Disposable {
        return Observable.create<Int> {
            try {
                for (i in 1..5) {
                    it.onNext(i)
                }

                it.onComplete()
            } catch (e: Exception) {
                it.onError(e)
            }
        }.subscribe({
            Log.d(TAG, "onNext: $it")
        }, {
            Log.d(TAG, "onError $it")
        }, {
            Log.d(TAG, "onComplete")
        })
    }

}