package com.example.basicprogramming.retrofitappdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicprogramming.retrofitappdemo.R;
import com.example.basicprogramming.retrofitappdemo.model.Users;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.JsonHolder> {

    private Context context;
    private List<Users> usersList;
    private LayoutInflater inflater;

    public UserAdapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public JsonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = inflater.inflate(R.layout.user_list_layout, viewGroup, false);
        JsonHolder jsonHolder = new JsonHolder(view);
        return jsonHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JsonHolder viewHolder, int position) {

        Users users = usersList.get(position);
        viewHolder.first_name.setText(users.getFirstName() + " " + users.getLastName());
        viewHolder.email_id.setText(users.getEmailId());
        viewHolder.user_age.setText("Age " + users.getAge());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class JsonHolder extends RecyclerView.ViewHolder {

        private TextView first_name, email_id, user_age;

        public JsonHolder(@NonNull View itemView) {
            super(itemView);

            first_name = itemView.findViewById(R.id.first_name_text_view);
            email_id = itemView.findViewById(R.id.email_id_text_view);
            user_age = itemView.findViewById(R.id.age_text_view);
        }
    }
}
