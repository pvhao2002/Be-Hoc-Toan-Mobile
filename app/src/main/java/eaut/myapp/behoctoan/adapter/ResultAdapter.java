package eaut.myapp.behoctoan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.DateFormat;
import java.util.ArrayList;

import eaut.myapp.behoctoan.R;
import eaut.myapp.behoctoan.model.Result;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {
    ArrayList<Result> results;
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    public ResultAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_result, parent, false);
        return new ResultViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Result result = results.get(position);
        holder.textViewRs.setText(result.getScore() + "/" + result.getTotalQuestions());
        holder.textViewDateRs.setText(dateFormat.format(result.getDate()));
        holder.textViewNameRs.setText(result.getName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRs, textViewDateRs, textViewNameRs;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRs = itemView.findViewById(R.id.textViewRs);
            textViewDateRs = itemView.findViewById(R.id.textViewDateRs);
            textViewNameRs = itemView.findViewById(R.id.textViewNameRs);
        }
    }
}
