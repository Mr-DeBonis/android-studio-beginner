package org.mrdebonis.myfirstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import org.mrdebonis.myfirstapp.databinding.FragmentFirstBinding;

import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView showCountTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        showCountTextView = binding.textviewFirst;

        Window window = FirstFragment.this.requireActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(FirstFragment.super.requireContext(), R.color.screenBackground));

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send count to secondFragment
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);

                Log.d("FirstFragment", "onClick: " + currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);

            }
        });

        binding.toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(getActivity(), "Hello Toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        binding.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countMe(view);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("SetTextI18n")
    private void countMe(View view) {
        String countString = showCountTextView.getText().toString();
        int count = Integer.parseInt(countString);
        count++;

        showCountTextView.setText(Integer.toString(count));
    }
}