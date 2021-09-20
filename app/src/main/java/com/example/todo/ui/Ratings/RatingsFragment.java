package com.example.todo.ui.Ratings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.todo.MainActivity;
import com.example.todo.R;

import com.example.todo.databinding.FragmentRatingsBinding;
import com.example.todo.ui.gallery.GalleryViewModel;

public class RatingsFragment extends Fragment {

    private RatingsViewModel ratingsViewModel;
    private FragmentRatingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ratingsViewModel =
                new ViewModelProvider(this).get(RatingsViewModel.class);

        binding = FragmentRatingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final Button  btn  = binding.btnRating;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity() ,MainActivity.class);
                startActivity(i);
            }
        });


        final TextView textView = binding.textRatings;
        ratingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });
        return root;


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}