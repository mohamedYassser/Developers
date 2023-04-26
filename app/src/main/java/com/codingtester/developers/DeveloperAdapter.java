package com.codingtester.developers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    private final List<Developer> developerList;
    private final DeleteDeveloper deleteDeveloper;

    public DeveloperAdapter(List<Developer> developerList, DeleteDeveloper deleteDeveloper) {
        this.developerList = developerList;
        this.deleteDeveloper = deleteDeveloper;
    }

    @NonNull
    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dev_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperAdapter.ViewHolder holder, int position) {

        Developer currentDeveloper = developerList.get(position);
        holder.txtName.setText(currentDeveloper.getName());
        holder.txtSalary.setText(String.valueOf(currentDeveloper.getSalary()));
        holder.txtTitle.setText(currentDeveloper.getTitle());

        switch (currentDeveloper.getTitle()) {
            case "Fresh" : {
                holder.devImg.setImageResource(R.drawable.fresh);
                break;
            }
            case "Junior" : {
                holder.devImg.setImageResource(R.drawable.junior);
                break;
            }
            case "Mid" : {
                holder.devImg.setImageResource(R.drawable.mid);
                break;
            }
            case "Senior" : {
                holder.devImg.setImageResource(R.drawable.senior);
                break;
            }
        }

        // to remove developer when click on delete icon
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDeveloper.deleteDevById(currentDeveloper.getId());

                // to refresh and reload adapter after delete item
                developerList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), developerList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtSalary, txtTitle;
        ImageView devImg;
        ImageView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.devName);
            btnDelete = itemView.findViewById(R.id.);
            txtSalary = itemView.findViewById(R.id.devSalary);
            txtTitle = itemView.findViewById(R.id.devTitle);
            devImg = itemView.findViewById(R.id.devImg);
        }
    }
}
