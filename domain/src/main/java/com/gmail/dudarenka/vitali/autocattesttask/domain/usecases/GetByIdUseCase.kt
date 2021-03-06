package com.gmail.dudarenka.vitali.autocattesttask.domain.usecases

import com.gmail.dudarenka.vitali.autocattesttask.domain.entity.Car
import com.gmail.dudarenka.vitali.autocattesttask.domain.executor.PostExecutorThread
import com.gmail.dudarenka.vitali.autocattesttask.domain.repositories.CarRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetByIdUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                            private val carRepository: CarRepository) : BaseUseCase(postExecutorThread) {
    fun getById(id: String): Observable<Car> {
        return carRepository.getById(id).observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }
}