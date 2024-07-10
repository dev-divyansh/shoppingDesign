package com.divyansh.assignmentshopping.DATA.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.assignmentshopping.DATA.Models.Products;
import com.divyansh.assignmentshopping.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class productsAdapter extends RecyclerView.Adapter<productsAdapter.veiwHolder> {
    Context context;
    List<Products> productsData;
    onProductClick onClickListener;

    public productsAdapter(Context context, List<Products> productsData , onProductClick onClickListener) {
        this.context = context;
        this.productsData = productsData;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public veiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_cart_item_layout , parent , false);
        return new veiwHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull veiwHolder holder, int position) {

        // setting product details
        Products currentProduct = productsData.get(position);
        holder.productName.setText(currentProduct.getProductName());
        holder.productDescription.setText(currentProduct.getProductDescription());
        holder.productPrice.setText(String.valueOf("Rs " + currentProduct.getDiscountPrice()));
        holder.productMRP.setText(String.valueOf("Rs " + currentProduct.getProductMRP()));

        // setting product colors
        List<String> colors = currentProduct.getColors();
        holder.color1.setBackgroundColor(Color.parseColor(colors.get(0)));
        holder.color2.setBackgroundColor(Color.parseColor(colors.get(1)));
        holder.color3.setBackgroundColor(Color.parseColor(colors.get(2)));

        // setting product image
        Picasso.get().load(currentProduct.getProductImage()).into(holder.productImage);

        holder.productCardLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onItemClick(currentProduct);
            }
        });

        //  striking off mrp
        holder.productMRP.setPaintFlags(holder.productMRP.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }


    @Override
    public int getItemCount() {
        return productsData.size();
    }

    public class veiwHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productDescription;
        ImageView productImage;
        TextView productMRP;
        TextView productPrice;
        Button color1;
        Button color2;
        Button color3;
        LinearLayout productCardLinearLayout;
        public veiwHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_title);
            productDescription = itemView.findViewById(R.id.product_description);
            productImage = itemView.findViewById(R.id.product_image);
            productMRP = itemView.findViewById(R.id.product_mrp);
            productPrice = itemView.findViewById(R.id.product_discount_price);
            color1 = itemView.findViewById(R.id.product_color_1);
            color2 = itemView.findViewById(R.id.product_color_2);
            color3 = itemView.findViewById(R.id.product_color_3);
            productCardLinearLayout = itemView.findViewById(R.id.linear_layout_product_card);
        }
    }

    public interface onProductClick{
        void onItemClick(Products products);
    }
}
