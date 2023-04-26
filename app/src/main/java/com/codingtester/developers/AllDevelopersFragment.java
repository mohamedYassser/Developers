package com.codingtester.developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.codingtester.developers.databinding.FragmentAllDevelopersBinding;

import java.util.List;

public class AllDevelopersFragment extends Fragment implements DeleteDeveloper{

    private String title;

    private FragmentAllDevelopersBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_all_developers, container, false);
        binding = FragmentAllDevelopersBinding.bind(view);

        // to get title from bundle
        title = getArguments().getString("title");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDevelopersByTitle();
    }

    private void getDevelopersByTitle() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                DeveloperBuilder builder = DeveloperBuilder.getInstance(getContext());
                List<Developer> developerList = builder.developerDao().getDevelopersByTitle(title);
                DeveloperAdapter adapter = new DeveloperAdapter(developerList, AllDevelopersFragment.this);


                // to access views in main thread from background thread we need to this function
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        binding.recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();

    }



    @Override
    public void deleteDevById(int devID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DeveloperBuilder builder = DeveloperBuilder.getInstance(getContext());
                builder.developerDao().deleteDevByID(devID);
            }
        }).start();
        Toast.makeText(getActivity(), "Developer Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
}