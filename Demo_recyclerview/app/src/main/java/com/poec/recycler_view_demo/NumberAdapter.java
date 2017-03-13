package com.poec.recycler_view_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    private List<Integer> numbers;
    private Context context;

    public NumberAdapter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_number_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(String.format(Locale.getDefault(), "%d", numbers.get(position)));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.tvNumber);
        }
    }
}
