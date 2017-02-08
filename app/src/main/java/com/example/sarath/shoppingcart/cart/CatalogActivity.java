package com.example.sarath.shoppingcart.cart;

/**
 * Created by sarath on 1/18/2017.
 */

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.sarath.shoppingcart.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CatalogActivity extends Activity {

    private List<Product> mProductList=new ArrayList<>();
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ProductAdapter productAdptor;

    /** Called when the activity is first created. */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);


        // Write a message to the database
         database = FirebaseDatabase.getInstance();
         databaseReference = database.getReference("product");

        addDumy();


        // Obtain a reference to the product catalog
        //mProductList = ShoppingCartHelper.getCatalog();

        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);


        productAdptor=new ProductAdapter(this,ShoppingCartHelper.getCatalog() , getLayoutInflater(), false);
        listViewCatalog.setAdapter(productAdptor);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });
        retrive();

    }

    void addDumy(){
        Toast.makeText(CatalogActivity.this, "addd", Toast.LENGTH_SHORT).show();
        Product product=new Product("title","des",Math.random()*1000,"http://square.github.io/picasso/static/icon-github.png");
        databaseReference.push().setValue(product).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(CatalogActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
            }
        });

    }


    void retrive(){
        Log.d("testmy", "detailde ");
        // Read from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSt : dataSnapshot.getChildren()) {
                    Product product = dataSt.getValue(Product.class);
                    mProductList.add(product);

                    Log.d("testmy", "onDataChange: "+product.toString());


                }

                productAdptor.swapList(mProductList);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Log.d("testmy", "fildeef ");


            }
        });
    }
}
