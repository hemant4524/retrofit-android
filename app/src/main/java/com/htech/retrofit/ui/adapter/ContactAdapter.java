package com.htech.retrofit.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htech.retrofit.R;
import com.htech.retrofit.model.Contact;
import com.htech.retrofit.ui.callback.ContactClickCallback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by software on 7/3/18.
 */

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.MyHolder>{

    private List<Contact> contactList;
    private Context context;
    private ContactClickCallback contactClickCallback;
    // Constructors
    public ContactAdapter(Context context, List<Contact> objects,ContactClickCallback contactClickCallback) {
        this.context = context;
        contactList = objects;
        this.contactClickCallback = contactClickCallback;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_list_row, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final Contact item = contactList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactClickCallback.onClick(item);
            }
        });


        holder.textViewName.setText(item.getName());
        holder.textViewEmail.setText(item.getEmail());
        Picasso.with(context).load(item.getProfilePic()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);

    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewEmail;
        public MyHolder(View itemView) {
            super(itemView);
             imageView = (ImageView) itemView.findViewById(R.id.imageView);
             textViewName = (TextView) itemView.findViewById(R.id.textViewName);
             textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
        }
    }
}
