package com.codingtester.developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codingtester.developers.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragView = inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.bind(fragView);
        return binding.getRoot();
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.edtName.getText().toString();
                String pass = binding.edtPass.getText().toString();

                if(isDataValid(name, pass)) {
                    writeToSharedPref(name, pass);
                } else {
                    Toast.makeText(getActivity(), "All Data is Required", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }




    private void writeToSharedPref(String name, String pass) {
        AppSharedPref.writeToSharedPref(getActivity(), name, pass);
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_loginFragment_to_homeFragment);
    }

    private boolean isDataValid(String name, String pass) {
        return !name.isEmpty() && !pass.isEmpty();
    }






}