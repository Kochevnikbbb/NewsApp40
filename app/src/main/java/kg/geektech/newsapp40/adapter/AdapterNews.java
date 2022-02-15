package kg.geektech.newsapp40.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import kg.geektech.newsapp40.databinding.ItemNewsBinding;
import kg.geektech.newsapp40.models.News;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.CountViewHolder> {
    private ItemNewsBinding binding;
    ArrayList<News> news;

    public AdapterNews(ArrayList<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public CountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new CountViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountViewHolder holder, int position) {
holder.bind(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    static class CountViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;

        public CountViewHolder(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(News news) {
            String time = (String) android.text.format.DateFormat.format("HH:mm dd MMM yyyy", new Date(news.getCreteAt()));
            binding.textItemNews.setText(news.getTitle());
            binding.timeItemNews.setText(time);

        }
    }
}
