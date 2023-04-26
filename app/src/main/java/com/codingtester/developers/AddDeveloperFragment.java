package com.codingtester.developers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.codingtester.developers.databinding.FragmentAddDeveloperBinding;


public class AddDeveloperFragment extends Fragment {

    private FragmentAddDeveloperBinding binding;
    private String name="", title="";
    private double salary=0.0, bonus = 0.0;
    private int absence=0,vacation=0, midIns=0, socialIns=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_developer, container, false);
        binding = FragmentAddDeveloperBinding.bind(view);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rdbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId) {
                    case R.id.rdbFresh: {
                        title = "Fresh";
                        binding.txtSalaryHint.setText("Salary from 4000 - 7000");
                        binding.edtBouns.setVisibility(View.GONE);
                        binding.edtMidIns.setVisibility(View.GONE);
                        binding.edtSocialIns.setVisibility(View.GONE);
                        break;
                    }
                    case R.id.rdbJunior: {
                        title = "Junior";
                        binding.txtSalaryHint.setText("Salary from 7000 - 10000");
                        binding.edtBouns.setVisibility(View.VISIBLE);
                        binding.edtMidIns.setVisibility(View.GONE);
                        binding.edtSocialIns.setVisibility(View.GONE);
                        break;
                    }
                    case R.id.rdbMid: {
                        title = "Mid";
                        binding.txtSalaryHint.setText("Salary from 10000 - 15000");
                        binding.edtBouns.setVisibility(View.VISIBLE);
                        binding.edtMidIns.setVisibility(View.VISIBLE);
                        binding.edtSocialIns.setVisibility(View.GONE);
                        break;
                    }
                    case R.id.rdbSenior: {
                        title = "Senior";
                        binding.txtSalaryHint.setText("Salary from 15000 - 20000");
                        binding.edtBouns.setVisibility(View.VISIBLE);
                        binding.edtMidIns.setVisibility(View.VISIBLE);
                        binding.edtSocialIns.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        });

        binding.btnAddDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.edtName.getText().toString();
                salary = Double.parseDouble(binding.edtSalary.getText().toString().isEmpty()? "0" : binding.edtSalary.getText().toString());
                vacation = Integer.parseInt(binding.edtVacation.getText().toString().isEmpty()? "0" : binding.edtVacation.getText().toString());
                absence = Integer.parseInt(binding.edtAbsence.getText().toString().isEmpty()? "0" : binding.edtAbsence.getText().toString());
                bonus = Double.parseDouble(binding.edtBouns.getText().toString().isEmpty()? "0" : binding.edtBouns.getText().toString());
                midIns = Integer.parseInt(binding.edtMidIns.getText().toString().isEmpty()? "0" : binding.edtMidIns.getText().toString());
                socialIns = Integer.parseInt(binding.edtSocialIns.getText().toString().isEmpty()? "0" : binding.edtSocialIns.getText().toString());

                if(! isDataValid()) {
                    addDataToRoom();
                } else {
                    Toast.makeText(getActivity(), "Empty Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void addDataToRoom() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Developer newDeveloper = new Developer(name, salary, title, vacation, absence, bonus, midIns, socialIns);
                DeveloperBuilder developerBuilder = DeveloperBuilder.getInstance(getActivity());
                developerBuilder.developerDao().addDeveloper(newDeveloper);
            }
        }).start();

        Toast.makeText(getActivity(), "data added successfully", Toast.LENGTH_SHORT).show();
    }

    private boolean isDataValid() {
        return name.isEmpty() || title.isEmpty();
    }
}