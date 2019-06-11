package com.bankmandiri.helloandroid2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.bankmandiri.helloandroid2.R;
import com.bankmandiri.helloandroid2.databinding.ItemTodoBinding;
import com.bankmandiri.helloandroid2.model.Todo;

public class TodoViewHolder extends RecyclerView.ViewHolder {

    private ItemTodoBinding binding;
    public TodoViewHolder(@NonNull ItemTodoBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Todo todo) {
        binding.setTodo(todo);
    }
}