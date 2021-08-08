package com.shoppingorder.adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shoppingorder.R;
import com.shoppingorder.model.OrderModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ConfirmViewHolder>
{

    CardView parentCard;

    DatabaseReference removeRefrance;

    ArrayList<OrderModel> orderModels;

    public OrderAdapter(ArrayList<OrderModel> orderModels)
    {
        this.orderModels = orderModels;
    }

    @NonNull
    @Override
    public ConfirmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        parentCard = view.findViewById(R.id.parent_confirm);
        removeRefrance = FirebaseDatabase.getInstance().getReference();
        return new ConfirmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmViewHolder holder, int position)
    {
       OrderModel model = orderModels.get(position);
       holder.textCategoryName.setText(model.getCategory_name());
//        final int code = getRandomColor();
//        holder.textUserName.setTextColor((holder.itemView.getResources().getColor(code , null)));
       holder.textCategoryPrice.setText(model.getCategory_price() + " £");
       holder.textCategoryNumberQuantity.setText(" الكمية:" + model.getNumber_quantity());
       Glide
                .with(holder.itemView.getContext())
                .load(model.getCategory_image())
                .into(holder.imageCategory);

    }

//    private int getRandomColor()
//    {
//        List<Integer> code_colors = new ArrayList<>();
//
//        code_colors.add(R.color.colorPrimary);
//        code_colors.add(R.color.colorAccent);
//        code_colors.add(R.color.blue);
//        code_colors.add(R.color.yellow);
//        code_colors.add(R.color.lightGreen);
//        code_colors.add(R.color.lightPurple);
//        code_colors.add(R.color.pink);
//        code_colors.add(R.color.skyblue);
//        code_colors.add(R.color.gray);
//        code_colors.add(R.color.red);
//        code_colors.add(R.color.greenlight);
//        code_colors.add(R.color.notgreen);
//
//        Random random_color = new Random();
//        int number = random_color.nextInt(code_colors.size());
//        return code_colors.get(number);
//    }

    @Override
    public int getItemCount()
    {
        return orderModels.size();
    }

    public class ConfirmViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView imageCategory;
        TextView textCategoryName, textCategoryPrice, textCategoryNumberQuantity;

        public ConfirmViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageCategory = itemView.findViewById(R.id.item_img_category);
            textCategoryName = itemView.findViewById(R.id.item_txt_category_name);
            textCategoryPrice = itemView.findViewById(R.id.item_txt_category_price);
            textCategoryNumberQuantity = itemView.findViewById(R.id.item_txt_category_number_quantity);
        }
    }
}
