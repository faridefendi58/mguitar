package net.kuncilagu.kuncigitar.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kuncilagu.kuncigitar.R;
import net.kuncilagu.kuncigitar.adapter.AdapterListGenre;
import net.kuncilagu.kuncigitar.data.DataGenerator;
import net.kuncilagu.kuncigitar.model.GenreModel;
import net.kuncilagu.kuncigitar.utils.SpacingItemDecoration;
import net.kuncilagu.kuncigitar.utils.Tools;

import java.util.List;

public class GenreFragment extends Fragment {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterListGenre mAdapter;

    public GenreFragment() {
    }

    public static GenreFragment newInstance() {
        GenreFragment fragment = new GenreFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent_view = inflater.inflate(R.layout.fragment_tabs_genre, container, false);

        initComponent();
        return parent_view;
    }

    private void initComponent() {
        recyclerView = (RecyclerView) parent_view.findViewById(R.id.genre_recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getContext(), 3), true));
        recyclerView.setHasFixedSize(true);

        List<GenreModel> items = DataGenerator.getGenreModel(getContext());
        items.addAll(DataGenerator.getGenreModel(getContext()));
        items.addAll(DataGenerator.getGenreModel(getContext()));
        items.addAll(DataGenerator.getGenreModel(getContext()));

        //set data and list adapter
        mAdapter = new AdapterListGenre(getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListGenre.OnItemClickListener() {
            @Override
            public void onItemClick(View view, GenreModel obj, int position) {
                Snackbar.make(parent_view, obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
