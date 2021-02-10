package com.udacity.shoestore.screens

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {view: View ->
            if(checkValidEntry()) {
                Timber.i("Navigate to welcome screen")
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

    }

    private fun checkValidEntry() : Boolean {
        if (TextUtils.isEmpty(binding.emailTxt.text)) {
            Toast.makeText(context,"Please enter valid Email",Toast.LENGTH_LONG).show()
            return false
        }
        if (TextUtils.isEmpty(binding.passwordTxt.text)) {
            Toast.makeText(context,"Please enter valid Password",Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}