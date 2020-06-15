package com.swkang.ex.aacmvvmdagger.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swkang.ex.aacmvvmdagger.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
abstract class BaseActivity: AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restingplaces_activity)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}