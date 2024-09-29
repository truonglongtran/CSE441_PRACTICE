package com.example.prac03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private Context context;
    private List<Country> countryList;
    private OnCountryClickListener listener;

    public CountryAdapter(Context context, List<Country> countryList, OnCountryClickListener listener) {
        this.context = context;
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);

        // Set data for each item
        holder.flagImgView.setImageResource(country.getFlagResId());
        holder.countryTextNameView.setText(country.getName());
        holder.capitalTextView.setText(country.getCapital());

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCountryClick(country);
            }
        });
    }

    @Override
    public int getItemCount(){
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImgView;
        TextView countryTextNameView;
        TextView capitalTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImgView = itemView.findViewById(R.id.flagImgView);
            countryTextNameView = itemView.findViewById(R.id.countryTextNameView);
            capitalTextView = itemView.findViewById(R.id.capitalTextView);
        }
    }

    public interface OnCountryClickListener {
        void onCountryClick(Country country);
    }
}
