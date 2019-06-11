package com.bankmandiri.helloandroid2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toolbar;

import com.bankmandiri.helloandroid2.adapter.TodoAdapter;
import com.bankmandiri.helloandroid2.databinding.ActivityMainBinding;
import com.bankmandiri.helloandroid2.dialog.AddDialog;
import com.bankmandiri.helloandroid2.dialog.AddDialogListener;
import com.bankmandiri.helloandroid2.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddDialogListener, View.OnClickListener {

    TodoAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        /*line 39 : terakhir dipake pas saat toolbar dan bikin icon setting + button add di toolbar*/
        initList();

        /*add = id Button ADD. Jadi line ini intinya nge-binding button itu*/
        binding.add.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_add:
                add();
                return true;
            case R.id.menu_setting:
                setting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void add(){
        Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
        AddDialog dialog = new AddDialog(this);
        dialog.show();
    }

    private void setting(){
        Toast.makeText(this,"Setting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdd(String name){
        adapter.add(new Todo(name, true));
    }

    private void initList() {
        /*KALO MAU LIST ANKA DAN ALIYA DARI AWAL GAADA, DIHAPUS AJA*/
        List<Todo> users = new ArrayList<>();
        users.add(new Todo("anka", false));
        users.add(new Todo("aliya", true));

        /*Line 87 dipake KALO line 82-84 dihapus, meaning listnya nanti dari awal kosong. TAPI HARUS masukkin line 87*/
        //adapter = new TodoAdapter(new ArrayList<Todo>());

        adapter = new TodoAdapter(users);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.binding.mainRcvTodo.setLayoutManager(layoutManager);
        this.binding.mainRcvTodo.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            adapter.add(new Todo(binding.todo.getText().toString(),binding.done.isChecked()));
            binding.todo.setText("");
        }

    }
}
