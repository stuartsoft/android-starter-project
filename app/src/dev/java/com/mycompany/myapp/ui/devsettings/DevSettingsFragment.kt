package com.mycompany.myapp.ui.devsettings

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mycompany.myapp.DevSettingsFragmentBinding
import com.mycompany.myapp.R
import com.mycompany.myapp.ui.BaseFragment

import javax.inject.Inject

class DevSettingsFragment : BaseFragment() {
    interface DevSettingsFragmentHost {
        fun inject(fragment: DevSettingsFragment)
    }

    @Inject lateinit var presenter: DevSettingsPresenter
    private lateinit var binding: DevSettingsFragmentBinding
    private var host: DevSettingsFragmentHost? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        host = context as DevSettingsFragmentHost
        host!!.inject(this)
    }

    override fun onDetach() {
        host = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_dev_settings, container, false)
        binding.presenter = presenter
        return binding.root
    }

    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }
}