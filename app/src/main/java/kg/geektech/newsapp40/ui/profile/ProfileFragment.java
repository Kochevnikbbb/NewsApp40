package kg.geektech.newsapp40.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.io.File;

import kg.geektech.newsapp40.Prefs;
import kg.geektech.newsapp40.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private Uri uri;
    private Prefs prefs;
    private Intent intent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new Prefs(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(LayoutInflater.from(requireContext()),
                container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImage();
        saveEditText(prefs);

    }


    private ActivityResultLauncher<Intent> xzz = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        uri = result.getData().getData();
                        prefs.saveAvatar(String.valueOf(uri));
                        binding.ivImage.setImageURI(uri);
                    }
                }
            });


    private void setImage() {
        binding.ivImage.setOnClickListener(view -> {
            intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            xzz.launch(intent);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (prefs.getAvatar() != null) uri = Uri.parse(prefs.getAvatar());
        Glide.with(requireContext()).load(uri).circleCrop().into(binding.ivImage);
    }

    private void saveEditText(Prefs prefs) {
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                prefs.saveETName(editable.toString());
            }
        });
        binding.etName.setText(prefs.getETName());
    }

}