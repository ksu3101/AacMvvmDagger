package com.swkang.ex.aacmvvmdagger.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.swkang.ex.model.base.BaseViewModel
import com.swkang.ex.model.base.redux.AppStore
import com.swkang.ex.model.base.redux.State
import com.swkang.ex.model.base.redux.isStateType
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import java.lang.IllegalStateException
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 6/15/2020
 */
abstract class BaseFragment<S: State>: Fragment(), HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject lateinit var store: AppStore
    private lateinit var binding: ViewDataBinding
    private lateinit var viewModel: BaseViewModel<S>
    private val compositeDisposable = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun createViewModel(): BaseViewModel<S>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compositeDisposable.clear()
        compositeDisposable.add(
            store.getStateListener()
                .isStateType()
                .distinctUntilChanged()
                .subscribe {
                   if (it as? S == null) throw IllegalStateException("$it is not available states.")
                    if (!viewModel.render(it)) {
                        // navigationHelper.handle(it)
                    }
                }
        )

        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        if (::viewModel.isInitialized) {
            viewModel.dispose()
        }
        super.onDestroyView()
    }

}