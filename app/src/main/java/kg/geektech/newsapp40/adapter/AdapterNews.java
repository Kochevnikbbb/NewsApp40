package kg.geektech.newsapp40.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kg.geektech.newsapp40.databinding.ItemNewsBinding;
import kg.geektech.newsapp40.models.News;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.CountViewHolder> {
    private ItemNewsBinding binding;
    private ArrayList<News> news;

    public AdapterNews(ArrayList<News> news) {
        this.news = news;
    }

    public AdapterNews() {
        news = new ArrayList<>();
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
        if (position % 2 == 0) {
            holder.binding.itemNews.setBackgroundColor(Color.YELLOW);
        } else {
            holder.binding.itemNews.setBackgroundColor(Color.WHITE);

        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void addItem(News newss) {
        news.add(0, newss);
        notifyItemInserted(0);
    }
    public void addItem(List<News> newsList){
        news=(ArrayList<News>) newsList;
        notifyDataSetChanged();
    }
    static class CountViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;


        public CountViewHolder(@NonNull ItemNewsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(News news) {
            String time = (String) android.text.format.DateFormat.format("HH:mm:ss  dd MMM yyyy", new Date(news.getCreteAt()));
            binding.textItemNews.setText(news.getTitle());
            binding.timeItemNews.setText(time);
        }
    }
}
