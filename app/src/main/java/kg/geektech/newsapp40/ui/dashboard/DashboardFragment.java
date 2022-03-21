package kg.geektech.newsapp40.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import kg.geektech.newsapp40.R;
import kg.geektech.newsapp40.adapter.AdapterNews;
import kg.geektech.newsapp40.databinding.FragmentDashboardBinding;
import kg.geektech.newsapp40.models.News;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private AdapterNews adapter;
    private ArrayList<News> listFire;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AdapterNews();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setAdapter(adapter);
        binding.fab.setOnClickListener(view1 -> {
            getToFirestore();
        });


    }

    private void getToFirestore() {
        FirebaseFirestore.getInstance().collection("news")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot list : queryDocumentSnapshots) {
                        News news = new News();
                        news = list.toObject(News.class);
                        adapter.addItem(news);
                        //System.out.println(" --------- " + list.getData().get("title"));

                    }
                });
    }
}