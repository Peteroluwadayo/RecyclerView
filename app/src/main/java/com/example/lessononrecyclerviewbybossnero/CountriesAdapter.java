package com.example.lessononrecyclerviewbybossnero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter  extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private  final Context  context;
    private  final List<CountriesModel> countriesModelList;
    private  final AdapterClickInterface adapterClickInterface;




    public CountriesAdapter(Context context,List<CountriesModel>countriesModelList){
        this.context = context;
        this.countriesModelList = countriesModelList;
        this.adapterClickInterface = (AdapterClickInterface) context;
    }

    @NonNull
    @Override
    public CountriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View myView = layoutInflater.inflate(R.layout.countriesitem,parent,false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.ViewHolder holder, int position) {
        CountriesModel  countriesModel = countriesModelList.get(position);

        holder.countryNameTv.setText(countriesModel.getName());
        holder.countryDescriptionTv.setText(countriesModel.getDescription());
        holder.continentTv.setText(countriesModel.getContinent());

        Glide.with(context).load(countriesModel.getCountryImage()).into(holder.countryImageView);


       // holder.itemView.setOnClickListener(v->adapterClickInterface.handleClickItem(countriesModelList.get(index)));

    }

    @Override
    public int getItemCount() {
        return countriesModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView countryNameTv,countryDescriptionTv,continentTv;
        private ImageView countryImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            countryDescriptionTv = itemView.findViewById(R.id.description_tv);
            countryNameTv = itemView.findViewById(R.id.country_name_tv);
            continentTv = itemView.findViewById(R.id.continent_tv);
            countryImageView = itemView.findViewById(R.id.country_image_iv);

            itemView.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View v){
            // now you can catch events here on click
        //   CountriesModel countriesModel = countriesModelList.get(getAdapterPosition());
        //  Toast.makeText(context, "Item clicked is" + countriesModel.getName(), Toast.LENGTH_SHORT).show();

        //   Intent intent = new Intent(context,DetailActivity.class);
       //     intent.putExtra("name",countriesModel.getName());
        //   intent.putExtra("continent",countriesModel.getContinent());
        //    intent.putExtra("description",countriesModel.getDescription());
        //   intent.putExtra("image",countriesModel.getCountryImage());
        //   context.startActivity(intent);
            adapterClickInterface.handleClickItem(countriesModelList.get(getAdapterPosition()));
        }
    }
}

