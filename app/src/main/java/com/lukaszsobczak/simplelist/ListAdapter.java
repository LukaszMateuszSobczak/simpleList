package com.lukaszsobczak.simplelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<Integer> list;
    static public int counterMethodOnCreate;


    public ListAdapter(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        counterMethodOnCreate++;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_element, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView content;
        static public int counterMethodBind;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.content = itemView.findViewById(R.id.text_view_content);
        }

        public void bind(int number) {
            if (number == 101) {
                content.append("\nbind: " + counterMethodBind );
                content.append("\nonCreate: " + counterMethodOnCreate);
            } else {
                counterMethodBind++;
                content.setText("Pozycja numer: " + number);
            }
        }
    }
}
