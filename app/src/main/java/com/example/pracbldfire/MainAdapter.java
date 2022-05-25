package com.example.pracbldfire;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainAdapter extends FirebaseRecyclerAdapter<MainModel,MainAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull MainModel model) {
        holder.name.setText("name: "+model.getName());
        holder.blood.setText("blood group: "+model.getBlood());
        holder.location.setText("location: "+model.getLocation());
        holder.contact.setText("contact: "+model.getContact());
        holder.name.setTextColor(Color.parseColor("#bdbdbd"));



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,contact,blood,location;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txtname);
            blood = (TextView) itemView.findViewById(R.id.txtblood);
            location = (TextView) itemView.findViewById(R.id.txtlocation);
            contact=(TextView) itemView.findViewById(R.id.txtphone);



        }
    }
}
