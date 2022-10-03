package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

// bài 1
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        toolbar.setLogo(R.mipmap.apple);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        // bài 4
        ListView lv = findViewById(R.id.lv);

        list = new String[]{"cam","quýt","ổi","mận"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

        // bài 5
        Button bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,bt);
                getMenuInflater().inflate(R.menu.menu_potup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuOne:
                                Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menuTwo:
                                Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menuThree:
                                Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }


    // bài 3
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuHome:
                Toast.makeText(this, "Trang chu", Toast.LENGTH_SHORT).show();
                break;
                case R.id.menuSp:
                Toast.makeText(this, "san pham", Toast.LENGTH_SHORT).show();
                break;
                case R.id.menuGt:
                Toast.makeText(this, "gioi thieu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // bài 4
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = info.position;
        switch (item.getItemId()){
            case R.id.menuAdd:
                Toast.makeText(this, "Thêm - "+ list[vitri], Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuDelete:
                Toast.makeText(this, "Xóa - "+ list[vitri], Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuUpdate:
                Toast.makeText(this, "Sửa - "+ list[vitri], Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);

    }
}