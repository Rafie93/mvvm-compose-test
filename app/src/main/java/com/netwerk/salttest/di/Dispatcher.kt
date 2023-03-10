package com.netwerk.salttest.di

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {

    fun providesDefaultDispatcher(): CoroutineDispatcher
    fun providesIODispatcher(): CoroutineDispatcher
    fun providesMainDispatcher(): CoroutineDispatcher
}