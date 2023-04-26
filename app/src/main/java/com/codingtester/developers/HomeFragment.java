package com.codingtester.developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingtester.developers.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // to send data from fragment to another we use bundle
        Bundle bundle = new Bundle();

        binding.btnAddDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot())
                        .navigate(R.id.action_homeFragment_to_addDeveloperFragment);
            }
        });

        binding.cardFresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("title", "Fresh");
                Navigation.findNavController(binding.getRoot())
                        .navigate(R.id.action_homeFragment_to_allDevelopersFragment, bundle);
            }
        });

        binding.cardJunior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("title", "Junior");
                Navigation.findNavController(binding.getRoot())
                        .navigate(R.id.action_homeFragment_to_allDevelopersFragment, bundle);
            }
        });

        binding.cardMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("title", "Mid");
                Navigation.findNavController(binding.getRoot())
                        .navigate(R.id.action_homeFragment_to_allDevelopersFragment, bundle);
            }
        });

        binding.cardSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("title", "Senior");
                Navigation.findNavController(binding.getRoot())
                        .navigate(R.id.action_homeFragment_to_allDevelopersFragment, bundle);
            }
        });

    }
}