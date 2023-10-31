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
import com.raniara.challengefour.databinding.FragmentRegisterBinding



class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("datauser", Context.MODE_PRIVATE)


        binding.btnRegister.setOnClickListener{
            var username = binding.etRegisterUsername.text.toString()
            var email = binding.etRegisterEmail.text.toString()
            var password = binding.etPassword1.text.toString()
            var passwordConfirm = binding.etPassword2.text.toString()
            var addUser = sharedPref.edit()

            if (passwordConfirm.equals(password)){
                addUser.putString("username",username)
                addUser.putString("email",email)
                addUser.putString("password",password)
                addUser.putString("passwordconfirm",passwordConfirm)
                addUser.apply()
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
            }else{
                Toast.makeText(context,"Password Tidak Cocok!",Toast.LENGTH_SHORT).show()
            }
        }
    }

}