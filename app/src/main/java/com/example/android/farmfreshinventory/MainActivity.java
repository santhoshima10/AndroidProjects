package com.example.android.farmfreshinventory;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.farmfreshinventory.data.ProductAdapter;
import com.example.android.farmfreshinventory.data.ProductContract;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{


    private static final int CURSOR_LOADER_ID = 1;
    String[] projection;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addProductBtn = (FloatingActionButton)findViewById(R.id.add_new_product_btn_id);
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,EditorActivity.class);
                startActivity(intent);

            }
        });

        productAdapter = new ProductAdapter(this,null);
        getSupportLoaderManager().initLoader(1,null,this);

        ListView listView = (ListView) findViewById(R.id.list_view_id);
        View emptyView = (View)findViewById(R.id.empty_view_id);
        listView.setAdapter(productAdapter);
        if(productAdapter.getCount()==0){
            listView.setEmptyView(emptyView);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,EditorActivity.class);
                intent.setData(Uri.withAppendedPath(ProductContract.ProductEntry.CONTENT_URI,String.valueOf(id)));
                startActivity(intent);



            }
        });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.insert_test_data_id:
                mInsertTestData();
              return true;

            case R.id.delete_all_product_id:
                mDeleteAllProductsData();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void mDeleteAllProductsData(){

        int delete_count = getContentResolver().delete(ProductContract.ProductEntry.CONTENT_URI,null,null);
        if(delete_count > 0 ){

            Toast.makeText(this,"Products Deleted"+ProductContract.ProductEntry.CONTENT_URI.toString(),Toast.LENGTH_SHORT);

        }
        else {

            Toast.makeText(this,"Error in Products Delete"+ProductContract.ProductEntry.CONTENT_URI.toString(),Toast.LENGTH_SHORT);


        }

    }

    private void mInsertTestData(){

        ContentValues values;
        Uri imageUri;
        Uri uriInsert;



        values = new ContentValues();
        imageUri = getUriToDrawable(this,R.drawable.carrot);

        System.out.println("Inside the InserttestData ++++"+imageUri.toString());
        values.put("product_name","Carrot");
        values.put("product_unit_price","15");
        values.put("product_quantity","10");
        values.put("product_supplier_name","Richard");
        values.put("product_supplier_phone","123345678");
        values.put("product_supplier_email","richard@grofers.com");
        values.put("product_image_uri",imageUri.toString());


         getContentResolver().insert(ProductContract.ProductEntry.CONTENT_URI,values);



        values = new ContentValues();

        imageUri = getUriToDrawable(this,R.drawable.beet);

        System.out.println("Inside the InserttestData ++++"+imageUri.toString());
        values.put("product_name","Beet Root");
        values.put("product_unit_price","11");
        values.put("product_quantity","10");
        values.put("product_supplier_name","Henry");
        values.put("product_supplier_phone","123345678");
        values.put("product_supplier_email","henry@grofers.com");
        values.put("product_image_uri",imageUri.toString());

        getContentResolver().insert(ProductContract.ProductEntry.CONTENT_URI,values);



        values = new ContentValues();

        imageUri = getUriToDrawable(this,R.drawable.eggplant);

        System.out.println("Inside the InserttestData ++++"+imageUri.toString());
        values.put("product_name","Eggplant");
        values.put("product_unit_price","12");
        values.put("product_quantity","10");
        values.put("product_supplier_name","Henry");
        values.put("product_supplier_phone","123345678");
        values.put("product_supplier_email","henry@grofers.com");
        values.put("product_image_uri",imageUri.toString());

        getContentResolver().insert(ProductContract.ProductEntry.CONTENT_URI,values);





        values = new ContentValues();

        imageUri = getUriToDrawable(this,R.drawable.lettuce);

        System.out.println("Inside the InserttestData ++++"+imageUri.toString());
        values.put("product_name","Lettuce");
        values.put("product_unit_price","10");
        values.put("product_quantity","10");
        values.put("product_supplier_name","Henry");
        values.put("product_supplier_phone","123345678");
        values.put("product_supplier_email","henry@grofers.com");
        values.put("product_image_uri",imageUri.toString());

        getContentResolver().insert(ProductContract.ProductEntry.CONTENT_URI,values);



        values = new ContentValues();

        imageUri = getUriToDrawable(this,R.drawable.onion);

        System.out.println("Inside the InserttestData ++++"+imageUri.toString());
        values.put("product_name","Onion");
        values.put("product_unit_price","16");
        values.put("product_quantity","10");
        values.put("product_supplier_name","Henry");
        values.put("product_supplier_phone","123345678");
        values.put("product_supplier_email","henry@grofers.com");
        values.put("product_image_uri",imageUri.toString());

        getContentResolver().insert(ProductContract.ProductEntry.CONTENT_URI,values);



      /*  if (uri!=null){
            Toast.makeText(this,"data inserted"+uri.toString(),Toast.LENGTH_LONG);
        }
        else{
            Toast.makeText(this,"error in insertion",Toast.LENGTH_LONG);
        }*/



    }

    public static final Uri getUriToDrawable(@NonNull Context context,
                                             @AnyRes int drawableId) {


        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId) );
        return imageUri;



    }


    @NonNull
    @Override
    public CursorLoader onCreateLoader(int id, @Nullable Bundle args) {

        projection = new String[]{
                BaseColumns._ID,
                ProductContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME,
                ProductContract.ProductEntry.COLUMN_NAME_PRODUCT_QUANTITY,
                ProductContract.ProductEntry.COLUMN_NAME_PRODUCT_UNIT_PRICE,
                ProductContract.ProductEntry.COLUMN_NAME_PRODUCT_IMAGE_URI
        };

        return new CursorLoader(this, ProductContract.ProductEntry.CONTENT_URI,projection,null,null,null) ;
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, Cursor data) {

        productAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

        productAdapter.swapCursor(null);
    }
}
