package com.example.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.jetbrains.annotations.NotNull;

public class ListFrag extends ListFragment {

    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull @org.jetbrains.annotations.NotNull Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_list_item_1, data));

        if (this.getActivity().findViewById(R.id.layout_land) != null){
            activity.onItemSelected(0);
        }
    }

    @Override
    public void onListItemClick(@NonNull @NotNull ListView l, @NonNull @NotNull View v, int position, long id) {

        activity.onItemSelected(position);

    }
}