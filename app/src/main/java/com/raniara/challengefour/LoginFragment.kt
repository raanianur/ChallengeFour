package com.raniara.challengefour

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.raniara.challengefour.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener{
            var inputEmail = binding.etLoginEmail.text.toString()
            var inputPassword = binding.etLoginPassword.text.toString()
            var getUsername = sharedPref.getString("username","")
            var emailSharedPref = sharedPref.getString("email","")
            var passwordSharedPref = sharedPref.getString("password","")

            if (inputEmail.equals(emailSharedPref) && inputPassword.equals(passwordSharedPref)){
                var bun = Bundle()
                bun.putString("username",getUsername)
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(context,"Data Salah!",Toast.LENGTH_SHORT).show()
            }
        }
        binding.linkRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.registerFragment)
        }
    }
}